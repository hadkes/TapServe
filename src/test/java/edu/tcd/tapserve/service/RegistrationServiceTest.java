package edu.tcd.tapserve.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.tcd.tapserve.bean.Administrator;
import edu.tcd.tapserve.bean.Credentials;
import edu.tcd.tapserve.bean.Role;
import edu.tcd.tapserve.bean.ServiceProvider;
import edu.tcd.tapserve.bean.ServiceToProviderMapper;
import edu.tcd.tapserve.bean.User;
import edu.tcd.tapserve.repository.AdministratorRepository;
import edu.tcd.tapserve.repository.CredentialsRepository;
import edu.tcd.tapserve.repository.RoleRepository;
import edu.tcd.tapserve.repository.ServiceProviderRepository;
import edu.tcd.tapserve.repository.ServiceToProviderMapperRepository;
import edu.tcd.tapserve.repository.UserRepository;

public class RegistrationServiceTest {

	@Mock
	private CredentialsRepository mockedCredentialsRepository;

	@Mock
	private UserRepository mockedUserRepository;

	@Mock
	private ServiceProviderRepository mockedServiceProviderRepository;

	@Mock
	private RoleRepository mockedRoleRepository;

	@Mock
	private ServiceToProviderMapperRepository mockedMapperRepository;
	
	@Mock
	private AdministratorRepository mockedAdministratorRepository;

	@InjectMocks
	RegistrationService registrationService = new RegistrationService();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddCredentials() {
		Credentials credentials = new Credentials();
		credentials.setActorId("abc");
		credentials.setId("abc_id");
		credentials.setPassword("abc_pass");
		credentials.setUsername("abc.username");
		Mockito.when(mockedCredentialsRepository.save(credentials)).thenReturn(credentials);
		assertEquals(36, registrationService.addCredentials(credentials).length());
	}

	@Test
	public void testAddUser() {
		User user = new User();
		Role role = new Role();
		role.setName("USER");
		Mockito.when(mockedUserRepository.save(user)).thenReturn(user);
		Mockito.when(mockedRoleRepository.findByName(Mockito.any(String.class))).thenReturn(role);
		assertEquals("USER", registrationService.addUser(user).getRole().getName());
	}

	@Test
	public void testAddServiceProvider() {
		ServiceProvider sp = new ServiceProvider();
		Role role = new Role();
		role.setName("SERVICE_PROVIDER");
		Mockito.when(mockedServiceProviderRepository.save(sp)).thenReturn(sp);
		Mockito.when(mockedRoleRepository.findByName(Mockito.any(String.class))).thenReturn(role);
		Mockito.when(mockedMapperRepository.save(Mockito.any(ServiceToProviderMapper.class)))
				.thenReturn(new ServiceToProviderMapper());
		assertEquals("SERVICE_PROVIDER", registrationService.addServiceProvider(sp).getRole().getName());
	}
	
	@Test
	public void testAddAdministrator() {
		Administrator administrator = new Administrator();
		Role role = new Role();
		role.setName("ADMIN");
		Mockito.when(mockedAdministratorRepository.save(administrator)).thenReturn(administrator);
		Mockito.when(mockedRoleRepository.findByName(Mockito.any(String.class))).thenReturn(role);
		assertEquals("ADMIN", registrationService.addAdministrator(administrator).getRole().getName());
	}

}
