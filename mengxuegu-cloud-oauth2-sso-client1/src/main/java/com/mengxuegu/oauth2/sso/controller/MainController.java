package com.mengxuegu.oauth2.sso.controller;

import com.mengxuegu.base.result.MengxueguResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: 梦学谷 www.mengxuegu.com
 */
@Controller
public class MainController {


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @GetMapping("/member")
    public String member() {
//        MengxueguResult result = oAuth2RestTemplate.getForObject("http://localhost:8080/product/list", MengxueguResult.class);
        ResponseEntity<MengxueguResult> entity =
                oAuth2RestTemplate.getForEntity("http://localhost:7001/product/list", MengxueguResult.class);
        MengxueguResult body = entity.getBody();
        System.out.println("body: " + body);
        return "member";
    }

}
