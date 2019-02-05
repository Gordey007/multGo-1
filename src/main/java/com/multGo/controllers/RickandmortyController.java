package com.multGo.controllers;

import com.multGo.entity.Cartoon;
import com.multGo.logic.Parser;
import com.multGo.repositorys.CartoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class RickandmortyController {

    @Autowired
    CartoonRepository cartoonRepository;
    private Collection<Cartoon> cartoonArrayList;

    @GetMapping("/cartoons/rickandmorty")
    public String rickandmorty( Model model) {

        cartoonArrayList = (Collection<Cartoon>) cartoonRepository.findAll();
        model.addAttribute("cartoonArrayList", cartoonArrayList);
        return "rickandmorty";
    }

    @GetMapping("/parser")
    public String addEpisodes(Model model) {
        cartoonArrayList = (Collection<Cartoon>) cartoonRepository.findAll();
        cartoonArrayList.forEach(cartoon -> System.out.println(cartoon));


        model.addAttribute("cartoonArrayList", cartoonArrayList);

        String hello = "spring";
        model.addAttribute("hello", "ssss");

        return "admin/parser";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Cartoon> getAllUsers() {
        return cartoonRepository.findAll();
    }

//    @PostMapping
//    public String add(@RequestParam String text,  Model model){
//        Parser parser = new Parser(text);
//        cartoonRepository.saveAll(parser.startParser());
//
//        return "admin/parser";
//    }
}
