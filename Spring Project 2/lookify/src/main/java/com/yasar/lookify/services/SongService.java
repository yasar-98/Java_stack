package com.yasar.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.lookify.models.Song;
import com.yasar.lookify.repositries.SongRepositry;

@Service
public class SongService {
    private final SongRepositry songRepositry;
    
    public SongService(SongRepositry songRepositry) {
        this.songRepositry = songRepositry;
    }
    public List<Song> allSongs() {
        return songRepositry.findAll();
    }
    public Song createSong(Song b) {
        return songRepositry.save(b);
    }
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepositry.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    public List<Song> findTop10ByOrderByRatingDesc() {
        return songRepositry.findTop10ByOrderByRatingDesc();
    }
    public List<Song> findByArtistContaining(String artist) {
        return songRepositry.findByArtistContaining(artist);
    }
	public void deleteSong(Long id) {
		songRepositry.deleteById(id);
	}

}
