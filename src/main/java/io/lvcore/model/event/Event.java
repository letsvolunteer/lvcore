package io.lvcore.model.event;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Event {
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("summary")
    private EventSummary summary = null;

    @JsonProperty("details")
    private EventDetails details = null;

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(this.id, event.id) &&
                Objects.equals(this.summary, event.summary) &&
                Objects.equals(this.details, event.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary, details);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Event {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

