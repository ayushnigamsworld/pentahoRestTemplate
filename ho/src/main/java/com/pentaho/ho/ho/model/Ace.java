package com.pentaho.ho.ho.model;

public class Ace {

    private boolean modifiable;
    private int permissions;
    private String recipient;
    private int recipientType;

    public Ace(){}
    public Ace(boolean modifiable, int permissions, String recipient, int recipientType){
        super();
        this.modifiable = modifiable;
        this.permissions = permissions;
        this.recipient = recipient;
        this.recipientType = recipientType;
    }

    public boolean isModifiable() {
        return modifiable;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(int recipientType) {
        this.recipientType = recipientType;
    }
}
