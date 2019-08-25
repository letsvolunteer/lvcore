package io.lvcore.model.event;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class VolunteerCount   {
  @JsonProperty("required")
  private Integer required = null;

  @JsonProperty("confirmed")
  private Integer confirmed = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VolunteerCount volunteerCount = (VolunteerCount) o;
    return Objects.equals(this.required, volunteerCount.required) &&
        Objects.equals(this.confirmed, volunteerCount.confirmed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(required, confirmed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VolunteerCount {\n");
    
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    confirmed: ").append(toIndentedString(confirmed)).append("\n");
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

