package dima.levkovich.compgraph.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alpha")
public class AlphaDB {
    @Column(name="alphaid")
    private int alphaid;
    @Id
    @Column(name="alpha")
    private String alpha;

    public int getAlphaid() {
        return alphaid;
    }

    public void setAlphaid(int alphaid) {
        this.alphaid = alphaid;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }
}
