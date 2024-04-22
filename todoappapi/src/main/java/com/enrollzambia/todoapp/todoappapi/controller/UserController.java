package com.enrollzambia.todoapp.todoappapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enrollzambia.todoapp.todoappapi.dto.UserDataDTO;
import com.enrollzambia.todoapp.todoappapi.dto.UserResponseDTO;
import com.enrollzambia.todoapp.todoappapi.model.User;
import com.enrollzambia.todoapp.todoappapi.service.UserService;
import com.enrollzambia.todoapp.todoappapi.service.UserService2;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	 private UserService2 userService;
	

  @PostMapping("/login")
  public String login(@RequestBody UserDataDTO user) {
    return userService.signin(user.getUsername(), user.getPassword());
  }

  @PostMapping("/signup")
  public String signup(@RequestBody UserDataDTO user) {
    return userService.signup(new User(user.getUsername(), user.getPassword()));
  }

//  @DeleteMapping(value = "/{username}")
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
//  @ApiOperation(value = "${UserController.delete}", authorizations = { @Authorization(value="apiKey") })
//  @ApiResponses(value = {//
//      @ApiResponse(code = 400, message = "Something went wrong"), //
//      @ApiResponse(code = 403, message = "Access denied"), //
//      @ApiResponse(code = 404, message = "The user doesn't exist"), //
//      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//  public String delete(@ApiParam("Username") @PathVariable String username) {
//    userService.delete(username);
//    return username;
//  }

//  @GetMapping(value = "/{username}")
//  public UserResponseDTO search(@PathVariable String username) {
//    return modelMapper.map(userService.search(username), UserResponseDTO.class);
//  }
}
