
package logic;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient extends Person implements Serializable{
    
    //private int id_patient;
    private boolean have_medical_insurance;
    private String blood_type;
    //1 to 1
    @OneToOne
    private Responsible aResponsible;
    //1 to N
    @OneToMany(mappedBy="patien")
    private List<Shift> listShifts;

    public Patient() {
    }

    public Patient(boolean have_medical_insurance, String blood_type, Responsible aResponsible, List<Shift> listShifts, int id, String dni, String name, String last_name, String phone, String address, Date date_birth) {
        super(id, dni, name, last_name, phone, address, date_birth);
        this.have_medical_insurance = have_medical_insurance;
        this.blood_type = blood_type;
        this.aResponsible = aResponsible;
        this.listShifts = listShifts;
    }

   

    public boolean isHave_medical_insurance() {
        return have_medical_insurance;
    }

    public void setHave_medical_insurance(boolean have_medical_insurance) {
        this.have_medical_insurance = have_medical_insurance;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public Responsible getaResponsible() {
        return aResponsible;
    }

    public void setaResponsible(Responsible aResponsible) {
        this.aResponsible = aResponsible;
    }

    public List<Shift> getListShifts() {
        return listShifts;
    }

    public void setListShifts(List<Shift> listShifts) {
        this.listShifts = listShifts;
    }

    //Convierte ResponsibleId a String
    @Override
    public String toString() {
        return "Responsible ID: " + super.getId();
    }

 
    
}
