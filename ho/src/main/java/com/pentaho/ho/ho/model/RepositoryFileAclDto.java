package com.pentaho.ho.ho.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class RepositoryFileAclDto {

    /*
    These two XmlElements will not be changed thus not specified.
    -> entriesInheriting
    -> id
    */

    private List<Ace> aces;
    private String owner;
    private int ownerType;

    public RepositoryFileAclDto(){}
    public RepositoryFileAclDto(List<Ace> aces, String owner, int ownerType){
        super();
        this.aces = aces;
        this.owner = owner;
        this.ownerType = ownerType;
    }

    @XmlElement
    public List<Ace> getAces() {
        return aces;
    }

    public void setAces(List<Ace> aces) {
        this.aces = aces;
    }

    @XmlElement
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @XmlElement
    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }
}
