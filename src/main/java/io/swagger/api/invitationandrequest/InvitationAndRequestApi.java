package io.swagger.api.invitationandrequest;

import io.swagger.model.*;
import io.swagger.annotations.*;
import io.swagger.model.invitationandrequest.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(
        value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2019-02-26T05:19:37.458Z")
@Api(value = "invitations", description = "the invitations API")
public interface InvitationAndRequestApi {

    // CREATE INVITATION
    @ApiOperation(
            value = "CreateInvitation",
            nickname = "eventsEventIdInvitationsPost",
            notes = "", response = Invitation.class,
            tags = { "Event Invitation", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "invitation sent", response = Invitation.class),
            @ApiResponse(code = 400, message = "invalid email address"),
            @ApiResponse(code = 404, message = "event not found or not accepting volunteers") })
    @RequestMapping(value = "/events/{eventId}/invitations",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Invitation> createInvitation(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = ""  ) @Valid @RequestBody InvitationRequest invitationRequest);

    // UPDATE INVITATION
    @ApiOperation(
            value = "UpdateInvitation",
            nickname = "invitationsInvitationIdPut",
            notes = "Accept or reject an event invitation",
            response = Invitation.class,
            tags = { "Event Invitation", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful invitation response", response = Invitation.class)
            })
    @RequestMapping(
            value = "/invitations/{invitationId}",
            method = RequestMethod.PUT)
    ResponseEntity<Invitation> updateInvitation(
            @ApiParam(value = "", required = true) @PathVariable("invitationId") String invitationId,
            @ApiParam(value = ""  ) @Valid @RequestBody InvitationStatus data);

    // DELETE INVITATION
    @ApiOperation(
            value = "DeleteInvitation",
            nickname = "invitationsInvitationIdDelete",
            notes = "Cancel an invitation",
            tags = { "Event Invitation", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Invitation cancelled"),
                    @ApiResponse(code = 404, message = "Invalid invitation id.")
            })
    @RequestMapping(
            value = "/invitations/{invitationId}",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvitation(
            @ApiParam(value = "", required = true) @PathVariable("invitationId") String invitationId);

    // CREATE REQUEST
    @ApiOperation(
            value = "CreateRequest",
            nickname = "requestToVolunteer",
            notes = "send request to volunteer for the event",
            response = ParticipantRequest.class,
            tags = { "Event Request", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "request successfully sent", response = ParticipantRequest.class),
            @ApiResponse(code = 400, message = "validation errors", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "event non-existant or not accepting volunteers", response = ErrorResponse.class) })
    @RequestMapping(
            value = "/event/{eventId}/requests",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    ResponseEntity<ParticipantRequest> createRequest(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = ""  ) @Valid @RequestBody VolunteerRequest data);

    // RESPOND TO VOLUNTEER REQUEST
    @ApiOperation(
            value = "UpdateRequest",
            nickname = "respondToVolunteerRequest",
            notes = "", response = ParticipantRequest.class,
            tags = { "Event Request", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "response to volunteer request", response = ParticipantRequest.class),
            @ApiResponse(code = 400, message = "invalid status value", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "non-existant event id", response = ErrorResponse.class) })
    @RequestMapping(
            value = "/event/{eventId}/requests",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.PUT)
    ResponseEntity<ParticipantRequest> updateRequest(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = ""  ) @Valid @RequestBody VolunteerRequestStatus data);

}
