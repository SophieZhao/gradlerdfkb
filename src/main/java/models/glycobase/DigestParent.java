package models.glycobase;

import javax.persistence.*;
import java.util.List;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="digest_parent")
public class DigestParent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "digest_parent_gen")
    @SequenceGenerator(name = "digest_parent_gen", sequenceName = "digest_parent_id_seq", allocationSize=1)
    public Long Id;

    public String technique;
    public String name;
    public String enzymes;
    public double gu;
    public int profileId;
    public String profileName;
    public String profileInstrument;
    public String standard;

    @ManyToOne
    public Structure structure;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnzymes() {
        return enzymes;
    }

    public void setEnzymes(String enzymes) {
        this.enzymes = enzymes;
    }

    public double getGu() {
        return gu;
    }

    public void setGu(double gu) {
        this.gu = gu;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileInstrument() {
        return profileInstrument;
    }

    public void setProfileInstrument(String profileInstrument) {
        this.profileInstrument = profileInstrument;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
}
