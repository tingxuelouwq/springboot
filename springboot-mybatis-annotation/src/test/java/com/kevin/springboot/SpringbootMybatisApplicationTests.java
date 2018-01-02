package com.kevin.springboot;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testVerify() {
		String username = "admin";
		String userPwd = "123456";
		User user = userService.verify(username, userPwd);
		System.out.println(user.getEmail());
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("test");
		user.setUserPwd("123456");
		userService.insert(user);
	}

	@Test
	public void testDelete() {
		userService.delete(28);
	}

	@Test
	public void testSelect() {
		User user = userService.select(2);
		System.out.println(user.getEmail());
	}

	@Test
	public void testDeleteByIds() {
		String[] ids = new String[]{"29", "30"};
		userService.deleteByIds(ids);
	}

	@Test
	public void testListAll() {
		List<User> users = userService.listAll();
		System.out.println(users.size());
	}
}
