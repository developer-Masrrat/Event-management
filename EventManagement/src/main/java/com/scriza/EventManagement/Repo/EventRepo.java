package com.scriza.EventManagement.Repo;

import com.scriza.EventManagement.Model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<EventModel,Integer> {
    EventModel findByEventId(int eventId);
    EventModel findByEventName(String eventName);

}
