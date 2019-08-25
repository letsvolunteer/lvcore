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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-02-26T05:19:37.458Z")
public class Location   {
  @JsonProperty("addressLine1")
  private String addressLine1 = null;

  @JsonProperty("addressLine2")
  private String addressLine2 = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("zipCode")
  private Integer zipCode = null;


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.addressLine1, location.addressLine1) &&
        Objects.equals(this.addressLine2, location.addressLine2) &&
        Objects.equals(this.city, location.city) &&
        Objects.equals(this.state, location.state) &&
        Objects.equals(this.country, location.country) &&
        Objects.equals(this.zipCode, location.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressLine1, addressLine2, city, state, country, zipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
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

