package com.shore.businesslogic.services.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ping/*")
public class TestPing {

  @RequestMapping("/test")
  public @ResponseBody String testPing() {
    return "success";
  }

}
