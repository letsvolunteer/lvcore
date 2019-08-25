package io.lvcore.api.user;

import io.lvcore.model.user.User;
import io.swagger.annotations.*;
import io.lvcore.api.service.AuthenticationService;
import io.lvcore.model.user.UserEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Api(value = "User", description = "User API")
@RestController
public class UserApiController {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final AuthenticationService authService;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request, AuthenticationService authService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.authService = authService;
    }

    // CREATE USER
    @ApiOperation(
            value = "CreateUser",
            nickname = "createUser",
            notes = "This can only be done by the logged in user.",
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation") })
    @RequestMapping(
            value = "/user",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(
            @ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body) {

        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // GET USER
    @ApiOperation(
            value = "GetUser",
            nickname = "getUserByIdOrEmail",
            notes = "",
            response = User.class,
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = User.class),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
            value = "/user/{userIdORuserEmail}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<User> getUserByIdOrEmail(
            @ApiParam(value = "The id/email of user to be fetched", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail) {
        log.debug("In getUserByIdOrEmail");
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                log.debug("Going to map object");
                return new ResponseEntity<User>(objectMapper.readValue("{  "
                                + "\"firstName\" : \"firstName\",  "
                                + "\"lastName\" : \"lastName\",  "
                                + "\"phone\" : \"phone\",  "
                                + "\"providerId\" : \"providerId\",  "
                                + "\"id\" : \"id\",  "
                                + "\"email\" : \"email\",  "
                                + "\"passwordHash\" : \"passwordHash\",  "
                                + "\"identityProvider\" : \"identityProvider\"}",
                        User.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    // UPDATE USER
    @ApiOperation(
            value = "UpdateUser",
            nickname = "updateUser",
            notes = "This can only be done by the logged in user.",
            tags = { "User", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Invalid user provided"),
                    @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
            value = "/user/{userIdORuserEmail}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(
            @ApiParam(value = "Id of the user that need to be updated", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail,
            @ApiParam(value = "Updated user object", required = true) @Valid @RequestBody
                    User body) {

        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // DELETE USER
    @ApiOperation(
            value = "DeleteUser",
            nickname = "deleteUser",
            notes = "This can only be done by the logged in user.",
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid username supplied"),
            @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
            value = "/user/{userIdORuserEmail}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(
            @ApiParam(value = "The id of the user who needs to be deleted", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // LOGIN USER
    @ApiOperation(
            value = "LoginUser",
            nickname = "loginUser",
            notes = "",
            response = String.class,
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = String.class),
            @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @RequestMapping(value = "/user/login",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.GET)
    public ResponseEntity<String> loginUser(
            @NotNull @ApiParam(value = "The user name for login", required = true)
            @Valid @RequestParam(value = "username", required = true)
                    String username,
            @NotNull @ApiParam(value = "The password hash for login in clear text", required = true)
            @Valid @RequestParam(value = "password", required = true)
                    String password) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"\"", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("aeiou", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    // LOGOUT USER
    @ApiOperation(
            value = "LogoutUser",
            nickname = "logoutUser",
            notes = "",
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation") })
    @RequestMapping(
            value = "/user/logout",
            produces = { "application/json", "application/xml" },
            method = RequestMethod.GET)
    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // GET EVENTS FOR USER
    @ApiOperation(
            value = "GetEventsForUser",
            nickname = "getUserEvents",
            notes = "This can only be done by the logged in user.",
            response = UserEvent.class,
            responseContainer = "List",
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = UserEvent.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid user id or email supplied"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
            value = "/user/{userIdORuserEmail}/events",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<UserEvent>> getUserEvents(
            @ApiParam(value = "The id or email of user", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail,
            @ApiParam(value = "Specify the type of events.", allowableValues = "all, upcoming, invited, requested, past")
            @Valid @RequestParam(value = "eventType", required = false)
                    String eventType,
            @ApiParam(value = "Number of current results for pagination") @Valid @RequestParam(value = "count", required = false)
                    Integer count,
            @ApiParam(value = "Pagination offset") @Valid @RequestParam(value = "offset", required = false)
                    Integer offset,
            @ApiParam(value = "") @Valid @RequestParam(value = "total", required = false)
                    Integer total) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<UserEvent>>(objectMapper.readValue(
                        "[ {  "
                                + "\"eventId\" : \"eventId\",  "
                                + "\"userEventType\" : \"all\",  "
                                + "\"userId\" : \"userId\",  "
                                + "\"eventDate\" : \"2000-01-23\""
                            + "}, "
                            + "{  "
                                + "\"eventId\" : \"eventId\",  "
                                + "\"userEventType\" : \"all\",  "
                                + "\"userId\" : \"userId\",  "
                                + "\"eventDate\" : \"2000-01-23\""
                            + "} ]",
                        List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<UserEvent>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<UserEvent>>(HttpStatus.NOT_IMPLEMENTED);
    }

    // AUTHORIZE REDIRECT
    @ApiOperation(
            value = "Authorize",
            nickname = "authorize",
            notes = "",
            response = String.class,
            tags = { "User" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = String.class),
            @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @RequestMapping(value = "/authorize",
            produces = { "application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<User> authorize(
             @RequestParam("code") String code,
            @RequestParam("state") String state) {

        log.trace("Received callback /authorize" + state);
        String accessToken = authService.getFbAccessToken(code, state);
        User user = authService.getFbUserInfo(accessToken);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
