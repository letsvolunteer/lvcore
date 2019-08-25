package io.lvcore.data;

import io.lvcore.model.event.*;
import io.lvcore.model.user.UserProfile;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Record15;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static io.lvcore.db.model.tables.Tables.EVENT;
import static io.lvcore.db.model.tables.Tables.USER;

@Service
public class EventDBServiceImpl implements EventDBService {
    private static final Logger log = LoggerFactory.getLogger(EventDBServiceImpl.class);
    @Autowired
    private DSLContext dsl;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void createEvent(Event event) {
        EventSummary summary = event.getSummary();
        EventDetails details = event.getDetails();
        Location loc = summary.getLocation();
        dsl.insertInto(EVENT,
                EVENT.ID,
                EVENT.HOST_ID,
                EVENT.TITLE,
                EVENT.DESCRIPTION,
                EVENT.EVENT_DATE_TIME,
                EVENT.ADDRESS1,
                EVENT.ADDRESS2,
                EVENT.CITY,
                EVENT.STATE,
                EVENT.ZIPCODE,
                EVENT.CATEGORY,
                EVENT.MEETING_INSTRUCTIONS,
                EVENT.BANNER_URL,
                EVENT.EVENT_URL,
                EVENT.SKILLS)
                .values(event.getId(), summary.getHost().getId(), summary.getTitle(),
                        details.getDescription(), Timestamp.from(summary.getDateTime()),
                        loc.getAddressLine1(), loc.getAddressLine2(), loc.getCity(), loc.getState(), loc.getZipCode() + "    ",
                        summary.getCategory(), details.getMeetingInstructions(),
                        details.getBannerUrl(), details.getEventUrl(), String.join(",",details.getRoles()))
                 .execute();
    }

    @Override
    public Event getEventById(String id) {
        EventDTO event = Optional.ofNullable(dsl.select(EVENT.ID,EVENT.HOST_ID,
                EVENT.TITLE,
                EVENT.DESCRIPTION,
                EVENT.EVENT_DATE_TIME,
                EVENT.ADDRESS1,
                EVENT.ADDRESS2,
                EVENT.CITY,
                EVENT.STATE,
                EVENT.ZIPCODE,
                EVENT.COUNTRY,
                EVENT.CATEGORY,
                EVENT.MEETING_INSTRUCTIONS,
                EVENT.BANNER_URL,
                EVENT.EVENT_URL,
                EVENT.SKILLS,
                EVENT.VOLUNTEER_COUNT_REQ)
                .from(EVENT).where(EVENT.ID.equal(id)).fetchOne())
        .map( rec -> rec.map(ev -> mapper.map(ev, EventDTO.class)))
        .orElse(null);

        UserProfile host = new UserProfile();
        if(event!= null && event.getHostId() != null) {
            UserDTO user = Optional.ofNullable(dsl.select(USER.ID, USER.EMAIL, USER.NAME)
            .from(USER).where(USER.ID.equal(event.getHostId())).fetchOne())
            .map( rec -> rec.map(up -> mapper.map(up, UserDTO.class)))
            .orElse(null);
            if(user != null) {
                host.setId(user.getId());
                host.setName(user.getName());
                host.setEmail(user.getEmail());
            }
        }

        Location loc = new Location(event.getAddress1(), event.getAddress2(),
                event.getCity(), event.getState(), event.getCountry(),
                Integer.valueOf(event.getZipcode().trim()));


        EventSummary summ = new EventSummary(event.getTitle(), event.getCategory(), event.getEventDateTime(),
                loc, host, null);

        VolunteerCount count = new VolunteerCount(event.getVolunteerCountReq(), 0);
        List<String> roles = (event.getSkills() != null) ? Arrays.asList(event.getSkills().split(","))
                : null;
        EventDetails details = new EventDetails(event.getDescription(), count, roles,
                event.getBannerUrl(), event.getEventUrl(), event.getMeetingInstructions());

        return new Event(event.getId(), summ, details);

    }

    @Override
    public List<Event> getEventsByHostId(String hostId, int count, int offset) {
        return null;
    }

    @Override
    public void updateEvent(Event event) {

    }
}
