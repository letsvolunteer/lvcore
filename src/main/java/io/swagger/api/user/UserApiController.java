package io.swagger.api.user;

import io.swagger.annotations.ApiParam;
import io.swagger.model.user.User;
import io.swagger.model.user.UserEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(
        value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2019-02-26T05:19:37.458Z")
@RestController
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // CREATE USER
    public ResponseEntity<Void> createUser(
            @ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body) {

        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // GET USER
    public ResponseEntity<User> getUserByIdOrEmail(
            @ApiParam(value = "The id/email of user to be fetched", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail) {

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
    public ResponseEntity<Void> updateUser(
            @ApiParam(value = "Id of the user that need to be updated", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail,
            @ApiParam(value = "Updated user object", required = true) @Valid @RequestBody
                    User body) {

        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // DELETE USER
    public ResponseEntity<Void> deleteUser(
            @ApiParam(value = "The id of the user who needs to be deleted", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // LOGIN USER
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
    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    // GET EVENTS FOR USER
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
    public ResponseEntity<Json> authorize(
            @ApiParam(value = "The code from ID provider", required = true) @PathVariable("code") String code,
            @ApiParam(value = "The generated state", required = true) @PathVariable("state") String state) {

        return new ResponseEntity<Json>(new Json("{\"success\" : true}"), HttpStatus.OK);
    }

}
