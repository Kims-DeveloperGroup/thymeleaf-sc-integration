package com.devoo.kim.website.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebViewController {

    @GetMapping("/")
    public String redirectDefaultPage(Model model) {
        model.addAttribute("text", "Hello World");
        return "index";
    }

    @GetMapping("/private")
    public String redirectPrivatePage(Model model) {
        model.addAttribute("text", "Private World");
        return "index";
    }

    @PostMapping("/csrftest")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void testCsrf() {

    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/";
    }

    @GetMapping("/redirect/private")
    public String redirectToPrivatePage() {
        return "forward:/private";
    }

    @PostMapping("/redirectPostToPost")
    public String redirectPostToPost(HttpServletRequest request) {
//        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/redirectedPostToPost";
    }

    @PostMapping("/redirectedPostToPost")
    public String redirectedPostToPost() {
        return "/";
    }

    @GetMapping("/chuchu")
    public String naver() {
        return "redirect:https://www.naver.com";
    }
}
