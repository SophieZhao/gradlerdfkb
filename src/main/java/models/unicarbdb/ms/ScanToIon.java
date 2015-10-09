/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;



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

    public Long getScanToIonId() {
        return scanToIonId;
    }

    public void setScanToIonId(Long scanToIonId) {
        this.scanToIonId = scanToIonId;
    }

    public Ion getIon() {
        return ion;
    }

    public void setIon(Ion ion) {
        this.ion = ion;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public boolean isGain() {
        return gain;
    }

    public void setGain(boolean gain) {
        this.gain = gain;
    }

    public String getNeutralexchange() {
        return neutralexchange;
    }

    public void setNeutralexchange(String neutralexchange) {
        this.neutralexchange = neutralexchange;
    }
}
