
package logic;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Responsible extends Person {
    
    //private int id_responsible;
    private String type_resp;

    public Responsible() {
    }

    public Responsible(String type_resp, int id, String dni, String name, String last_name, String phone, String address, Date date_birth) {
        super(id, dni, name, last_name, phone, address, date_birth);
        this.type_resp = type_resp;
    }

  

    public String getType_resp() {
        return type_resp;
    }

    public void setType_resp(String type_resp) {
        this.type_resp = type_resp;
    }

   //Convierte ResponsibleId a String
    @Override
    public String toString() {
        return "Responsible ID: " + super.getId();
    }
}
