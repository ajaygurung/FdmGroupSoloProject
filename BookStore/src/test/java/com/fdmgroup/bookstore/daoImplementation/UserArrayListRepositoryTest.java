package com.fdmgroup.bookstore.daoImplementation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fdmgroup.bookstore.model.User;

class UserArrayListRepositoryTest {
	UserArrayListRepository repository;
	List<User> userList;

	@BeforeEach
	void setUp() throws Exception {
		User user1 = new User(2,"Ajay","Gurung","Ajay","12345","aa@yahoo.com");
		User user2 = new User(4,"Shank","Bahadur","Shank","567890","ss@yahoo.com");
		User user3 = new User(10,"Luffy","Torpe","Torpe","11325","ll@yahoo.com");

		 userList= new ArrayList<>(Arrays.asList(user1,user2,user3));
		 repository = new UserArrayListRepository(userList);

	}

	@Test
	void test_validateMethod_ReturnFalseWhenPassedTheUserListIsEmpty() {
		UserArrayListRepository userArrayListRepository = new UserArrayListRepository();
		boolean isValid = userArrayListRepository.validatte("Ajay", "12345");
		assertFalse(isValid);
	}
	
	@Test
	void test_validateMethod_ReturnFalseWhenPassedThewrongUsernameorPassword() {
		boolean isValid = repository.validatte("Aj", "12345");
		assertFalse(isValid);
	}
	
	@Test
	void test_validateMethod_ReturnTrueWhenPassedTheExistingUsernameAndPassword() {
		boolean isValid = repository.validatte("Ajay", "12345");
		assertTrue(isValid);
	}

	@Test
	void test_findByUsername_ReturnNullWhenPassedNonExistantUserName() {
		User user = repository.findByUsername("Shristi");
		assertNull(user);
	}
	
	@Test
	void test_findByUsername_ReturnTheUserDetailsWhenPassedExistantUserName() {
		User user = repository.findByUsername("Ajay");
		assertNotNull(user);
	}
	
	@Test
	void test_saveMethod_SaveTheUserInTheUserList_WhenPassedNotExistantUser() {
		User u = new User("Shristi","Darlami","Shristi","25984","sh@gmail.com");
		int currentListSize = userList.size();
		repository.save(u);
		assertEquals(currentListSize+1,repository.findAll().size());
	}
	
	@Test
	void test_saveMethod_UpdateTheUserInTheUserList_WhenPassedExistantUser() {
		User u = new User(2,"Ajay","Gurung","Ajay","12345","aa@yahoo.com");
		int currentListSize = userList.size();
		repository.save(u);
		assertEquals(currentListSize,repository.findAll().size());
	}
	
	@Test
	void test_removeMethod_ReturnTheArrayListSizeSame_WhenPassedTheNonExistantUser() {
		User u = new User("Shristi","Darlami","Shristi","25984","sh@gmail.com");
		int currentListSize = userList.size();
		repository.delete(u);
		assertEquals(currentListSize, repository.findAll().size());
	}
	
	@Test
	void test_removeMethod_ReturnTheArrayListSizeLessThanTheCurrntSize_WhenPassedTheExistantUser() {
		User u = new User(2,"Ajay","Gurung","Ajay","12345","aa@yahoo.com");
		int currentListSize = userList.size();
		repository.delete(u);
		assertNotEquals(currentListSize, repository.findAll().size());
	}
	
	@Test
	void test_generateIDMethod_ReturnNextIDWhenCalled() {
		assertEquals(2, UserArrayListRepository.generateId());
		assertEquals(3, UserArrayListRepository.generateId());
		assertEquals(4, UserArrayListRepository.generateId());
		assertEquals(5, UserArrayListRepository.generateId());

	}
	
	@Test
	void test_findByIdMethod_ReturnNullIfUserIdDoesnotExist() {
		User matchUser = repository.findById(12);
		assertEquals(null, matchUser);
	}
	
	@Test
	void test_findByIdMethod_ReturnMatchedUser_WhenPassedAMatchedUserId() {
		User matchUser = repository.findById(2);
		assertNotNull(matchUser);
	}
	
	@Test
	void test_findAll_ReturnEmptyListIfThereIsNoUserList() {
		UserArrayListRepository r= new UserArrayListRepository();
		assertEquals(0,r.findAll().size());
	}
	
	@Test
	void test_findAll_ReturnListOfUserList() {
		assertEquals(userList, repository.findAll());
	}
	
}
