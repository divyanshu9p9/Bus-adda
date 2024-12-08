package com.brs.controllers;

import java.util.List;

import javax.validation.Valid;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.brs.entity.Users;
import com.brs.service.interfaces.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private IUserService userService;
	@PreAuthorize("hasRole('USER')")

	@PostMapping("/addUser") @SneakyThrows
	public Users addUser(@Valid @RequestBody Users user)
	{
		return userService.addUser(user);
	}
	@GetMapping("/viewUser") @SneakyThrows
	public Users viewUsers(@RequestParam int userId)
	{
		return userService.viewUser(userId);
	}
	
	@GetMapping("/viewAllUsers")
	public List<Users> viewAllUsers()
	{
		return userService.viewAllUsers();
	}
	@DeleteMapping("/deleteUser") @SneakyThrows
	public Users deleteUser(@RequestParam int userId)
	{
		return userService.deleteUser(userId);
	}
	
	@PutMapping("/updateUser") @SneakyThrows
	public Users updateUser(@Valid @RequestBody Users user) {
		return userService.updateUser(user);
	}

	@GetMapping("/getUserByUserName") @SneakyThrows
	public Users getUserByUserName(@RequestParam String userName){return userService.getUserByUserName(userName);}

	@PutMapping("/updateUserData") @SneakyThrows
	public Users updateUserData(@Valid @RequestBody Users user) {
		return userService.updateUserData(user);
	}
}
