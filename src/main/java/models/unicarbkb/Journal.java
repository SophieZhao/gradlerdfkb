package models.unicarbkb;

import javax.persistence.*;

/**
 * Created by matthew on 07/05/2014.
 */

/**
 * Journal entity managed by Ebean
 */
@Entity
@Table(schema = "public", name = "journal")
public class Journal {

    @Id
    public Long id;

    public String shortname;
    public String name;

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


//public static Model.Finder<Long,Journal> find = new Model.Finder<Long,Journal>(Long.class, Journal.class);

}
