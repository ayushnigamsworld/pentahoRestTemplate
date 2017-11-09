package com.pentaho.ho.ho.authorization;

import org.apache.tomcat.util.codec.binary.Base64;

public class Authorization {

    private String credentials;

    public Authorization(String username, String password)
    {
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        this.credentials = new String(base64CredsBytes);
    }

    public String getCredentials()
    {
        return credentials;
    }
}
