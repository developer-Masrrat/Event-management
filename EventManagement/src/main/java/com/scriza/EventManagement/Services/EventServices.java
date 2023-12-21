package com.scriza.EventManagement.Services;

import com.scriza.EventManagement.Exceptions.EventAlreadyFoundException;
import com.scriza.EventManagement.Exceptions.ResourceNotFoundException;
import com.scriza.EventManagement.Exceptions.ResponseClass;
import com.scriza.EventManagement.Model.EventModel;
import com.scriza.EventManagement.Repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServices {

    @Autowired
    private EventRepo eventRepo;

    public ResponseEntity<?> addEvent(EventModel event) {
        EventModel eventName = eventRepo.findByEventName(event.getEventName());
        if (eventName != null) {
            throw new EventAlreadyFoundException("This Event  is already register");
        }
        eventRepo.save(event);
        return ResponseClass.response("Event Added Successfully");
    }

    public List<EventModel> getAllEvents() {
        return eventRepo.findAll();
    }

    public ResponseEntity<?> getEventById(int eventId) {
        EventModel event = eventRepo.findByEventId(eventId);
        if (event == null) {
            throw new ResourceNotFoundException("Event not found by this Id.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(event);

    }

    public ResponseEntity<?> modifyEvent(int eventId, EventModel event) {
        EventModel existingEvent = eventRepo.findByEventId(eventId);
        if (existingEvent == null) {
            throw new ResourceNotFoundException("Event not found by this Id");
        }
        if(existingEvent != null){
            EventModel eventName = eventRepo.findByEventName(event.getEventName());
            if (eventName != null) {
                throw new EventAlreadyFoundException("This Event  is already register");
            }
        }
        existingEvent.setEventName(event.getEventName());
        existingEvent.setEventDate(event.getEventDate());
        existingEvent.setEventDescription(event.getEventDescription());

        eventRepo.save(existingEvent);
        return ResponseClass.response("Event Updated Successfully");
    }

    public ResponseEntity<?> deleteEventById(int eventId) {
        EventModel event1 = eventRepo.findByEventId(eventId);
        if (event1 == null) {
            throw new ResourceNotFoundException("Event not found by this Id.");
        }
        eventRepo.delete(event1);
        return ResponseClass.response("Event Deleted Successfully");
    }
}
