package com.asm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.asm.entity.User;
import com.asm.exception.AuthenticationFailedException;
import com.asm.exception.UserNotFoundException;
import com.asm.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	 void testGetUserById() {
	
	    User user = new User();
		user.setUserId(10);
		user.setUserName("Ram");
		user.setUserMobile(99999999);
		user.setUserEmail("ram@gmail.com");
		user.setUserAddress("Hyderabad");
		user.setPassword("ram123");
		user.setUserRole("Manager");
		
		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(10)).thenReturn(optionalUser); 		
		
		User myUser=userService.getUserById(10);
		assertEquals("Ram",myUser.getUserName());
    }
	@Test
	 void testGetUserByIdWithException() {
		when(userRepository.findById(10)).thenThrow(UserNotFoundException.class);
		
		assertThrows(UserNotFoundException.class,()->userService.getUserById(10));
	}
	
	@Test
	 void testGetAllUserByPosition() {
		
        User user = new User();
		
		user.setUserId(10);
		user.setUserName("Ram");
		user.setUserMobile(900900909);
		user.setUserEmail("ram@gmail.com");
		user.setUserAddress("Hyderabad");
		user.setPassword("ram123");
		user.setUserRole("Warehousr Manager");

		User user1 = new User();

		user1.setUserId(11);
		user1.setUserName("Sai");
		user1.setUserMobile(888888666);
		user1.setUserEmail("sai@gmail.com");
		user1.setUserAddress("chennai");
		user1.setPassword("sai123");
		user1.setUserRole("General User");

		User user2 = new User();

		user2.setUserId(12);
		user2.setUserName("Krishna");
		user2.setUserMobile(777800000);
		user2.setUserEmail("krishna@gmail.com");
		user2.setUserAddress("Mubai");
		user2.setPassword("krishna123");
		user2.setUserRole("Administrator");

		List<User> userList = new ArrayList<>();
		userList.add(user2);
		userList.add(user1);
		userList.add(user);

        when(userRepository.findByUserRole("General User")).thenReturn(userList);
		
		List<User> userByRole = userService.getAllUserByRole("General User");
		
		assertEquals(3,userByRole.size());

		
	}
	
	@Test
	 void testGetAllUser() {
		
		User user = new User();
		
		user.setUserId(10);
		user.setUserName("Ram");
		user.setUserMobile(900900909);
		user.setUserEmail("ram@gmail.com");
		user.setUserAddress("Hyderabad");
		user.setPassword("ram123");
		user.setUserRole("Warehousr Manager");

		User user1 = new User();

		user1.setUserId(11);
		user1.setUserName("Sai");
		user1.setUserMobile(888888666);
		user1.setUserEmail("sai@gmail.com");
		user1.setUserAddress("chennai");
		user1.setPassword("sai123");
		user1.setUserRole("General User");


		User user2 = new User();

		user2.setUserId(12);
		user2.setUserName("Krishna");
		user2.setUserMobile(777800000);
		user2.setUserEmail("krishna@gmail.com");
		user2.setUserAddress("Mubai");
		user2.setPassword("krishna123");
		user2.setUserRole("Administrator");

		List<User> userList = new ArrayList<>();
		userList.add(user2);
		userList.add(user1);
		userList.add(user);
		
		when(userRepository.findAll()).thenReturn(userList);
		
		List<User> users = userService.getAllUser();
		
		assertEquals(3,users.size());
		
	}
	
	
	
	
	@Test
	 void testSaveUser() {
		
        User user = new User();
		
        user.setUserId(10);
		user.setUserName("Ram");
		user.setUserMobile(900900909);
		user.setUserEmail("ram@gmail.com");
		user.setUserAddress("Hyderabad");
		user.setPassword("ram123");
		user.setUserRole("Warehousr Manager");
		
		when(userRepository.save(user)).thenReturn(user);
		
		User newUser = userService.saveUser(user);
		
		assertEquals("Ram",newUser.getUserName());
		
		verify(userRepository,times(1)).save(user);
	}
	
	@Test
	 void DeleteUserById() {
		User user = new User();
		user.setUserId(10);
		user.setUserName("Ram");
		user.setUserMobile(900900909);
		user.setUserEmail("ram@gmail.com");
		user.setUserAddress("Hyderabad");
		user.setPassword("ram123");
		user.setUserRole("Warehousr Manager");
		
		Optional<User> optionalUser = Optional.of(user);
		
		when(userRepository.findById(10)).thenReturn(optionalUser); 
		
		userService.deleteUserById(10);
		verify(userRepository,times(1)).findById(10);
		verify(userRepository,times(1)).deleteById(10);	

	}
	
	
	@Test
	 void testUpdateUser() {
		
		User user = new User();
		user.setUserId(10);
		user.setUserName("sri");
		user.setUserMobile(90090099);
		user.setUserEmail("sri@gmail.com");
		user.setUserAddress("Hyderabad");
		user.setPassword("sri123");
		user.setUserRole("Manager");

		Optional<User> optionalUser = Optional.of(user);
		when(userRepository.findById(10)).thenReturn(optionalUser);
		
		userService.updateUser(user);
		
		verify(userRepository, times(1)).findById(10);
		verify(userRepository, times(1)).save(user);
	}
	
	
	@Test
	void testDoLogin() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("Ram");
		user.setPassword("ram123");
		when(userRepository.login(user.getUserName(), user.getPassword(), user.getUserRole())).thenReturn(user);
		assertEquals("Ram", user.getUserName());
		assertEquals("ram123", user.getPassword());
	}
	
	@Test
	void testDoLoginException() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("Ram");
		user.setPassword("ram123");
		
		when(userRepository.login(user.getUserName(), user.getPassword(), user.getUserRole())).thenThrow(AuthenticationFailedException.class);
		assertThrows(AuthenticationFailedException.class,()->userService.doLogin(user.getUserName(), user.getPassword(), user.getUserRole()));
	}	
}
