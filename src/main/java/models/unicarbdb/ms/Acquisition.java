/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema="ms", name="acquisition")
public class Acquisition {


	// public Integer acquisitionId;
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acquisition_gen")
    @SequenceGenerator(name = "acquisition_gen", sequenceName = "ms.acquisition_acquisition_id_seq", allocationSize=1)
    @Id
    private Long acquisitionId;

    @ManyToOne
    @JoinColumn(name="device_id")
    public Device device;

   // public Integer evidenceId;

    public String filename = "testform.gwp";

    public String filetype = "gwp";

    //@Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dateObtained = new Date();

    //@Column(name="contributor_quality", columnDefinition = "Double default '1.0'")
    public Double contributorQuality = 1.0;

    /*@ManyToOne
    @JoinColumn(name="user_id")
    public User user;
    */

    public List<AcquisitionToPersubstitution> AcquisitionToPersubstitutions;
    public List<Scan> scans;
    //public List<DeviceSettings> deviceSettingses; // = new HashSet<org.eurocarbdb.dataaccess.ms.DeviceSettings>();

    //@OneToMany(mappedBy = "preparations")
    //public List<Preparation> preparations; // = new HashSet<org.eurocarbdb.dataaccess.experiment.Preparation>();


    /*
    setters
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void setDateObtained(Date dateObtained) {
        this.dateObtained = dateObtained;
    }

    public void setContributorQuality(Double contributorQuality) {
        this.contributorQuality = contributorQuality;
    }

    public void setAcquisitionToPersubstitutions(List<AcquisitionToPersubstitution> acquisitionToPersubstitutions) {
        AcquisitionToPersubstitutions = acquisitionToPersubstitutions;
    }

    public void setScans(List<Scan> scans) {
        this.scans = scans;
    }

    public Long getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(Long acquisitionId) {
        this.acquisitionId = acquisitionId;
    }
}
