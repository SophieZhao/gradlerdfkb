package models.glycobase;
import java.util.List;
import javax.persistence.*;

/**
 * Created by matthew on 19/10/2015.
 */
@Entity
@Table(schema="public", name="hplc")
public class Hplc {

    @Id
    public Long Id;

    @ManyToOne
    public Structure structure;

    public double gu;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public double getGu() {
        return gu;
    }

    public void setGu(double gu) {
        this.gu = gu;
    }
}
