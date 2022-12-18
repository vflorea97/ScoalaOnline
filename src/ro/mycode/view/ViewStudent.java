package ro.mycode.view;

import ro.mycode.Controller.ControllerBook;
import ro.mycode.Controller.ControllerCurs;
import ro.mycode.Controller.ControllerEnrolment;
import ro.mycode.Controller.ControllerStudent;
import ro.mycode.models.Book;
import ro.mycode.models.Curs;
import ro.mycode.models.Enrolment;
import ro.mycode.models.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewStudent {

    private ControllerCurs controllerCurs;
    private ControllerStudent controllerStudent;
    private ControllerBook controllerBook;
    private ControllerEnrolment controllerEnrolment;
    private Scanner scanner;
    private Student student;

    public ViewStudent () {
        controllerCurs = new ControllerCurs();
        controllerStudent = new ControllerStudent();
        controllerBook= new ControllerBook();
        controllerEnrolment = new ControllerEnrolment();
        student=new Student(202,"valentin","ceva","@gmail.com",23,"picpoc3");
        scanner = new Scanner(System.in);
    }

    public ViewStudent (Student student) {
        controllerCurs = new ControllerCurs();
        controllerStudent = new ControllerStudent();
        controllerBook= new ControllerBook();
        controllerEnrolment = new ControllerEnrolment();
        scanner = new Scanner(System.in);

        this.student=student;
    }

    public void meniuStudent (){
        System.out.println("Bine a-ti venit "+student.getFirstName()+" !");
        System.out.println("Apasa 1 pentru a afisa toate cartile");
        System.out.println("Apasa 2 pentru a afisa toate cursurile");
        System.out.println("Apasa 3 pentru a afisa toti studentii in ordine alfabetica");
        System.out.println("Apasa 4 pentru a afisa cine iti este coleg la curs");
        System.out.println("Apasa 5 pentru a imprumuta o carte");
        System.out.println("Apasa 6 pentru a afisa cursurile la care sunteti inscris");
        System.out.println("Apasa 7 pentru a afisa cartile studentului");
        System.out.println("Apasa 8 pentru a te inscrie la un curs");
        System.out.println("Apasa 9 pentru a afisa cursurile in functie de departament");
        System.out.println("Apasa 10 pentru a afisa cursurile in ordinea popularitatii");
        System.out.println("Apasa 11 pentru a reafisa meniul.");
        System.out.println("Apasa 0 pentru a inchide aplicatia.");

    }

    public void startStudent (){
        boolean run = true;
        meniuStudent();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    controllerBook.afisare();
                    break;
                case 2:
                    controllerCurs.afisare();
                    break;
                case 3:
                    System.out.println("Ordinea alfabetica este: ");
                    controllerStudent.ordineAlfabetica();
                    controllerStudent.afisare();
                    break;
                case 4:
                    colegiCurs();
                    break;
                case 5:
                    imprumutCarte();
                    break;
                case 6:
                    showCourses();
                    break;
                case 7:
                    showBooks();
                    break;
                case 8:
                    inscriereCurs();
                    break;
                case 9:
                    cursuriDepartament();
                    break;
                case 10:
                    cursuriPopulare();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    meniuStudent();
                    break;
            }
        }
    }

    private void showBooks(){
        ArrayList<Book> books= controllerBook.fiindBooksByUserId(student.getId());
        for(Book b:books){

            System.out.println(b.descriere());
        }
    }
    private void showCourses (){
        System.out.println("Introdu ID-ul de student: ");
        int id = Integer.parseInt(scanner.nextLine());
        ArrayList<Enrolment> enrolments = controllerEnrolment.findEnrolmentsByUserId(id);

        for(Enrolment enrolment :enrolments){

            System.out.println(controllerCurs.findCourseById(enrolment.getCursId()).descriere());
        }
    }
    private void colegiCurs (){
        System.out.println("Introdu id-ul de student: ");
        int id = Integer.parseInt(scanner.nextLine());
        int idCurs = controllerEnrolment.idCurs(id);
        ArrayList<Enrolment> enrolments = controllerEnrolment.totiInscrisii(idCurs);
        for (int i = 0; i < enrolments.size(); i++){
            System.out.println(controllerStudent.acelasiCurs(enrolments.get(i).getStudentId()).descriere());
        }
    }
    public void imprumutCarte(){
        System.out.println("Indrodu id-ul de student: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean student = controllerStudent.verificareStudent(id);
        controllerStudent.verificare(id);
        System.out.println("Introdu numele cartii pe care vrei sa o imprumuti: ");
        while (student){
            String carte = scanner.nextLine();
            boolean run = controllerBook.verificareNume(carte);
            controllerBook.verificare(carte);
            if (run){
                controllerBook.cartiImprumutate(id,carte);
                controllerBook.save();
                student = false;
                startStudent();
            }

        }
    }
    public void inscriereCurs (){
        System.out.println("Introdu id-ul de student: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean student = controllerStudent.verificareStudent(id);
        controllerStudent.verificare(id);
        System.out.println("Acum introdu ID-ul inscrierii, Id-ul de student si ID-ul cursului");
        while(student){
            addEnrolment();
            student = false;
        }
    }
    public void cursuriDepartament (){
        System.out.println("Introdu numele departamentului:");
        String nume = scanner.nextLine();
        ArrayList<Curs> cursuriDep = controllerCurs.curs(nume);
        for (Curs c:cursuriDep){
            System.out.println(c.descriere());
        }
    }
    public void cursuriPopulare (){
        ArrayList<Integer> curs = controllerCurs.idCurs();
        int [] contor = controllerEnrolment.contor(curs);
        controllerEnrolment.ordineDescrescatoare(curs,contor);
        ArrayList<Curs> cursuriPopulare = controllerCurs.cursuriPopulare(curs);
        for (int i = 0; i < cursuriPopulare.size(); i++){
            System.out.println("Departament cu " + contor[i] + " studenti.");
            System.out.println(cursuriPopulare.get(i).descriere());

        }
    }

    public void addEnrolment (){
        System.out.println("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("StudentID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.println("CoursID: ");
        int cursId = Integer.parseInt(scanner.nextLine());
        Enrolment enrolment = new Enrolment(id,studentId,cursId);
        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.save();
    }
    public void removeEnrolment (){
        System.out.println("Intordu id-ul inscrierii pe care vrei sa o stergi: ");
        int id = Integer.parseInt(scanner.nextLine());
        controllerEnrolment.removeEnrolment(id);
        controllerEnrolment.save();
    }



}
