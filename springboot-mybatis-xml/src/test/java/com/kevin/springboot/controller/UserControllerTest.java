package com.kevin.springboot.controller;

import com.kevin.springboot.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();

        // 拦截器会判断用户是否登录，所以这里注入一个用户
        session = new MockHttpSession();
        User user = new User();
        user.setUsername("admin");
        user.setUserPwd("123456");
        session.setAttribute("user", user);
    }

    @Test
    public void listUsers() throws Exception {
        mvc.perform(get("/users").session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", notNullValue()))
                .andExpect(view().name("users"))
                .andDo(print());
    }
}