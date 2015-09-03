/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import models.hplc.Lcmucin;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="reducing_end")
public class ReducingEnd  {
	
	@Id
    @Column(name="reducing_end_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reducing_end_gen")
    @SequenceGenerator(name = "reducing_end_gen", sequenceName = "ms.reducing_end_reducing_end_id_seq", allocationSize=1)
	//public Long Id;
	public Long reducingEndId;
    private String abbreviation;
    public String name;
    private String uri;
    
    @OneToMany
    private List<PeakAnnotated> peakAnnotateds; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakAnnotated>();

    @OneToMany(mappedBy = "reducingEnd")
    public List<Scan> scan; // = new HashSet<scan>(0);

    @OneToMany(mappedBy = "reducingEnd")
    public List<models.unicarbdb.hplc.Lcmucin> lcmucin;


}
