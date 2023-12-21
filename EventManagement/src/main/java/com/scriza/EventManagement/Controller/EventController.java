package com.scriza.EventManagement.Controller;

import com.scriza.EventManagement.Exceptions.ResourceNotFoundException;
import com.scriza.EventManagement.Model.EventModel;
import com.scriza.EventManagement.Services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventServices eventServices;

    @PostMapping("/addEvents")
    ResponseEntity<?> createLawyer(@RequestBody EventModel eventModel) {
        ResponseEntity<?> response;
        response = eventServices.addEvent(eventModel);
        return response;
    }

    @GetMapping("/allEvents")
    public ResponseEntity<List<EventModel>> getAllEvents() {
        List<EventModel> events = eventServices.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    ResponseEntity<?> getEventById(@PathVariable int eventId) {
        ResponseEntity<?> response;
        response = eventServices.getEventById(eventId);
        return response;
    }

    @PutMapping("/modifyEvent/{eventId}")
    ResponseEntity<?> modifyEvent(@PathVariable int eventId , @RequestBody EventModel eventModel){
        ResponseEntity<?> response;
        response = eventServices.modifyEvent(eventId , eventModel);
        return response;
    }
    @DeleteMapping("/delete/{eventId}")
    ResponseEntity<?> deleteById(@PathVariable int eventId){
        ResponseEntity<?> response;
        response = eventServices.deleteEventById(eventId);
        return response;
    }

}
