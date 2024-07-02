package com.baloise.platformplanedemoapp.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/temp")
public class TempRestController {

  @GetMapping("/headers")
  public String getHeaders(@RequestHeader Map<String, String> headers) {
    headers.forEach((key, value) -> {
      System.out.printf("Header '%s' = %s%n", key, value);
    });
    return "success";
  }
}
