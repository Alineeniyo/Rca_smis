package rw.ac.rca.webapp.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parents")
public class Parent extends Person {
    @Column
    @NotNull
    private String nationalId;

    public Parent(String firstName, String lastName, String phoneNumber, String nationalId) {
        super(firstName, lastName, phoneNumber);
        this.nationalId = nationalId;
//        this.phoneNumber = phoneNumber;
    }


    public Parent() {

    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}