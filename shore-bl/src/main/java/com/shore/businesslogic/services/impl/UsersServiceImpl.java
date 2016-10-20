package com.shore.businesslogic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shore.businesslogic.service.UsersService;
import com.shore.businesslogic.util.Response;
import com.shore.dao.impl.UsersDaoImpl;
import com.shore.dao.vo.Users;

@Controller
@RequestMapping("/users/*")
public class UsersServiceImpl implements UsersService {

  @Autowired
  private UsersDaoImpl usersDao;

  @Override
  @RequestMapping("/login")
  public @ResponseBody Response getUserDetail() {
    Users user = new Users();
    user.setEmail("test@shore.com");
    user.setPassword("xyz");
    List<Users> usersList = usersDao.findByExample(user);
    if (usersList != null && !usersList.isEmpty()) {
      return new Response().ok("", usersList);
    }
    return new Response().fail("", null);
  }

}
