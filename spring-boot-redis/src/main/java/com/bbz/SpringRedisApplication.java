package com.bbz;

import com.bbz.util.Jsons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

@SpringBootApplication
@RequestMapping("/")
@RestController
public class SpringRedisApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringRedisApplication.class, args);
    }

    @RequestMapping(value = "/test")
    public String test(@RequestBody Person json) {

        if (json.getImage() != null && json.getImage() != "") {
            Util.base64ChangeImage(json.getImage(), "/Users/tianxin2/Documents/12323.png");

        }

        System.out.println("...." + Jsons.gsonToJson(json));
        return "1231231";
    }


}
