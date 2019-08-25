package io.lvcore.model.user;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class UserProfile   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("level")
  private String level = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfile userProfile = (UserProfile) o;
    return Objects.equals(this.id, userProfile.id) &&
        Objects.equals(this.email, userProfile.email) &&
        Objects.equals(this.name, userProfile.name) &&
        Objects.equals(this.level, userProfile.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, name, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfile {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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

