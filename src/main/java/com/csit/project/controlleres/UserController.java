package com.csit.project.controlleres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit.project.entities.User;
import com.csit.project.repositories.UserDao;

@RestController
@Transactional
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("/")
	public String showHome() {

		User user = new User();
		user.setName("abc");
		user.setEmail("emialasdjf");

		User user2 = new User();
		user2.setName("abcd");
		user2.setEmail("emialadfersdjf");

		User user3 = new User();
		user3.setName("abcef");
		user3.setEmail("emialassdrdjf");
		
		userDao.save(user);
		userDao.save(user2);
		userDao.save(user3);
		
		List<User> userList = userDao.getAllUser();
		for(User users : userList){
			System.out.println(users);
		}
		
		User usr = userDao.getSingleUserByEmail("emialassdrdjf");
		System.out.println(usr);
		
		User usr1 = userDao.getSingleUserById(usr.getId());
		System.out.println(usr1);
		
		return "success";
	}

}
