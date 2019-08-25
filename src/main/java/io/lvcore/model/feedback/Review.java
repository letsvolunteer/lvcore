package io.lvcore.model.feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    String text;
    Instant dateWritten;
    String status;
    String volunteerId;
    String hostId;
}
