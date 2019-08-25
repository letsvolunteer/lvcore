package io.lvcore.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDTO {
    String id;
    String hostId;
    String title;
    Instant eventDateTime;
    String description;
    String address1;
    String address2;
    String city;
    String state;
    String zipcode;
    String country;
    String category;
    String meetingInstructions;
    String bannerUrl;
    String eventUrl;
    String skills;
    int volunteerCountReq; //VOLUNTEER_COUNT_REQ
}

