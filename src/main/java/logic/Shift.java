
package logic;
//Turno

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Shift implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_shift;
    @Temporal(TemporalType.DATE)
    private Date date_shift;
    private String time_shift;
    private String treatment;
    @ManyToOne
    @JoinColumn(name="id_denti")
    private Dentist dent;

    @ManyToOne
    @JoinColumn(name="id_patie")
    private Patient patien;
    
    public Shift() {
    }

    public Shift(int id_shift, Date date_shift, String time_shift, String treatment) {
        this.id_shift = id_shift;
        this.date_shift = date_shift;
        this.time_shift = time_shift;
        this.treatment = treatment;
    }

    public int getId_shift() {
        return id_shift;
    }

    public void setId_shift(int id_shift) {
        this.id_shift = id_shift;
    }

    public Date getDate_shift() {
        return date_shift;
    }

    public void setDate_shift(Date date_shift) {
        this.date_shift = date_shift;
    }

    public String getTime_shift() {
        return time_shift;
    }

    public void setTime_shift(String time_shift) {
        this.time_shift = time_shift;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Dentist getDent() {
        return dent;
    }

    public void setDent(Dentist dent) {
        this.dent = dent;
    }

    public Patient getPatien() {
        return patien;
    }

    public void setPatien(Patient patien) {
        this.patien = patien;
    }
    
    
}
