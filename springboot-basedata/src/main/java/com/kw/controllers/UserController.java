package com.kw.controllers;

import com.kw.model.User;
import com.kw.service.IMailService;
import com.kw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMailService mailService;


    @GetMapping("getUser")
    public String getUser(){

        List<User> userList = userService.getUser();
        return "success";
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("sendMail")
    public String sendMail(){
        mailService.simpleTextMail();
        mailService.htmlMail();
        mailService.attachMail();
        return "邮件已发送";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<User> userList=userService.getUser();
        model.addAttribute("users",userList);
        return "user/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id,Model model){
        User user=userService.findById(id);
        model.addAttribute("user",user);
        return "user/edit";
    }

    @GetMapping("/add")
    public String add(){
        return "user/add";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.add(user);
        return "redirect:/user/list";
    }

    @PostMapping("update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        userService.delete(id);
        return "redirect:user/list";
    }

}
