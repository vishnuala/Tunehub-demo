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
public class PlayListController {
	
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongService sserv;
	
	@GetMapping("createplaylist")
	public String createPlayList(Model model) {
		
		List<Song> songsList = sserv.fetchAllSongs();
		
		model.addAttribute("songsList", songsList);
		
		return "createplaylist";
		
	}
	
	@PostMapping("addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		// adding play list
		pserv.addPlaylist(playlist);
		//update song table
		List<Song> songsList = playlist.getSong();
		for(Song song : songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
		List<PlayList> plist = pserv.fetchPlayList();
		model.addAttribute("plist", plist);
		return"viewplaylist";
	}
	

}
