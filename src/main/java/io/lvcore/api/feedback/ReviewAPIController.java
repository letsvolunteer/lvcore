package io.lvcore.api.feedback;

import io.lvcore.model.feedback.Review;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@Slf4j
@Api(value = "Feedback", description = "Feedback and badges APIs")
@RestController
public class ReviewAPIController {

    @ApiOperation(
            value = "PostReview",
            nickname = "PostReview",
            notes = "This can only be done by the logged in user.",
            response = Review.class,
            responseContainer = "List",
            tags = { "User", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = Review.class),
            @ApiResponse(code = 400, message = "Invalid parameters"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "User not found") })
    @RequestMapping(
            value = "/user/{userIdORuserEmail}/feedback",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Review> createReview(@ApiParam(value = "The id/email of user to be reviewed", required = true) @PathVariable("userIdORuserEmail")
    String userIdORuserEmail, @Valid @RequestBody Review review) {
        Review review1 = new Review(review.getText(), Instant.now(),
                "SUBMITTED", userIdORuserEmail, review.getHostId());
        return new ResponseEntity<Review>(review1, HttpStatus.OK);
    }
}
