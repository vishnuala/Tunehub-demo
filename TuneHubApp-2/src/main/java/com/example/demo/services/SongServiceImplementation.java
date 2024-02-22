package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService{

	@Autowired
	SongRepository songrepo;
	
	
	@Override
	public String addSongs(Song song) {
		songrepo.save(song);
		return "song is Created and saved";
	}


	@Override
	public boolean songExists(String name) {
		if (songrepo.findByName(name)==null) {
			return false;
		} else {
			return true;
		}
	}


	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songsList = songrepo.findAll();
		return songsList;
	}


	@Override
	public void updateSong(Song song) {
		songrepo.save(song);
		
	}


	

}
