package com.multGo.controllers;

import com.multGo.entity.Cartoon;
import com.multGo.repositorys.CartoonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Optional;

@Controller
public class RickandmortyController {

    @Autowired
    CartoonRepository cartoonRepository;
    private Collection<Cartoon> cartoonArrayList;


    @GetMapping(path = "rickandmorty/{season}")
    public String rickandmortyPathVariable(Model model, @PathVariable String season) {

        cartoonArrayList = cartoonRepository.getCartoonByNameAndSeason("Rick and Morty", Integer.parseInt(season.substring(1)));
        model.addAttribute("cartoonArrayList", cartoonArrayList);
        model.addAttribute("seasons", cartoonRepository.getSeasons("Rick and Morty"));
        model.addAttribute("season", season.substring(1));
        return "rickandmorty";
    }

    @GetMapping(path = "rickandmorty")
    public String rickandmorty(Model model, @RequestParam(name = "season", required = false, defaultValue = "1") String season) {

        cartoonArrayList = cartoonRepository.getCartoonByNameAndSeason("Rick and Morty", Integer.parseInt(season));
        model.addAttribute("cartoonArrayList", cartoonArrayList);
        model.addAttribute("seasons", cartoonRepository.getSeasons("Rick and Morty"));
        model.addAttribute("season", season);
        System.out.println(season);
        return "rickandmorty";
    }



    @GetMapping("rickandmorty/{season}/{episode}")
    public String player( Model model, @PathVariable String season, @PathVariable String episode) {
        int s = Integer.parseInt(season.substring(1));
        int e = Integer.parseInt(episode.substring(1));

        Optional<Cartoon> cartoon = cartoonRepository.findById(10000+(100*s)+e);
        model.addAttribute("cartoon", cartoon.get());
        return "playerTrue";
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
