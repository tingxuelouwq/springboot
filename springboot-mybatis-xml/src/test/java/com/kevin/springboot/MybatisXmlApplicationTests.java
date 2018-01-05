package com.kevin.springboot;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisXmlApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testVerify() {
		String username = "admin";
		String userPwd = "123";
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("userPwd", userPwd);
		User user = userService.verify(params);
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
		userService.delete(4);
	}

	@Test
	public void testSelect() {
		User user = userService.select(3);
		System.out.println(user.getEmail());
	}

	@Test
	public void testDeleteByIds() {
		String[] ids = new String[]{"5", "6"};
		userService.deleteByIds(ids);
	}

	@Test
	public void testListAll() {
		List<User> users = userService.listAll();
		System.out.println(users.size());
	}
}
