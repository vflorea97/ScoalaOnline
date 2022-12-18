package ro.mycode.view;

import ro.mycode.Controller.ControllerBook;
import ro.mycode.Controller.ControllerCurs;
import ro.mycode.Controller.ControllerProfesor;
import ro.mycode.models.Book;
import ro.mycode.models.Curs;
import ro.mycode.models.Profesor;
import ro.mycode.models.Student;

import java.util.Scanner;

public class ViewProfesor {

    private ControllerProfesor controllerProfesor;
    private ControllerCurs controllerCurs;
    private ControllerBook controllerBook;
    private Scanner scanner;
    private Profesor profesor;

    public ViewProfesor (){
        controllerProfesor = new ControllerProfesor();
        controllerCurs = new ControllerCurs();
        controllerBook = new ControllerBook();
        scanner = new Scanner(System.in);
    }
    public ViewProfesor (Profesor profesor){
        controllerProfesor = new ControllerProfesor();
        controllerCurs = new ControllerCurs();
        controllerBook = new ControllerBook();
        scanner = new Scanner(System.in);
        this.profesor = profesor;
    }
    public void meniu(){
        System.out.println("Bine ai venit " + profesor.getPrenume() + "!");
        System.out.println("Apasa 1 pentru a afisa profesorii");
        System.out.println("Apasa 2 pentru a afisa cursurile");
        System.out.println("Apasa 3 pentru a adauga un curs");
        System.out.println("Apasa 4 pentru a updata un curs");
        System.out.println("Apasa 5 pentru a sterge un curs");
        System.out.println("Apasa 6 pentru a reafisa meniul");
        System.out.println("Apasa 0 pentru a iesi din meniu");
    }
    public void meniuCurs (){
        System.out.println("Apasa 1 pentru a updata ID-ul: ");
        System.out.println("Apasa 2 pentru a updata numele cursului: ");
        System.out.println("Apasa 3 pentru a updata numele departamentului: ");
        System.out.println("Apasa 4 pentru a reafisa meniul curent");
        System.out.println("Apasa 0 pentru a reveni la meniul anterior");
    }
    public void startProfesor (){
        boolean run = true;
        meniu();
        while(run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    controllerProfesor.afisare();
                    break;
                case 2:
                    controllerCurs.afisare();
                    break;
                case 3:
                    addCurs();
                    break;
                case 4:
                    upDateCurs();
                    break;
                case 5:
                    removeCurs();
                    break;
                case 0:
                    run = false;
                    ViewLogin viewLogin = new ViewLogin();
                    viewLogin.meniu();
                    break;
                default:
                    meniu();
                    break;
            }
        }
    }
    public void addCurs (){
        System.out.println("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nume curs: ");
        String nume= scanner.nextLine();
        System.out.println("Nume departament: ");
        String numeDep = scanner.nextLine();
        Curs curs = new Curs(id,nume,numeDep);
        controllerCurs.addCurs(curs);
        controllerCurs.save();
        System.out.println("Ai adaugat cu succes un curs!");
        meniu();

    }
    public void removeCurs (){
        System.out.println("Introdu numele cursului pe care vrei sa il stergi: ");
        String nume = scanner.nextLine();
        controllerCurs.removeCurs(nume);
        controllerCurs.save();
        System.out.println("Ai sters cu succes cursul!" + "\n");
        meniu();
    }
    public void upDateCurs (){
        Curs curs = new Curs();
        System.out.println("Introdu numele cursului: ");
        boolean back = true;
        while (back){
            String nume = scanner.nextLine();
            boolean mod = controllerCurs.verificareNume(nume);
            controllerCurs.verificare(nume);
            if (mod){
                meniuCurs();
                boolean run = true;
                while (run){
                    int buton = Integer.parseInt(scanner.nextLine());
                    switch (buton){
                        case 1:
                            System.out.println("Introdu nou ID: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            curs.setId(id);
                            System.out.println("Ai updata cu succesc acesta proprietate!" + "\n");
                            meniuCurs();
                            break;
                        case 2:
                            System.out.println("Introdu nou nume: ");
                            String numeCurs = scanner.nextLine();
                            curs.setName(numeCurs);
                            System.out.println("Ai updata cu succesc acesta proprietate!" + " \n");
                            meniuCurs();
                            break;
                        case 3:
                            System.out.println("Introdu noul departament: ");
                            String numeDep = scanner.nextLine();
                            curs.setDepartment(numeDep);
                            System.out.println("Ai updata cu succesc acesta proprietate!" + "\n");
                            meniuCurs();
                            break;
                        case 0:
                            back = false;
                            run = false;
                            meniu();
                            break;
                        default:
                            meniuCurs();
                            break;
                    }
                }
                controllerCurs.upDate(nume,curs);
                controllerCurs.save();
            }
        }
    }
}
