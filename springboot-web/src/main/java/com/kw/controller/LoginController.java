package com.kw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/test")
    public Object test(){
        Map<String,Object> map=null;
        return map;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         Model model){
        if(file.isEmpty()){
            model.addAttribute("message","文件为空");
            return "failer";
        }
        try {
            byte[] bytes=file.getBytes();
            Path path= Paths.get("D://"+file.getOriginalFilename());
            Files.write(path,bytes);

            model.addAttribute("message","you successfully uploaded"+file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }


}
