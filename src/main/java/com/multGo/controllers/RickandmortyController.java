package com.multGo.controllers;

import com.multGo.entity.Cartoon;
import com.multGo.repositorys.CartoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class RickandmortyController {

    @Autowired
    CartoonRepository cartoonRepository;

    @GetMapping("/cartoons/rickandmorty")


    public String rickandmorty(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        System.out.println("Hello GET REQUEST");
        Collection<Cartoon> cartoonArrayList = (Collection<Cartoon>) cartoonRepository.findAll();

        for (Cartoon cartoon:cartoonArrayList) {
            System.out.println(cartoon.getName_cartoon());
        }



        model.addAttribute("name", name);
        return "rickandmorty";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Cartoon> getAllUsers() {
        return cartoonRepository.findAll();
    }
}
