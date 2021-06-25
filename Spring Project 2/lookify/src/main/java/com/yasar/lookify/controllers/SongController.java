package com.yasar.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yasar.lookify.models.Song;
import com.yasar.lookify.services.SongService;

@Controller
public class SongController {
    private final SongService songService;
    
    public SongController(SongService songService) {
        this.songService = songService;
    }
    
    @RequestMapping("/welcome")
    public String index() {
        return "index.jsp";
    }
    @RequestMapping("/songs/new")
    public String add(@ModelAttribute("song") Song song) {
        return "new.jsp";
    }
    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
    	if (result.hasErrors()) {
            return "new.jsp";
        } else {
        	songService.createSong(song);
            return "redirect:/songs/new";
        }
    }

    @RequestMapping("/songs/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "details.jsp";
    }
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }


    @RequestMapping("/search")
    public String search(Model model,@RequestParam(value="artist") String artist) {
        model.addAttribute("songs", songService.findByArtistContaining(artist));
        model.addAttribute("artist", artist);
        return "search.jsp";
    }
    @RequestMapping(value="/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    @RequestMapping("/songs/top")
    public String top(Model model) {
        model.addAttribute("songs", songService.findTop10ByOrderByRatingDesc());
        return "top.jsp";
    }

}