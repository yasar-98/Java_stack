package com.yasar.lookify.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.lookify.models.Song;

@Repository
public interface SongRepositry extends CrudRepository<Song, Long>{
    // this method retrieves all the Songs from the database
    List<Song> findAll();
	List<Song> findTop10ByOrderByRatingDesc();
	List<Song> findByArtistContaining(String artist);

}
