
package logic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dentist extends Person implements Serializable{
    
    //private int id_dentist;
    private String specialty;
    @OneToMany(mappedBy="dent")
    private List<Shift> listShifts;
    @OneToOne
    private User aUser;
    @OneToOne
    private Schedule aSchedule;

    public Dentist() {
    }

    public Dentist(String specialty, List<Shift> listShifts, User aUser, Schedule aSchedule, int id, String dni, String name, String last_name, String phone, String address, Date date_birth) {
        super(id, dni, name, last_name, phone, address, date_birth);
        this.specialty = specialty;
        this.listShifts = listShifts;
        this.aUser = aUser;
        this.aSchedule = aSchedule;
    }

   
    
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Shift> getListShifts() {
        return listShifts;
    }

    public void setListShifts(List<Shift> listShifts) {
        this.listShifts = listShifts;
    }

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }

    public Schedule getaSchedule() {
        return aSchedule;
    }

    public void setaSchedule(Schedule aSchedule) {
        this.aSchedule = aSchedule;
    }
   
    @Override
    public String toString() {
        return "a User ID: " + super.getId();
    }

}
