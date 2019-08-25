package io.lvcore.model.event;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EventDetails
 */
@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDetails   {
  @JsonProperty("description")
  private String description;

  @JsonProperty("volunteerCount")
  private VolunteerCount volunteerCount;

  @JsonProperty("roles")
  @Valid
  private List<String> roles;

  @JsonProperty("bannerUrl")
  private String bannerUrl;

  @JsonProperty("eventUrl")
  private String eventUrl;

  private String meetingInstructions;

  public EventDetails addRolesItem(String rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<String>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDetails eventDetails = (EventDetails) o;
    return Objects.equals(this.description, eventDetails.description) &&
        Objects.equals(this.volunteerCount, eventDetails.volunteerCount) &&
        Objects.equals(this.roles, eventDetails.roles) &&
        Objects.equals(this.bannerUrl, eventDetails.bannerUrl) &&
        Objects.equals(this.eventUrl, eventDetails.eventUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, volunteerCount, roles, bannerUrl, eventUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDetails {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    volunteerCount: ").append(toIndentedString(volunteerCount)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    bannerUrl: ").append(toIndentedString(bannerUrl)).append("\n");
    sb.append("    eventUrl: ").append(toIndentedString(eventUrl)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n   ");
  }
}

