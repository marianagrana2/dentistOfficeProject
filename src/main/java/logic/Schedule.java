
package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_schedule;
    private String start_schedule;
    private String finish_schedule;

    public Schedule() {
    }

    public Schedule(int id_schedule, String start_schedule, String finish_schedule) {
        this.id_schedule = id_schedule;
        this.start_schedule = start_schedule;
        this.finish_schedule = finish_schedule;
    }

    public int getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }

    public String getStart_schedule() {
        return start_schedule;
    }

    public void setStart_schedule(String start_schedule) {
        this.start_schedule = start_schedule;
    }

    public String getFinish_schedule() {
        return finish_schedule;
    }

    public void setFinish_schedule(String finish_schedule) {
        this.finish_schedule = finish_schedule;
    }
    
    @Override
    public String toString() {
        return "a Schedule ID: " + getId_schedule();
    }
}
