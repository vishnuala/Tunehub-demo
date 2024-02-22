package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songserv;

	@PostMapping("postsongs")
	public String addSongs(@ModelAttribute Song song) {
		boolean songstatus = songserv.songExists(song.getName());
		if (songstatus == false) {
			songserv.addSongs(song);
			return "songsuccess";
		} else {
			return "songfail";
		}
	}
	
	@GetMapping("viewsongs")
	public String viewSong(Model model) {
		List<Song> songsList = songserv.fetchAllSongs();
		model.addAttribute("songs", songsList);
		//System.out.println(songsList);
		return "displaysongs";
		
	}
	
	
//	@GetMapping("customer")
//	public String viewCustomerSongs(Model model) {
//		List<Song> songsList = songserv.fetchAllSongs();
//		model.addAttribute("songs", songsList);
//		boolean primeStatus = true;
//		if(primeStatus==true) {
//			return"displaysongs";
//		}else {
//			return "makepayment";
//		}
//	}

}
