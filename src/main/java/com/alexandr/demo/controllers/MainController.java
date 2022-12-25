package com.alexandr.demo.controllers;

import com.alexandr.demo.domain.Message;
import com.alexandr.demo.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String maintwo(){
        return "maintwo";
    }
	@GetMapping("/main")
	public String main(Map<String,Object>model){
		Iterable<Message> messages = messageRepo.findAll();
		model.put("messages", messages);
		return "main";
	}
    @GetMapping("/features")
    public String features(){
        return "features";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }





    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/403")
    public String forbidenPage(){
        return "403";
    }








    @PostMapping("/main")
    public String Add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        }else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }





}