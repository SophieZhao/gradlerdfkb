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
@Table(schema="ms", name="ms.peak_list_annotation")
public class PeakListAnnotation  {
	
	@Id
    @Column(name="peak_list_annotation_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peak_list_annotation_gen")
    @SequenceGenerator(name = "peak_list_annotation_gen", sequenceName = "ms.peak_list_annotation_peak_list_annotation_id_seq", allocationSize=1)
	//public Long Id;
	private Long peakListAnnotationId;
    private String description;
    private List<PeakList> peakLists; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakList>();

}
