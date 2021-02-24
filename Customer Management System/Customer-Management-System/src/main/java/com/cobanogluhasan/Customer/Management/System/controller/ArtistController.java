package com.cobanogluhasan.springwebapp.controller;

import com.cobanogluhasan.springwebapp.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {


    private final ArtistRepository artistRepository;


    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @RequestMapping(value = "/artists")
    public String getArtists(Model model) {

        model.addAttribute("artists", artistRepository.findAll());

        return "artists/list";
    }



}
