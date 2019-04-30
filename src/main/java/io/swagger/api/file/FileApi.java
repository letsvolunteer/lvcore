package io.swagger.api.file;

import io.swagger.model.file.FileUrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
@javax.annotation.Generated(
        value = "io.swagger.codegen.languages.SpringCodegen",
        date = "2019-02-26T05:19:37.458Z")

@Api(value = "Event File", description = "Event File API")
public interface FileApi {
    @ApiOperation(
            value = "UploadFile",
            nickname = "filesPost",
            notes = "Upload file for an event (eg. event banner)",
            response = FileUrl.class,
            tags = { "Event File", })
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "successful upload", response = FileUrl.class)
            })
    @RequestMapping(
            value = "/files",
            produces = { "application/json" },
            consumes = { "multipart/form-data" },
            method = RequestMethod.POST)
    ResponseEntity<FileUrl> filesPost(
            @ApiParam(value = "file detail")
            @Valid @RequestPart("file")
            MultipartFile file);
}
