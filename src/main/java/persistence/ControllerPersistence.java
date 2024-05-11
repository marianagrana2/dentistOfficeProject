
package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Dentist;
import logic.Patient;
import logic.Responsible;
import logic.Schedule;
import logic.Secretary;
import logic.Shift;
import logic.User;
import persistence.exceptions.NonexistentEntityException;


public class ControllerPersistence {
    DentistJpaController dentistJpa = new DentistJpaController();
    PatientJpaController patientJpa = new PatientJpaController();
    PersonJpaController personJpa = new PersonJpaController();
    ResponsibleJpaController respoJpa = new ResponsibleJpaController();
    ScheduleJpaController scheduleJpa = new ScheduleJpaController();
    SecretaryJpaController secretaryJpa = new SecretaryJpaController();
    ShiftJpaController shiftJpa = new ShiftJpaController();
    UserJpaController userJpa = new UserJpaController();

    public void createUser(User usu) {
       userJpa.create(usu);
    }

    public List<User> getUsers() {
        return userJpa.findUserEntities();
    }

    public void deleteUser(int id) {
        try {
            userJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User bringUser(int id) {
       return userJpa.findUser(id);
    }

    public void editUser(User usu) {
        try {
            userJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createSchedule(Schedule schedu) {
        scheduleJpa.create(schedu);
    }

    public List<Schedule> getSchedules() {
        return scheduleJpa.findScheduleEntities();
    }

    public void deleteSchedule(int id) {
        try {
            scheduleJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Schedule bringSchedule(int id) {
        return scheduleJpa.findSchedule(id);
    }

    public void editSchedule(Schedule schedu) {
        try {
            scheduleJpa.edit(schedu);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Responsible> getRespondibles() {
        return respoJpa.findResponsibleEntities();
    }

    public void createResponsible(Responsible respo) {
        respoJpa.create(respo);
    }

    public Responsible bringResponsible(int id) {
       return respoJpa.findResponsible(id);
    }

    public void editResponsible(Responsible respo) {
        try {
            respoJpa.edit(respo);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public void deleteResponsible(int id) {
        try {
            respoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Patient> getPatients() {
         return patientJpa.findPatientEntities();
    }

    public void createPatient(Patient patie) {
        patientJpa.create(patie);
    }

    public void deletePatient(int id) {
        try {
            patientJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Patient bringPatient(int id) {
       return patientJpa.findPatient(id);
    }

    public void editPatient(Patient patie) {
        try {
            patientJpa.edit(patie);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Secretary> getSecretaries() {
        return secretaryJpa.findSecretaryEntities();
    }

    public void createSecretary(Secretary secre) {
       secretaryJpa.create(secre);
    }

    public void deleteSecretary(int id) {
        try {
            secretaryJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Secretary bringSecretary(int id) {
        return secretaryJpa.findSecretary(id);
    }

    public void editSecretary(Secretary secre) {
        try {
            secretaryJpa.edit(secre);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Dentist> getDentist() {
       return dentistJpa.findDentistEntities();
    }

    public void createDentist(Dentist dent) {
        dentistJpa.create(dent);
    }

    public Dentist bringDentist(int id) {
        return dentistJpa.findDentist(id);
    }

    public void editDentist(Dentist dent) {
        try {
            dentistJpa.edit(dent);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDentist(int id) {
        try {
            dentistJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Shift> getShift() {
        return shiftJpa.findShiftEntities();
    }

    public void deleteShift(int id) {
        try {
            shiftJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createShift(Shift shift) {
         shiftJpa.create(shift);
    }

    public Shift bringShift(int id) {
        return shiftJpa.findShift(id);
    }

    public void editShift(Shift shift) {
        try {
            shiftJpa.edit(shift);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
