package com.tataelxsi.webservices.rest.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tataelxsi.webservices.rest.exception.ResourceNotFound;
import com.tataelxsi.webservices.rest.model.User;
import com.tataelxsi.webservices.rest.service.UserDaoService;

@RestController
public class UserResourceController {
	/*
	 * @Autowired private User user;
	 */

	@Autowired
	private UserDaoService daoService;

	// retrive all users

	@GetMapping(path = "/Users")
	public List<User> getAllUsers() {

		return daoService.findAll();

	}

	@GetMapping(path = "/Users/{id}")
	public User getUser(@PathVariable int id) throws ResourceNotFound {

		User user = daoService.findOne(id);
		if (user == null) {
			throw new ResourceNotFound("This resource id " + id + " Not Found ");
		}
		return user;

	}

	@PostMapping(path = "/Users")
	public ResponseEntity<Object> createuser(@RequestBody User user) {
		User savedUser = daoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/Users/{id}")
	public void deleteUser(@PathVariable int id) throws ResourceNotFound {

		User user = daoService.deleteuserById(id);
		if (user == null) {
			throw new ResourceNotFound("This resource id " + id + " Not Found ");
		}

	}

}
