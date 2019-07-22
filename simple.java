/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md1;


import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author nz
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
         //Doctor 1
         int a = 1;
        int[] ident1 = {a++};//identicator 
        int idCounter = 1; //Doctor id counter
        int doctorCounter = 1; //Doctor counter
        ArrayList <Doctor> doctor = new ArrayList<>();
        
        
        Doctor d1 = new Doctor((short) 1 , Speciality.Heart, "Martins" , "Biscuit" , ident1, Gender.Male ,Nationality.Latvian );
        d1.setDoctorID(idCounter++); //Set doctor id counter
        d1.setDoctorCounter(doctorCounter++); //set doctor counter
        doctor.add(d1);
        
        
        //Doctor 2
        ident1[0] = ++a;
        
        Doctor d2 = new Doctor((short) 2, Speciality.kid, "Marks" , "Kreilis" , ident1, Gender.Male, Nationality.Latvian);
        d2.setDoctorID(idCounter++); //Set doctor id counter
        d2.setDoctorCounter(doctorCounter++); //set doctor counter
        doctor.add(d2);
         System.out.println("Doctors \n" + doctor + "\n");
         
         //Patien 1
         int PatientiD = 1; //Person id counter
         int PatientCounter = 1; //Person counter
         ArrayList<Patient> patient = new ArrayList<>();
         ident1[0]=a++;
         Patient p1 = new Patient(false, "Ed" , "Frick" ,ident1, Gender.Male , Nationality.Estonian);
         p1.setPatientId(PatientiD++);
         p1.setPatientCounter(PatientCounter++);
         patient.add(p1);
        
         
         //Patien 2
         ident1[0]=a++;
         Patient p2 = new Patient(false, "Jasmine" , "Uche" ,ident1, Gender.Famele , Nationality.Latvian);
         p2.setPatientId(PatientiD++);
         p2.setPatientCounter(PatientCounter++);
         patient.add(p2);
         System.out.println("Patiens \n" +patient + "\n");
       
        Scanner delete = new Scanner(System.in);
        System.out.println("\nDelete Doctor and Patient by id (ID = 2)");
        //int docnr = delete.nextInt();
      
         //Delete Doctor by ID
       for(int i = 0 ; i < doctor.size(); i++){
           
           if( doctor.get(i).getDoctorID() == 2){
               doctor.remove(i);
           }
       }
          

        //int patnr = delete.nextInt();
        
        //Delete Patient by ID
        for(int i = 0 ; i < patient.size(); i++){
           
           if( patient.get(i).getPatientId() == 2){
               patient.remove(i);
           }
       }
       System.out.println("Doctors \n" + doctor + "\nPatient \n" + patient + "\n");
       
        //Deleting doctor and patient by object
       System.out.println("Deleting Doctor and Patient by object (doctor d1 , patient p1)");
       deleteDoctorByObject(d1,doctor);
       deletePatientByObject(p1,patient);
       System.out.println("Doctors \n" +doctor + "\nPatients \n" + patient + "\n");
        
        
        
        
        
        
        
        
        ///////////////////////////////////////Appointment///////////////////////
       
        //Creating new doctor
        ident1[0] = a++;
        Doctor d3 = new Doctor((short) 3 , Speciality.Heart, "Janis" , "Brizs" , ident1, Gender.Male ,Nationality.Latvian );
        d3.setDoctorID(idCounter++); //Set doctor id counter
        d3.setDoctorCounter(doctorCounter++); //set doctor counter
       
        doctor.add(d3);
        
        ident1[0] = a++;
        Doctor d4 = new Doctor((short) 4 , Speciality.kid, "Jana" , "Auza" , ident1, Gender.Famele ,Nationality.Latvian );
        d4.setDoctorID(idCounter++); //Set doctor id counter
        d4.setDoctorCounter(doctorCounter++); //set doctor counter
       
        doctor.add(d4);
        //Creating new patient
        
         ident1[0]= a++;
         Patient p3 = new Patient(false, "Kristine" , "Mija" ,ident1, Gender.Famele , Nationality.Latvian);
         p3.setPatientId(PatientiD++);
         p3.setPatientCounter(PatientCounter++);
         
         patient.add(p3);
         
          ident1[0]= a++;
         
         Patient p4= new Patient(false, "Emils" , "Eide" ,ident1, Gender.Male , Nationality.Latvian);
         p4.setPatientId(PatientiD++);
         p4.setPatientCounter(PatientCounter++);
         
         patient.add(p4);
         //creating new appointment
         int Appcounter = 1;
         int Appid = 1; 
         //Creating Appointment arraylist
         ArrayList<Appointment> appointment = new ArrayList<>();
       
        
         
        String setdate = "2019-03-08 12:00";
        Date date = setDate(setdate);
        
            
        
       
        Appointment ap1 = new Appointment(date, "Heart problems" , p3, doctor);
        ap1.setAppID(Appid++);
        ap1.setAppCounter(Appcounter++);
 
        appointment.add(ap1);
        
        
        setdate = "2019-03-12 13:45"; 
        date = setDate(setdate);
        Appointment ap2 = new Appointment(date, "Flue" , p4, doctor);
        ap2.setAppID(Appid++);
        ap2.setAppCounter(Appcounter++);
        appointment.add(ap2);
        
        
        
        
        
        
        //-----------------------------Printing---------------------------- 
        //Printing Doctors;
        System.out.println("Printing Doctors... \n \n" + d3 + "\n \n" + d4 +"\n");
        
        //Printing Patients;
        
        System.out.println("Printing Patients... \n\n" + p3 + "\n\n" + p4 + "\n");
       
       //Printing appointments;
       System.out.println("Printing Appointment... \n");
        for(int i = 0 ;  i < appointment.size(); i++){
            System.out.println( appointment.get(i) + "\n");
            appointment.get(i).removeExistingDoctorFromAppointment(d3, doctor);
        }   
        
        
        
        
        //-----------------------------------------Test part--------------------
        
        ArrayList<Doctor> TestDoctor = new ArrayList<>();
        ArrayList<Patient> TestPatient = new ArrayList<>();
        ArrayList<Appointment> TestAppointment = new ArrayList<>();
        
        ident1[0] = a++;
        Doctor d5 = new Doctor((short) 5 , Speciality.Heart, "Andris" , "Jaunais" , ident1, Gender.Male ,Nationality.Latvian );
        d5.setDoctorID(idCounter++); //Set doctor id counter
        d5.setDoctorCounter(doctorCounter++); //set doctor counter
        
        ident1[0] = a++;
        Doctor d6 = new Doctor((short) 6 , Speciality.kid, "Janis" , "Vecais" , ident1, Gender.Male ,Nationality.Latvian );
        d6.setDoctorID(idCounter++); //Set doctor id counter
        d6.setDoctorCounter(doctorCounter++); //set doctor counter
        
        ident1[0] = a++;
        Doctor d7 = new Doctor((short) 7 , Speciality.kid, "Marta" , "Gellere" , ident1, Gender.Famele ,Nationality.Latvian );
        d7.setDoctorID(idCounter++); //Set doctor id counter
        d7.setDoctorCounter(doctorCounter++); //set doctor counter
        
        TestDoctor.add(d5);
        TestDoctor.add(d6);
        TestDoctor.add(d7);
        
         ident1[0]= a++;
         Patient p5 = new Patient(false, "Anda" , "Krauze" ,ident1, Gender.Famele , Nationality.Latvian);
         p5.setPatientId(PatientiD++);
         p5.setPatientCounter(PatientCounter++);
         
         ident1[0]= a++;
         Patient p6 = new Patient(false, "Andris" , "Millers" ,ident1, Gender.Male , Nationality.Latvian);
         p6.setPatientId(PatientiD++);
         p6.setPatientCounter(PatientCounter++);
         
         ident1[0]= a++;
         Patient p7 = new Patient(false, "Guntars" , "Jaunzems" ,ident1, Gender.Male , Nationality.Latvian);
         p7.setPatientId(PatientiD++);
         p7.setPatientCounter(PatientCounter++);
        
         TestPatient.add(p5);
         TestPatient.add(p6);
         TestPatient.add(p7);
         
         //ArrayList for appointment Docotor
         ArrayList<Doctor> KidDoctor = new ArrayList<>();
         ArrayList<Doctor> HeartDoctor = new ArrayList<>();
         KidDoctor.add(d6);
         KidDoctor.add(d7);
         HeartDoctor.add(d5);
         
        
         
         int [] docID = new int[5];
         docID[0]= d5.getDoctorID();
        setdate = "2019-03-15 12:00"; 
        date = setDate(setdate);
        Appointment ap3 = new Appointment(date, "Flue" , p5, AppointmentDoctor(KidDoctor,1 ,docID));
        ap3.setAppID(Appid++);
        ap3.setAppCounter(Appcounter++);
        
        TestAppointment.add(VerificateDoctor( TestDoctor, TestAppointment, ap3));
        
        
        docID[0] = d5.getDoctorID();
        setdate = "2019-03-15 12:00"; 
        date = setDate(setdate);;
        Appointment ap4 = new Appointment(date, "Heart Problems" , p6,AppointmentDoctor(HeartDoctor,1,docID));
        ap4.setAppID(Appid++);
        ap4.setAppCounter(Appcounter++);
        TestAppointment.add(VerificateDoctor( TestDoctor, TestAppointment, ap4));
        
       docID[0] = d6.getDoctorID();
       docID[1] = d7.getDoctorID();
        setdate = "2019-03-18 13:20"; 
        date = setDate(setdate);
        Appointment ap5 = new Appointment(date, "Flue" , p7,  AppointmentDoctor(KidDoctor,2, docID));
        ap5.setAppID(Appid++);
        ap5.setAppCounter(Appcounter++);
        TestAppointment.add(VerificateDoctor( TestDoctor, TestAppointment, ap5));
      
      
        
        
        //System.out.println("\n" + ap5);
        System.out.println(TestAppointment);
        
        
    }
    
    
    //Create necesarry enums 
    enum Gender{
        Male,
        Famele,
        Unset
    }
    enum Nationality{
        Latvian,
        Estonian,
        Unset
    }
    enum Speciality{
        Heart,
        kid
    }
    
    //Function that deletes Doctor by object
    public static ArrayList<Doctor> deleteDoctorByObject(Doctor doctor, ArrayList<Doctor> doc){
        for(int i = 0 ; i < doc.size(); i++){
            if(doc.get(i) == doctor){
                doc.remove(i);
            }
        }
        return doc;
    }
    //Function that deletes Patient by object
     public static ArrayList<Patient> deletePatientByObject(Patient patient, ArrayList<Patient> pat){
        for(int i = 0 ; i < pat.size(); i++){
            if(pat.get(i) == patient){
                pat.remove(i);
            }
        }
        return pat;
    }
     
     //Function that deletes Appointment by object
     public static ArrayList<Appointment> deleteAppointment(Appointment appointment, ArrayList<Appointment> app){
         for(int i = 0 ; i < app.size(); i ++){
             if( app.get(i) == appointment){
                 app.remove(i);
             }
     }return app;
    }
     
     //Function for Appointment Doctor choice.
     public static ArrayList<Doctor> AppointmentDoctor(ArrayList<Doctor> doctor,int total, int[] id){
         //New arrayList for chosen doctor
         ArrayList<Doctor> NewDoctor = new ArrayList<>();
         
         for(int j = 0 ; j < total ; j++){
            
            for(int i = 0; i < doctor.size(); i++){
                if(doctor.get(i).getDoctorID() == id[j]){
                    NewDoctor.add(doctor.get(i));
                }
            }
         }return NewDoctor;
     }
     
     
     //Parse String to date
     public static Date setDate(String strDate) throws ParseException{
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
         
        
        Date date = formatter.parse(strDate);  
        String formattedDate = formatter.format(date);
         return date;
     }
     //Verificates the doctor if he can take the appointment
     public static Appointment VerificateDoctor( ArrayList<Doctor> doctors , ArrayList<Appointment> appointment, Appointment app){
         
         Appointment newApp = null;
         for (int j = 0 ; j < appointment.size() ; j++){
 
         //Checks if there is appointment in that date and time 
         if(appointment.get(j).getDate() == app.getDate()){
             if(app.getDoctor().get(j) == appointment.get(j).getDoctor().get(j) ){
                 
                 System.out.println("Appoontment was not created..");
                 }
             else{
                newApp = app;
                } 
                 
             }
         }
         return newApp;
    }
         
}

