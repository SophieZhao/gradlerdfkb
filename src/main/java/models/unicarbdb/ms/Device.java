/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.db.ebean.Model;

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

    //public Set<Source> sources = new HashSet<Source>(0);

    //public Set<FragmentationType> fragmentationTypes = new HashSet<FragmentationType>(0);

    //public Set<Analyser> analysers = new HashSet<Analyser>(0);

    //public Set<Laser> lasers = new HashSet<Laser>(0);

    //public Set<Acquisition> acquisitions = new HashSet<Acquisition>(0);

    //public Set<MassDetector> massDetectors = new HashSet<MassDetector>(0);

}
