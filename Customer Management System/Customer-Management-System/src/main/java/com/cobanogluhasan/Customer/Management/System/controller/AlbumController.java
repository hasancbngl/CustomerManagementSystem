package com.cobanogluhasan.springwebapp.controller;

import com.cobanogluhasan.springwebapp.model.Album;
import com.cobanogluhasan.springwebapp.repositories.AlbumRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @RequestMapping(value = "/albums")
    public String getAlbums(Model model) {

        model.addAttribute("albums", albumRepository.findAll());

        return "albums";
    }


}
