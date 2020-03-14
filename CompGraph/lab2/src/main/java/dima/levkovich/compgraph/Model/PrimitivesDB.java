package dima.levkovich.compgraph.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="primitives")
public class PrimitivesDB {

    public PrimitivesDB() {
    }
    @Id
    @Column(name="primitive")
    private String name;
    @Column(name="primitiveid")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
