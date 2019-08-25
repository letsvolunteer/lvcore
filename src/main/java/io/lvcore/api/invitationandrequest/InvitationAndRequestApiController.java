package io.lvcore.api.invitationandrequest;

import io.lvcore.model.invitationandrequest.InvitationStatus;
import io.lvcore.model.invitationandrequest.ParticipantRequest;
import io.lvcore.model.invitationandrequest.VolunteerRequestStatus;
import io.lvcore.model.invitationandrequest.Invitation;
import io.lvcore.model.invitationandrequest.InvitationRequest;
import io.lvcore.model.invitationandrequest.VolunteerRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(
        value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2019-02-26T05:19:37.458Z")
@Controller
public class InvitationAndRequestApiController implements InvitationAndRequestApi {

    private static final Logger log = LoggerFactory.getLogger(InvitationAndRequestApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InvitationAndRequestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // CREATE INVITATION
    public ResponseEntity<Invitation> createInvitation(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = ""  )  @Valid @RequestBody InvitationRequest invitationRequest) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Invitation>(objectMapper.readValue(
                        "{  \"roles\" : [ \"roles\", \"roles\" ],  \"id\" : 0,  \"email\" : 6,  \"status\" : \"pending\"}",
                        Invitation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Invitation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Invitation>(HttpStatus.NOT_IMPLEMENTED);
    }

    // UPDATE INVITATION
    public ResponseEntity<Invitation> updateInvitation(
            @ApiParam(value = "", required = true) @PathVariable("invitationId") String invitationId,
            @ApiParam(value = "")  @Valid @RequestBody InvitationStatus data) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Invitation>(objectMapper.readValue(
                        "{  \"roles\" : [ \"roles\", \"roles\" ],  \"id\" : 0,  \"email\" : 6,  \"status\" : \"pending\"}",
                        Invitation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Invitation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Invitation>(HttpStatus.NOT_IMPLEMENTED);
    }

    // DELETE INVITATION
    public ResponseEntity<Void> deleteInvitation(
            @ApiParam(value = "", required = true) @PathVariable("invitationId") String invitationId) {

        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // CREATE REQUEST
    public ResponseEntity<ParticipantRequest> createRequest(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = ""  )  @Valid @RequestBody VolunteerRequest data) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ParticipantRequest>(objectMapper.readValue(
                        "{  "
                                + "\"firstName\" : \"firstName\",  "
                                + "\"lastName\" : \"lastName\",  "
                                + "\"roles\" : [ \"roles\", \"roles\" ],  "
                                + "\"id\" : \"id\",  "
                                + "\"message\" : \"message\",  "
                                + "\"userId\" : \"userId\",  "
                                + "\"email\" : \"email\",  "
                                + "\"status\" : \"PENDING\"}",
                        ParticipantRequest.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ParticipantRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ParticipantRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    // UPDATE REQUEST
    public ResponseEntity<ParticipantRequest> updateRequest(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = ""  ) @Valid @RequestBody VolunteerRequestStatus data) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ParticipantRequest>(objectMapper.readValue(
                        "{  "
                                + "\"firstName\" : \"firstName\",  "
                                + "\"lastName\" : \"lastName\",  "
                                + "\"roles\" : [ \"roles\", \"roles\" ],  "
                                + "\"id\" : \"id\",  "
                                + "\"message\" : \"message\",  "
                                + "\"userId\" : \"userId\",  "
                                + "\"email\" : \"email\",  "
                                + "\"status\" : \"PENDING\"}",
                        ParticipantRequest.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ParticipantRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ParticipantRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

}
