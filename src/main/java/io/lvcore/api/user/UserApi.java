/*
package io.swagger.api.user;

import User;
import UserEvent;
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

public interface UserApi {


    public ResponseEntity<Void> createUser(
            @ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body);


    public ResponseEntity<User> getUserByIdOrEmail(
            @ApiParam(value = "The id/email of user to be fetched", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail);


    public ResponseEntity<Void> updateUser(
            @ApiParam(value = "Id of the user that need to be updated", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail,
            @ApiParam(value = "Updated user object", required = true) @Valid @RequestBody
                    User body);


    public ResponseEntity<Void> deleteUser(
            @ApiParam(value = "The id of the user who needs to be deleted", required = true) @PathVariable("userIdORuserEmail")
                    String userIdORuserEmail);


    public ResponseEntity<String> loginUser(
            @NotNull @ApiParam(value = "The user name for login", required = true)
            @Valid @RequestParam(value = "username", required = true)
                    String username,
            @NotNull @ApiParam(value = "The password hash for login in clear text", required = true)
            @Valid @RequestParam(value = "password", required = true)
                    String password);


    public ResponseEntity<Void> logoutUser();


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


    public ResponseEntity<Json> authorize(
            @RequestParam("code") String code,
            @RequestParam("state") String state);

}
*/
