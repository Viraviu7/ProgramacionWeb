package programacionweb.springback.models.db.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompundPrimaryKey implements Serializable{

    private Long primaryKey1;
    private Long primaryKey2;

    public CompundPrimaryKey() {
    }

    public CompundPrimaryKey(Long primaryKey1, Long primaryKey2) {
        this.primaryKey1 = primaryKey1;
        this.primaryKey2 = primaryKey2;
    }

    public Long getPrimaryKey1() {
        return primaryKey1;
    }

    public void setPrimaryKey1(Long primaryKey1) {
        this.primaryKey1 = primaryKey1;
    }

    public Long getPrimaryKey2() {
        return primaryKey2;
    }

    public void setPrimaryKey2(Long primaryKey2) {
        this.primaryKey2 = primaryKey2;
    }

}
