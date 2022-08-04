package com.tataelxsi.webservices.rest.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tataelxsi.webservices.rest.model.User;

@Component
public class UserDaoService {
	public static int usersCount = 4;
	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "swamy", new Date(usersCount)));
		users.add(new User(2, "manvi", new Date(usersCount)));
		users.add(new User(3, "vallabh", new Date(usersCount)));
		users.add(new User(4, "kurma", new Date(usersCount)));

	}

	public List<User> findAll() {

		return users;
	}

	public User save(User user) {
		if (user.equals(user.getId())) {
			user.setId(++usersCount);

		}
		users.add(user);
		return user;

	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;

			}

		}
		return null;

	}

	public User deleteuserById(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();

			if (user.equals(user.getId())) {
				iterator.remove();

				return user;

			}

		}

		return null;

	}

}
