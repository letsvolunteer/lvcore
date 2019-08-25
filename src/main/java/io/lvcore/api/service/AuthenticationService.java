package io.lvcore.api.service;


import io.lvcore.model.user.User;

public interface AuthenticationService {
    String getFbAccessToken(String code, String state);
    User getFbUserInfo(String accessToken);
}
