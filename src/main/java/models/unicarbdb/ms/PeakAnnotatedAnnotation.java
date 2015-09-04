/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(schema="ms")
public class PeakAnnotatedAnnotation {
	
	@Id
	 private Long peakAnnotatedAnnotationId;
	 private String description;
	    private List<PeakAnnotated> peakAnnotateds; // = new HashSet<org.eurocarbdb.dataaccess.ms.PeakAnnotated>();

	public Long getPeakAnnotatedAnnotationId() {
		return peakAnnotatedAnnotationId;
	}

	public void setPeakAnnotatedAnnotationId(Long peakAnnotatedAnnotationId) {
		this.peakAnnotatedAnnotationId = peakAnnotatedAnnotationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PeakAnnotated> getPeakAnnotateds() {
		return peakAnnotateds;
	}

	public void setPeakAnnotateds(List<PeakAnnotated> peakAnnotateds) {
		this.peakAnnotateds = peakAnnotateds;
	}
}
