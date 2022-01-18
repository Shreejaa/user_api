/*
package com.Training.User_Service;

import com.Training.User_Service.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestControllermethods extends UserServiceApplicationTests{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    private BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    public static Long deleteId;

    @Test()
    public void AgetAllBooks() throws Exception {
        String uri = "/users";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User[] Booklist = super.mapFromJson(content, User[].class);
        assertTrue(Booklist.length > 0);
    }
    @Test
    public void BcreateBook() throws Exception {
        String uri = "/users";
        User user = new User();
        user.setFirstname("create user");
        user.setUsername("create user");
        user.setUseremail("create@user.com");
        user.setPhoneno("8794561300");
        user.setPassword("user");
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        User actualUser = mapFromJson(content,User.class);
        deleteId = actualUser.getUserid();
        user.setUserid(deleteId);
        assertEquals(actualUser, user);
    }
    @Test
    public void CupdateProduct() throws Exception {
        String uri = "/users/"+deleteId;
        User user = new User();
        user.setUserid(deleteId);
        user.setFirstname("update user");
        user.setUsername("update user");
        user.setUseremail("update@user.com");
        user.setPhoneno("8794561300");
        user.setPassword("user");
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        User actualUser = mapFromJson(content,User.class);
        assertEquals(actualUser.getFirstname(), user.getFirstname());
        assertEquals(actualUser.getUseremail(),user.getUseremail());
        assertEquals(actualUser.getPhoneno(),user.getPhoneno());
        assertTrue(passwordEncoder.matches(user.getPassword(),actualUser.getPassword()));
    }
    @Test
    public void DdeleteProduct() throws Exception {
        String uri = "/users/"+deleteId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
*/
