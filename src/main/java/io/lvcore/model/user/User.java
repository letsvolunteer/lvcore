package io.lvcore.model.user;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * User
 */
@Getter
@Setter
@NoArgsConstructor
@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-26T05:19:37.458Z")

public class User   {
  @JsonProperty("id")
   String id = null;

  @JsonProperty("name")
   String name = null;

  @JsonProperty("email")
   String email = null;

  @JsonProperty("passwordHash")
   String passwordHash = null;

  @JsonProperty("phone")
   String phone = null;

  @JsonProperty("identityProvider")
   String identityProvider = null;

  @JsonProperty("providerId")
   String providerId = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.passwordHash, user.passwordHash) &&
        Objects.equals(this.phone, user.phone) &&
        Objects.equals(this.identityProvider, user.identityProvider) &&
        Objects.equals(this.providerId, user.providerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, passwordHash, phone, identityProvider, providerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    passwordHash: ").append(toIndentedString(passwordHash)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    identityProvider: ").append(toIndentedString(identityProvider)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
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

