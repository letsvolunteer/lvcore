package io.swagger.api.user;

import io.swagger.model.user.User;
import io.swagger.model.user.UserEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import springfox.documentation.spring.web.json.Json;

@javax.annotation.Generated(
        value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2019-02-26T05:19:37.458Z")
@Api(value = "User", description = "User API")
public interface UserApi {

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
            @ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body);

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
                    String userIdORuserEmail);

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
                    User body);

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
                    String userIdORuserEmail);

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
                    String password);

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
    public ResponseEntity<Void> logoutUser();

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
                    Integer total);

    // AUTHORIZE REDIRECT
    @ApiOperation(
            value = "Authorize",
            nickname = "authorize",
            notes = "",
            response = String.class,
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = String.class),
            @ApiResponse(code = 400, message = "Invalid username/password supplied") })
    @RequestMapping(value = "/authorize",
            produces = { "application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Json> authorize(
            @ApiParam(value = "The code from ID provider", required = true) @PathVariable("code") String code,
            @ApiParam(value = "The generated state", required = true) @PathVariable("state") String state);

}
