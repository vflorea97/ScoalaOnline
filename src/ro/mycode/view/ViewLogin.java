package ro.mycode.view;

import ro.mycode.Controller.ControllerProfesor;
import ro.mycode.Controller.ControllerStudent;
import ro.mycode.models.Profesor;
import ro.mycode.models.Student;

import java.util.Scanner;

public class ViewLogin {

    private ControllerStudent controllerStudent;
    private ControllerProfesor controllerProfesor;
    private Scanner scanner;

    public ViewLogin (){
        controllerStudent = new ControllerStudent();
        controllerProfesor = new ControllerProfesor();
        scanner = new Scanner(System.in);
    }

    public void meniu (){
        System.out.println("Apasati tasta 1 pentru login");
        System.out.println("Apasati tasta 2 pentru a te inregistra ca student");
        System.out.println("Apasati tasta 3 pentru a te inregistra ca profesor");

    }

    public void play (){
        boolean run = true;
        meniu();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    login();
                    break;
                case 2:
                    inregistrareStudent();
                    break;
                case 3:
                    inregistrareProfesor();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    meniu();
                    break;
            }
        }
    }
    public void login (){
        System.out.println("Introduceti username-ul si parola");
        boolean run = true;
        while (run) {
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Parola: ");
            String parola = scanner.nextLine();
            Student student = controllerStudent.student(username, parola);
            Profesor profesor = controllerProfesor.profesor(username, parola);

            if (student != null) {
                ViewStudent viewStude = new ViewStudent(student);
                viewStude.startStudent();
                run = false;
            } else if (profesor != null) {
                ViewProfesor viewProfesor = new ViewProfesor(profesor);
                viewProfesor.startProfesor();
                run= false;
            } else {
                System.out.println("Credentiale incorecte" + "\n" + "Reintrodu username-ul si parola");
            }
        }
    }
    public void inregistrareStudent (){
        int id = controllerStudent.generareId();
        System.out.println("Introdu prenume:");
        String prenume = scanner.nextLine();
        System.out.println("Introdu nume:");
        String nume = scanner.nextLine();
        System.out.println("Introdu adresa de mail:");
        String adresaMail = scanner.nextLine();
        while (controllerStudent.isEmail(adresaMail)){
            System.out.println("Adresa de mail introdusa este deja asociata altui student. Introdu alta adresa:");
            adresaMail =scanner.nextLine();
        }
        System.out.println("Introdu varsta: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Introdu o parola: ");
        String parola = scanner.nextLine();
        Student student = new Student(id,prenume,nume,adresaMail,age,parola);
        controllerStudent.addStudent(student);
        controllerStudent.save();

        ViewStudent viewStudent = new ViewStudent(student);
        viewStudent.startStudent();
    }
    public void inregistrareProfesor (){
        int id = controllerProfesor.generareId();
        System.out.println("Introdu prenume:");
        String prenume = scanner.nextLine();
        System.out.println("Introdu nume:");
        String nume = scanner.nextLine();
        System.out.println("Introdu adresa de mail:");
        String adresaMail = scanner.nextLine();
        while (controllerStudent.isEmail(adresaMail)){
            System.out.println("Adresa de mail introdusa este deja asociata altui profesor. Introdu alta adresa:");
            adresaMail =scanner.nextLine();
        }
        System.out.println("Introdu usernam-ul: ");
        String username = scanner.nextLine() + controllerProfesor.generareId();
        System.out.println("Introdu o parola: ");
        String parola = scanner.nextLine();
        Profesor profesor = new Profesor(id,prenume,nume,adresaMail,username,parola);
        controllerProfesor.addProfesor(profesor);
        controllerProfesor.save();

        ViewProfesor viewProfesor = new ViewProfesor(profesor);
        viewProfesor.startProfesor();

    }
}
