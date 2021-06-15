package com.yasar.routings;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class DoController {
	@RequestMapping("/{track}")
	public String hi(@PathVariable("track") String track) {
		if (track.equals("dojo")) {
			return "The dojo is awesome!";
		}else if(track.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}else if(track.equals("san-jose")){
			return "SJ dojo is the headquarters";
		}
		return "enter something";
	}
}

