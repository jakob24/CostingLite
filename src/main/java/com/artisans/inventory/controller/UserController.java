/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.model.User;
import com.artisans.inventory.repository.UserRepository;

/**
 * @author Jacob
 *
 */

@Scope(value = "session")
@Component(value = "userController")
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired 
	private UserRepository userRepository;
	
	private User user = new User();
	
/*	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		User n = new User();
		n.setUsername(name);
	
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}*/	

    public String save() {
    	userRepository.save(user);
    	user = new User();
        return "abcd";
    }

    public User getUser() {
        return user;
    }
}
