package io.lvcore.api.event;

import io.lvcore.api.NotFoundException;
import io.lvcore.model.event.Event;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@javax.annotation.Generated(
        value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2019-02-26T05:19:37.458Z")

@Api(value = "event", description = "the event API")
public interface EventApi {

    // CREATE EVENT
    @ApiOperation(
            value = "CreateEvent",
            nickname = "createEvent",
            notes = "",
            response = Event.class,
            authorizations = { @Authorization(value = "api_key") },
            tags = { "Event", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful response.", response = Event.class),
                    @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(
            value = "/events",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Event> createEvent(
            @ApiParam(value = "The event details", required = true) @Valid @RequestBody Event event);

    // GET EVENT
    @ApiOperation(
            value = "GetEvent",
            nickname = "getEventById",
            notes = "",
            response = Event.class,
            tags = { "Event", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful response.", response = Event.class),
                    @ApiResponse(code = 404, message = "Event not found") })
    @RequestMapping(
            value = "/events/{eventId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Event> getEventById(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = "true if the event details are needed.", defaultValue = "false")
            @Valid @RequestParam(value = "withDetails", required = false, defaultValue="false")
                    Boolean withDetails) throws NotFoundException;

    // GET EVENTS
    @ApiOperation(
            value = "GetEvents",
            nickname = "getEvents",
            notes = "Returns list of events based on query parameters (filter criteria)",
            response = Event.class,
            responseContainer = "List",
            authorizations = { @Authorization(value = "api_key") },
            tags = { "Event", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful operation", response = Event.class, responseContainer = "List"),
                    @ApiResponse(code = 400, message = "Invalid query parameter combination.") })
    @RequestMapping(
            value = "/events",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Event>> getEvents(
            @ApiParam(value = "", allowableValues = "location, category")
            @Valid @RequestParam(value = "filterBy", required = false)
                    String filterBy,
            @ApiParam(value = "")
            @Valid @RequestParam(value = "filterFor", required = false)
                    String filterFor,
            @ApiParam(value = "", allowableValues = "distance, date")
            @Valid @RequestParam(value = "sortBy", required = false)
                    String sortBy);

    // UPDATE EVENT
    @ApiOperation(
            value = "UpdateEvent",
            nickname = "updateEvent",
            notes = "",
            response = Event.class,
            authorizations = { @Authorization(value = "api_key") },
            tags = { "Event", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful response.", response = Event.class),
                    @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/events/{eventId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Event> updateEvent(
            @ApiParam(value = "The id of the event to be updated", required = true) @PathVariable("eventId") String eventId,
            @ApiParam(value = "The updated event details", required = true) @Valid @RequestBody Event event);

    // DELETE EVENT
    @ApiOperation(
            value = "DeleteEvent",
            nickname = "deleteEventById",
            notes = "",
            tags = { "Event", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful operation")
            })
    @RequestMapping(
            value = "/events/{eventId}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEventById(
            @ApiParam(value = "", required = true) @PathVariable("eventId") String eventId);
}
