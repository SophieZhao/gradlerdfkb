/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;

import javax.persistence.*;

import models.unicarbdb.hplc.Lcmucin;




import com.avaje.ebean.*;

@Entity
@Table(schema="core", name="core.reference")
public class Reference  {
	
	@Id
	//public Long Id;
	public Long referenceId;

    /** The contributor of this reference. */
    public Contributor contributor;

    /** Date this reference was created in the data store. */
    public Date dateEntered;

    /** The {@link Type type} of this reference -- this should be 
    *   changed to a Type enum in the future!!  */
    public String referenceType;

    /** mjh: This is a temporary variable that holds the enum version of 
    *   String {@link #referenceType} -- remove this variable when 
    *   hibernate is configured to convert to/from enums directly!! */
    public Type refType;

    /** The Id of this reference as given by the 3rd party to which 
    *   this reference belongs  */
    public String externalReferenceId;

    /** Name of 3rd party to which this reference belongs */
    public String externalReferenceName;

    public String url;

    /** Any relevant extra info as appropriate to the type of reference. */
    public String referenceComments;
    
    /** Enumeration of supported reference types. */
    public enum Type
    {
        Journal("journal"),
        DatabaseEntry("database"),
        Web("website")
        ;

        /** string id used in the database */
        String id;

        Type( String id ) {  this.id = id;  }

        public final String toString() {  return id;  }
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public Type getRefType() {
        return refType;
    }

    public void setRefType(Type refType) {
        this.refType = refType;
    }

    public String getExternalReferenceId() {
        return externalReferenceId;
    }

    public void setExternalReferenceId(String externalReferenceId) {
        this.externalReferenceId = externalReferenceId;
    }

    public String getExternalReferenceName() {
        return externalReferenceName;
    }

    public void setExternalReferenceName(String externalReferenceName) {
        this.externalReferenceName = externalReferenceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferenceComments() {
        return referenceComments;
    }

    public void setReferenceComments(String referenceComments) {
        this.referenceComments = referenceComments;
    }
}
