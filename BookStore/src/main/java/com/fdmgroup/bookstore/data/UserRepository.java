package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.User;

public interface UserRepository extends Searchable,Persistable,Removeable{

	boolean validatte(String username,String password);
	User findByUsername(String username);
}
