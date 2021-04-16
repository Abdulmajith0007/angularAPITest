package org.abdul.project.controller;

import org.abdul.project.model.User;
import org.abdul.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("API/Angular/addUser")
	@CrossOrigin(origins = "http://localhost:51997")
	public User addUser(@RequestBody User user) throws Exception
	{
		String emailid=user.getEmailId();
		if(emailid !=null || !"".equals(emailid))
		{
		 User useremail =userService.findEmailId(emailid);
		   if(useremail !=null)
			 {
				throw new Exception("Email id already exist with :"+emailid);
			 }
		}
		User addUser=userService.addUser(user);         
//		"name" : "majith2",
//	    "emailId" : "majith@gmail.com",
//	    "mobile" : "9999999",
//	    "password" : "majith2"
		return addUser;
				}
	
	@PostMapping("API/Angular/loginUser")
	
	@CrossOrigin(origins = "http://localhost:51997")
	public User loginUser(@RequestBody User user) throws Exception
	{
		User loginUser=null;
		String emailid = user.getEmailId();
		String password= user.getPassword();
		if(emailid != null || password != null)
		{
		loginUser=	userService.findEmailIdAndPassword(emailid, password);
		}
		if (loginUser == null )
		{
			throw new Exception("user does not exixt");
		}
		return loginUser;
	}
	
}
	
	
	
	