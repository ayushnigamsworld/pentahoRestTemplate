package com.pentaho.ho.ho.controller;

import com.pentaho.ho.ho.authorization.Authorization;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(){

        String url = "http://localhost:8080/pentaho/api/repo/files/home:adminMain:a1.txt/acl";

        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "password"));

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        System.out.print("Response -> "+ response.getBody());


        return "Response -> "+ response.getBody();
    }

}
