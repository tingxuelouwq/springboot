package com.kevin.springboot;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.primary.PrimaryUserService;
import com.kevin.springboot.service.secondary.SecondaryUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJdbctemplateMultidatasourceApplicationTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private PrimaryUserService primaryUserService;

    @Autowired
    private SecondaryUserService secondaryUserService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testListPrimaryUsers() throws Exception {
        mockMvc.perform(get("/primary/users"))
                .andDo(print());
    }

    @Test
    public void testListSecondaryUsers() throws Exception {
        mockMvc.perform(get("/secondary/users"))
                .andDo(print());
    }

    @Test
    public void testInsertPrimaryUser() {
        User user = new User();
        user.setUsername("primary");
        user.setUserPwd("123");
        primaryUserService.insert(user);
    }

    @Test
    public void testInsertSecondaryUser() {
        User user = new User();
        user.setUsername("secondary");
        user.setUserPwd("123");
        secondaryUserService.insert(user);
    }

    @Test
    public void testDeletePrimaryUsersByIds() {
        List<Long> ids = Arrays.asList(33L, 35L);
        primaryUserService.deleteByIds(ids);
    }
}
