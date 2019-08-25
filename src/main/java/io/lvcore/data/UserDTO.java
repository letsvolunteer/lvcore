package io.lvcore.data;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    String id;

    String externalId;

    String name;

    String email;

    String idProvider;
}
