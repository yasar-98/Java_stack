package com.yasar.belt.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.yasar.belt.models.Event;
import com.yasar.belt.models.Message;
import com.yasar.belt.models.User;
import com.yasar.belt.repositories.EventRepository;
import com.yasar.belt.repositories.MessageRepository;
import com.yasar.belt.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final MessageRepository messageRepository;
    
    public UserService(UserRepository userRepository,EventRepository eventRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.messageRepository = messageRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    
    
    public Event createEvent(Event e) {
        return eventRepository.save(e);
    }
    // retrieves a book
    public Event findBook(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }
	
    public List<Event> findByState(String state){
        return eventRepository.findByState(state);
    }
    public List<Event> findByStateIsNot(String state){
        return eventRepository.findByStateIsNot(state);
    }
    // find event by id
    public Event findEventById(Long id) {
    	Optional<Event> u = eventRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	public Event update(Event event) {
		return eventRepository.save(event);
	}

	public void delete(Long id) {
		eventRepository.deleteById(id);
	}
	public void manageAttenders(Event event, User user, boolean isJoining) {
		if(isJoining) {
			event.getAttenders().add(user);
		} else {
			event.getAttenders().remove(user);
		}
		eventRepository.save(event);
	}
	public void comment(User user, Event event, String comment) {
		messageRepository.save(new Message(user, event, comment));
	}


}
