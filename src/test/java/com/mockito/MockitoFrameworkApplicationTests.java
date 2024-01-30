/*
@author :: Abhishek Gaurav
*/

package com.mockito;

import com.mockito.model.User;
import com.mockito.repository.UserRepository;
import com.mockito.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MockitoFrameworkApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsers(){
		List<User> userList = Stream.of(
				new User(101, "Tatiana", 30, "London"),
				new User(102,"Grace",32, "Bermingham"),
				new User(103, "Thomas", 35, "Bermingham"))
				.collect(Collectors.toList());

		when(repository.findAll()).thenReturn(userList);
		assertEquals(3,service.getUsers().size());
	}

	@Test
	public void getUserbyAddressTest() {
		String address = "Bangalore";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new User(101, "Tatiana", 30, "London"),
						new User(102,"Grace",32, "Bermingham"))
						.collect(Collectors.toList()));

		assertEquals(2, service.getUserbyAddress(address).size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(999, "Arthur", 33, "Black Heath");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(999, "Arthur", 33, "Black Heath");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}

}
