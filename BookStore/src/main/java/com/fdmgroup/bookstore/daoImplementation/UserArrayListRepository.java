package com.fdmgroup.bookstore.daoImplementation;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.bookstore.data.UserRepository;
import com.fdmgroup.bookstore.model.User;

public class UserArrayListRepository implements UserRepository{
	
    private List<User> user = new ArrayList<>();
    public static int id = 1;
    
    

	public UserArrayListRepository() {
		super();
	}

	public UserArrayListRepository(List<User> user) {
		super();
		this.user = user;
	}

	
	@Override
	public User findById(int id) {
		User matchedUser = null;
		for(User u:user) {
			if(u.getUserId()==id) {
				matchedUser = u;
			}
		}
		return matchedUser;
	}

	@Override
	public List<User> findAll() {
		return user;
	}

	@Override
	public User save(User user) {
		int i=0;
		int index = 0;
		boolean exist = false;
		user.setUserId(generateId());
		for(User u:this.user) {
			if(u.getUserName().equals(user.getUserName())) {
				exist = true;
				index = i;
			}
			i++;
		}
		
		if(exist) {
			this.user.set(index, user);
		}else {
			this.user.add(user);
		}
		return user;
	}

	@Override
	public void delete(User user) {
		boolean exist = false;
		int index =0;
		int i=0;
		for(User s:this.user) {
			if(s.getUserName().equals(user.getUserName())) {
				exist = true;
				index=i;
			}
			i++;
		}
		if(exist) {
			this.user.remove(index);
		}
	}

	@Override
	public boolean validatte(String username, String password) {
		boolean isValid = false;
		for(User u:user) {
			if(u.getUserName().equals(username)&& u.getPassword().equals(password)) {
				isValid=true;
			}
		}
		return isValid;
	}

	@Override
	public User findByUsername(String username) {
		User matchedUser = null;

		for(User u:user) {
			if(u.getUserName().equals(username)) {
				matchedUser = u;
			}
		}
		return matchedUser;
	}

	public static int generateId() {
		return ++id;
	}
}
