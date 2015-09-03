/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import javax.persistence.*;

@Entity
@Table(schema = "ms", name = "ms.ion")
public class Ion {

    @Id
    @Column(name = "ion_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ion_gen")
    @SequenceGenerator(name = "ion_gen", sequenceName = "ms.ion_ion_id_seq", allocationSize = 1)
    //public Long Id;
    public Long ionId;

    public String ionType;
    public Integer charge;
    public Boolean positive;
    public Boolean atomer;
    //public Set<org.eurocarbdb.dataaccess.ms.IonComposition> ionCompositions = new HashSet<org.eurocarbdb.dataaccess.ms.IonComposition>();
    //public Set<org.eurocarbdb.dataaccess.ms.PeakAnnotatedToIon> peakAnnotatedToIons = new HashSet<org.eurocarbdb.dataaccess.ms.PeakAnnotatedToIon>();


}
