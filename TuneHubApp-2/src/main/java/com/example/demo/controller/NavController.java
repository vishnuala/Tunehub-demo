package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;



@Controller
public class NavController {
	
	@Autowired
	SongService songserv;
	
	@Autowired
	PlayListService pserv;

	@GetMapping("map-register")
	public String registerMapping() {
		return "register";
	}

	@GetMapping("map-login")
	public String loginMapping() {
		return "login";
	}

	@GetMapping("map-addsongs")
	public String addSongsMapping() {
		return "addsongs";
	}
	
	@GetMapping("/samplepayment")
	public String sample() {
		return "samplepayment";
	}
	
	@GetMapping("/customersongs")
	public String customerSongs(Model model) {
		List<Song> songsList = songserv.fetchAllSongs();
		model.addAttribute("songs", songsList);
		return "displaysongs";
	}
	
}
