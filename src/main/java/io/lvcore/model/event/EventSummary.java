package io.lvcore.model.event;

import java.time.Instant;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lvcore.model.user.UserProfile;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * EventSummary
 */
@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventSummary   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("dateTime")
  private Instant dateTime = null;

  @JsonProperty("location")
  private Location location = null;

  @JsonProperty("host")
  private UserProfile host = null;

  @JsonProperty("organizationName")
  private String organizationName = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventSummary eventSummary = (EventSummary) o;
    return Objects.equals(this.title, eventSummary.title) &&
        Objects.equals(this.category, eventSummary.category) &&
        Objects.equals(this.dateTime, eventSummary.dateTime) &&
        Objects.equals(this.location, eventSummary.location) &&
        Objects.equals(this.host, eventSummary.host) &&
        Objects.equals(this.organizationName, eventSummary.organizationName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, category, dateTime, location, host, organizationName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventSummary {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
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

