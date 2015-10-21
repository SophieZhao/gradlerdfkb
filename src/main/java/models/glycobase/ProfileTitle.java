package models.glycobase;

import javax.persistence.*;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="profile_title")
public class ProfileTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_title_gen")
    @SequenceGenerator(name = "profile_title_gen", sequenceName = "profile_title_id_seq", allocationSize=1)
    public Long Id;

    public int profileId;

    public String profileTitle;

    @ManyToOne
    public Structure structure;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitle(String profileTitle) {
        this.profileTitle = profileTitle;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
}
