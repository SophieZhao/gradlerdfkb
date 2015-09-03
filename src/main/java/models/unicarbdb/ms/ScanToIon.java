/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
@Table(schema = "ms", name = "scan_to_ion")
public class ScanToIon  {

    //public int scanToIonId;
    @Id
    @Column(name = "scan_to_ion_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scan_to_ion_gen")
    @SequenceGenerator(name = "scan_to_ion_gen", sequenceName = "ms.scan_to_ion_scan_to_ion_id_seq", allocationSize = 1)
    public Long scanToIonId;

    public Ion ion;

    @ManyToOne
    @JoinColumn(name = "scan_id")
    @Column(name = "scan_id")
    public Scan scan;

    public int charge;
    public boolean gain;
    public String neutralexchange;


}
