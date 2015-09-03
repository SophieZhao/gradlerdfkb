/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.core;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(schema="core", name="contributor")
public class Contributor {
	
	 /** Database-supplied id for this contributor */
	@Id
	//public Long Id;
    public Long contributorId;

    /** Username of this contributor. */
    public String contributorName;

    /** Login password for this contributor. */
    public String password;

    /** Full name. */
    public String fullName;

    /** Institution */
    public String institution;

    /** OpenId Identifier */
    public String openId;

    /**
     * email address.
     */
    public String email;

    /****
     * status.
     */
    public Boolean isActivated;

    /**
     *  last login.
     */
    public Date lastLogin;

    /****
     * is Blocked.
     */

    public Boolean isBlocked;

    /** True if contributor has administrative rights */
    public Boolean isAdmin;

    /** Date on which this contributor was created in the DB. */
    public Date dateEntered;



}
