package com.pentaho.ho.ho.pentahoApi;

public class StringUrl {

    private String ACLofFile = "http://localhost:8080/pentaho/api/repo/files/";

    public String getACLofFile() {
        return ACLofFile;
    }

    public void setACLofFile(String fileName){
        new StringBuilder(ACLofFile).append(fileName).append("/acl");
        this.ACLofFile = ACLofFile + fileName + "/acl";
    }
}
