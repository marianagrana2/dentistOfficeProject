
package logic;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Secretary extends Person{
    //private int id_Secretary;
    private String sector;
    @OneToOne
    private User aUser;

    public Secretary() {
    }

    public Secretary(String sector, User aUser, int id, String dni, String name, String last_name, String phone, String address, Date date_birth) {
        super(id, dni, name, last_name, phone, address, date_birth);
        this.sector = sector;
        this.aUser = aUser;
    }

    

  
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }
    
     @Override
    public String toString() {
        return "a User ID: " + super.getId();
    }
}
