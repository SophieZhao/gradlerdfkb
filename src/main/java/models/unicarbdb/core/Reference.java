/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import java.util.*;

import javax.persistence.*;

import models.hplc.Lcmucin;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

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



}
