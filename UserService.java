package org.abdul.project.service;

import org.abdul.project.model.User;
import org.abdul.project.resposittory.UserRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
 @Autowired
 private UserRespo userRespo;
 
 public User addUser(User user)
 {
	 return userRespo.save(user);
 }

 
 public User findEmailId(String emailId)
 {
	 return userRespo.findByEmailId(emailId);
	 
 }

 public User findEmailIdAndPassword(String emailId ,String password)
 {
	 return userRespo.findByEmailIdAndPassword(emailId,password);
	 
 }
	
}
