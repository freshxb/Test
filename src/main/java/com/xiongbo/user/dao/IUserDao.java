package com.xiongbo.user.dao;

import com.xiongbo.user.User;

public interface IUserDao {

	public void add(User user);
	public User loadByUsername(String username);
}
