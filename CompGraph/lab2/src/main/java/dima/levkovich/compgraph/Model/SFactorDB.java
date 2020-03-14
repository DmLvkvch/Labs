package dima.levkovich.compgraph.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sfactor")
public class SFactorDB {
    @Column(name="sfactorid")
    private int sfactorid;
    @Id
    @Column(name="sfactor")
    private String sfactor;

    public SFactorDB() {
    }

    public int getSfactorid() {
        return sfactorid;
    }

    public void setSfactorid(int sfactorid) {
        this.sfactorid = sfactorid;
    }

    public String getSfactor() {
        return sfactor;
    }

    public void setSfactor(String sfactor) {
        this.sfactor = sfactor;
    }
}
