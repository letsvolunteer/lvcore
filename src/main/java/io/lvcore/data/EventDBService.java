package io.lvcore.data;

import io.lvcore.model.event.Event;;

import java.util.List;

public interface EventDBService {
    void createEvent(Event event);
    Event getEventById(String id);
    List<Event> getEventsByHostId(String hostId, int count, int offset);
    void updateEvent(Event event);
}
