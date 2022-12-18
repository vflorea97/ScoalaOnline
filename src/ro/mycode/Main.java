package ro.mycode;

import ro.mycode.Controller.ControllerStudent;
import ro.mycode.view.ViewLogin;
import ro.mycode.view.ViewProfesor;
import ro.mycode.view.ViewStudent;

public class Main {

    public static void main(String[] args) {

//        ControllerCurs controllerCurs = new ControllerCurs();
//        controllerCurs.afisare();
//
//        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
//        ArrayList<Enrolment> enrol=controllerEnrolment.findEnrolmentsByUserId(201);
//
//        System.out.println(enrol);

//        ControllerBook controllerBook = new ControllerBook();
//        controllerBook.afisare();

//          ControllerStudent controllerStudent = new ControllerStudent();
//          controllerStudent.afisare();

//        ViewStudent viewStudent = new ViewStudent();
//        viewStudent.startStudent();
//        ControllerCurs controllerCurs = new ControllerCurs();
//        ArrayList<Integer> id = controllerCurs.idCurs();
//        System.out.println(id);

//        ControllerStudent controllerStudent = new ControllerStudent();
//        controllerStudent.afisare();
//        controllerStudent.load();
//        controllerStudent.save();
//
        ViewLogin viewLogin = new ViewLogin();
        viewLogin.play();
//        ViewProfesor viewProfesor = new ViewProfesor();
//        viewProfesor.startProfesor();

    }
}
