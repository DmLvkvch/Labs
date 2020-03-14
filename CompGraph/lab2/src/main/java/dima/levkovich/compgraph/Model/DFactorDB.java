package dima.levkovich.compgraph.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dfactor")
public class DFactorDB {
    @Column(name="dfactorid")
    private int dfactorid;
    @Id
    @Column(name="dfactor")
    private String dfactor;

    public DFactorDB() {
    }

    public int getDfactorid() {
        return dfactorid;
    }

    public void setDfactorid(int dfactorid) {
        this.dfactorid = dfactorid;
    }

    public String getDfactor() {
        return dfactor;
    }

    public void setDfactor(String dfactor) {
        this.dfactor = dfactor;
    }
}
