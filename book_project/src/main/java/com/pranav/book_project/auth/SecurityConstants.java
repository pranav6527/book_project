package com.pranav.book_project.auth;

public class SecurityConstants {

  public static final long EXPIRATION_TIME = 432000000;
  public static final String JWT_PREFIX = "Bearer ";
  public static final String JWT_TOKEN_HEADER = "Jwt-Token";
  public static final String TOKEN_CANNOT_BE_VARIFIED = "Token cannot be verified";
  public static final String AUTHORITIES = "Authorities";
  public static final String FORBIDDEN_MESSAGE = "You need to login to access this page";
  public static final String OPTION_HTTP_METHOD = "OPTIONS";
  public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
  public static final String[] PUBLIC_URLS = {"/user/login",  "user/registered","user/resetpassword/**"};


}
