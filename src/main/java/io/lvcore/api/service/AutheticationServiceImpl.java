package io.lvcore.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lvcore.data.UserDTO;
import io.lvcore.model.user.User;
import io.lvcore.data.UserDBService;
import io.lvcore.util.BaseUtils;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Setter
@Service
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class AutheticationServiceImpl implements AuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(AutheticationServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserDBService userDBService;

    @Value("${external.fb.url.api.base}")
    private String fbBaseUrl;

    @Value("${external.fb.client.id}")
    private String fbClientId;

    @Value("${external.fb.client.secret}")
    private String fbCs;

    @Value("${external.fb.redirect.uri}")
    private String redirectUri;

    @Override
    public String getFbAccessToken(String code, String state) {
        ObjectMapper objectMapper = new ObjectMapper();
        String accessToken = null;
        log.trace("In AutheticationServiceImpl.getFbAccessToken");
        String path = String.format(fbBaseUrl + "/oauth/access_token?client_id=%s&redirect_uri=%s&client_secret=%s&code=%s",
                fbClientId,redirectUri, fbCs, code);
        log.debug("URI=" +path);
        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(path, String.class);
            log.debug("Response from FB access_token = " +response.getBody());
            JsonNode res = objectMapper.readTree(response.getBody());
            accessToken = res.get("access_token").asText();
        } catch (HttpClientErrorException ex) {
            log.error("Error from API:" + ex.getLocalizedMessage());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    public User getFbUserInfo(String accessToken) {
        ObjectMapper objectMapper = new ObjectMapper();
        String path = String.format(fbBaseUrl + "/me?fields=id,name,email&access_token=%s",
                accessToken);
        ResponseEntity<User> response
                = restTemplate.getForEntity(path, User.class);
        User fbuser = response.getBody();
       UserDTO user = userDBService.getUserByEmail(fbuser.getEmail());
        if(user == null) {
            userDBService.insertUser(new UserDTO(BaseUtils.geneerateId(), fbuser.getId(), fbuser.getName(),
                    fbuser.getEmail(),"fb"));

        }

        return fbuser;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
