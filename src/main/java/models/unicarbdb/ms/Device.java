/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="device")
public class Device  {
	
	@Id
	@Column(name = "device_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_gen")
    @SequenceGenerator(name = "device_gen", sequenceName = "ms.device_device_id_seq", allocationSize=1)
	public Long deviceId;

    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    @Column(name="manufacturer_id")
    public Manufacturer manufacturer;

    @OneToMany(mappedBy = "device")
    public List<Acquisition> acquisition;

    public String model;

    public String ionisationType;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<Acquisition> getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(List<Acquisition> acquisition) {
        this.acquisition = acquisition;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIonisationType() {
        return ionisationType;
    }

    public void setIonisationType(String ionisationType) {
        this.ionisationType = ionisationType;
    }
}
