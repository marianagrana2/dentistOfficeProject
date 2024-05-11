
package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistence.ControllerPersistence;


public class Controller {
    
    ControllerPersistence controllerPersis = new ControllerPersistence();
    
    public void createUser(String user_name,String password, String role){
        
        User usu = new User();
        usu.setUser_name(user_name);
        usu.setPassword(password);
        usu.setRole(role);
        controllerPersis.createUser(usu);
    }

    public List<User> getUsers() {
       return controllerPersis.getUsers();
    }

    public void deleteUser(int id) {
        controllerPersis.deleteUser(id);
    }

    public User bringUser(int id) {
       return controllerPersis.bringUser(id);
    }

    public void editUser(User usu) {
        controllerPersis.editUser(usu);
    }

    public boolean checkLogin(String user, String password) {
        boolean entry = false;
        
        List<User>listUsers = new ArrayList<User>();
        listUsers = controllerPersis.getUsers();
        
        for(User usu:listUsers){
            if(usu.getUser_name().equals(user)){
                if(usu.getPassword().equals(password)){
                    entry = true;
                }
                else{
                entry = false;
                }
            } 
        } 
        return entry;
    }  

    public void createSchedule(String startSchedule, String finishSchedule) {
        Schedule schedu = new Schedule();
        schedu.setStart_schedule(startSchedule);
        schedu.setFinish_schedule(finishSchedule);
        
        controllerPersis.createSchedule(schedu);
    }

    public List<Schedule> getSchedules() {
        return controllerPersis.getSchedules();
    }

    public void deleteSchedule(int id) {
        controllerPersis.deleteSchedule(id);
    }

    public Schedule bringSchedule(int id) {
        return controllerPersis.bringSchedule(id);
    }

    public void editSchedule(Schedule schedu) {
       controllerPersis.editSchedule(schedu);
    }

    public List<Responsible> getResponsibles() {
        return controllerPersis.getRespondibles();
    }

    public void createResponsible(String firstName, String dni, String phone, String lastName, String responsibleType, Date date_birth, String address) {
        Responsible respo = new Responsible();
        respo.setType_resp(responsibleType);
        respo.setDni(dni);
        respo.setName(firstName);
        respo.setLast_name(lastName);
        respo.setAddress(address);
        respo.setPhone(phone);
        respo.setDate_birth(date_birth);
   
        controllerPersis.createResponsible(respo);
    }

    public Responsible bringResponsible(int id) {
        return controllerPersis.bringResponsible(id);
    }

    public void editResponsible(Responsible respo) {
        controllerPersis.editResponsible(respo);
    }

    public void deleteResponsible(int id) {
       controllerPersis.deleteResponsible(id);
    }

    public void createPatient(String firstName, String dni, String phone, String lastName, String bloodType, Date date_birth, String address, String medicalInsurance, String responsibleId) {
        Patient patie = new Patient();
        patie.setDni(dni);
        patie.setPhone(phone);
        patie.setName(firstName);
        patie.setLast_name(lastName);
        patie.setAddress(address);
        patie.setBlood_type(bloodType);
        patie.setDate_birth(date_birth);       
        patie.setHave_medical_insurance("yes".equalsIgnoreCase(medicalInsurance));
        
        /*-----------------  SET Responsible ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (responsibleId!= null &&!responsibleId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Responsible aResponsible = new Responsible();
        //El Id se pasa de String a Integer
        aResponsible.setId(Integer.parseInt(responsibleId));
        //Se establece el objeto aResponsible
        patie.setaResponsible(aResponsible);
        }
        /*---------------- END SET Responsible ID---------------------*/
        
        controllerPersis.createPatient(patie);
       
        
    }
    

    public List<Patient> getPatients() {
       return controllerPersis.getPatients();
    }

    public void deletePatient(int id) {
        controllerPersis.deletePatient(id);
    }

    public Patient bringPatient(int id) {
        return controllerPersis.bringPatient(id);
    }

    public void editPatient(Patient patie) {
        controllerPersis.editPatient(patie);
    }

    public List<Secretary> getSecretaries() {
        return controllerPersis.getSecretaries();
    }

    public void createSecretary(String firstName, String dni, String phone, String lastName, String sector, Date date_birth, String address, String aUserId) {
       Secretary secre = new Secretary();
        secre.setDni(dni);
        secre.setPhone(phone);
        secre.setName(firstName);
        secre.setLast_name(lastName);
        secre.setAddress(address);
        secre.setSector(sector);
        secre.setDate_birth(date_birth);       
       
        
        /*-----------------  SET Responsible ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (aUserId!= null &&!aUserId.isEmpty()) {
        //Se crea un nuevo Responsible 
        User aUser = new User();
        //El Id se pasa de String a Integer
        aUser.setId_user(Integer.parseInt(aUserId));
        //Se establece el objeto aResponsible
        secre.setaUser(aUser);
        }
        /*---------------- END SET Responsible ID---------------------*/
        
        controllerPersis.createSecretary(secre);
       
    }

    public void deleteSecretary(int id) {
       controllerPersis.deleteSecretary(id);
    }

    public Secretary bringSecretary(int id) {
        return controllerPersis.bringSecretary(id);
    }

    public void editSecretary(Secretary secre) {
        controllerPersis.editSecretary(secre);
    }

    public List<Dentist> getDentist() {
        return controllerPersis.getDentist();
    }

    public void createDentist(String firstName, String dni, String phone, String lastName, String speciality, Date date_birth, String address, String aScheduleId, String aUserId) {
        Dentist dent = new Dentist();
        dent.setDni(dni);
        dent.setPhone(phone);
        dent.setName(firstName);
        dent.setAddress(address);
        dent.setLast_name(lastName);
        dent.setSpecialty(speciality);
        dent.setDate_birth(date_birth);       
       
        
        /*-----------------  SET User ID ----------------------*/
        //Añadir User ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (aUserId!= null &&!aUserId.isEmpty()) {
        //Se crea un nuevo Responsible 
        User aUser = new User();
        //El Id se pasa de String a Integer
        aUser.setId_user(Integer.parseInt(aUserId));
        //Se establece el objeto aResponsible
        dent.setaUser(aUser);
        }
        /*---------------- END SET UserID---------------------*/
        
         /*-----------------  SET Schedule ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if(aScheduleId!= null &&!aScheduleId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Schedule aSchedule = new Schedule();
        //El Id se pasa de String a Integer
        aSchedule.setId_schedule(Integer.parseInt(aScheduleId));
        //Se establece el objeto aResponsible
        dent.setaSchedule(aSchedule);
        }
        /*---------------- END SET Schedule ID---------------------*/
        controllerPersis.createDentist(dent);
       
    }

    public Dentist bringDentist(int id) {
       return controllerPersis.bringDentist(id);
    }

    public void editDentist(Dentist dent) {
       controllerPersis.editDentist(dent);
    }

    public void deleteDentist(int id) {
      controllerPersis.deleteDentist(id);
    }

    public void createShift(Date dateShift, String timeShift, String treatment, String dentiId, String patieId) {
        
        Shift shift = new Shift();
        shift.setDate_shift(dateShift);
        shift.setTime_shift(timeShift);
        shift.setTreatment(treatment);
        
        
        /*-----------------  SET Dentist ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (dentiId!= null &&!dentiId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Dentist denti = new Dentist();
        //El Id se pasa de String a Integer
        denti.setId(Integer.parseInt(dentiId));
        //Se establece el objeto aResponsible
        shift.setDent(denti);
        }
        /*---------------- END SET Dentist ID---------------------*/
        
         /*-----------------  SET Patient ID ----------------------*/
        //Añadir Patient ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if(patieId!= null &&!patieId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Patient patie = new Patient();
        //El Id se pasa de String a Integer
        patie.setId(Integer.parseInt(patieId));
        //Se establece el objeto aResponsible
        shift.setPatien(patie);
        }
        /*---------------- END SET Patient ID---------------------*/
        
        controllerPersis.createShift(shift);
    }

    public List<Shift> getShift() {
        return controllerPersis.getShift();
    }

    public void deleteShift(int id) {
        controllerPersis.deleteShift(id);
    }

    public Shift bringShift(int id) {
        return controllerPersis.bringShift(id);
    }

    public void editShift(Shift shift) {
        controllerPersis.editShift(shift);
    }

   
}
