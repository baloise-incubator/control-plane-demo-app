package com.baloise.platformplanedemoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("demo")
  @ResponseBody
  public String Admin() {
    return "Admin message";
  }

}
