package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Student;

import static org.junit.jupiter.api.Assertions.*;

class ControllerStudentTest {

    @Test
    public void addStudent() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.addStudent(student);

        assertEquals(true, controllerStudent.getStudentByEmail(student.getEmail()) != null);
    }

    @Test
    public void pozitie() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.pozitie(student.getId());

        assertEquals(0,controllerStudent.pozitie(student.getId()));
    }

    @Test
    public void removeStudent() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.removeStudent(student.getId());

        assertEquals(true,controllerStudent.getStudentById(student.getId()) == null);
    }

    @Test
    public void upDate() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.upDate(student.getId(),student);

        assertEquals(true,controllerStudent.getStudentById(student.getId()) != null);
    }

    @Test
    public void verificareStudent() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.verificareStudent(student.getId());

        assertEquals(true, controllerStudent.getStudentById(student.getId()) != null);
    }

    @Test
    public void verificare() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.verificareStudent(student.getId());

        assertEquals(true, controllerStudent.getStudentById(student.getId()) != null);
    }

    @Test
    public void acelasiCurs() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.acelasiCurs(student.getId());

        assertEquals(true,controllerStudent.acelasiCurs(student.getId()) != null);
    }

    @Test
    public void ordineAlfabetica() {
        ControllerStudent controllerStudent = new ControllerStudent("new");
        Student student = new Student(201,"octavian","miuta","octa99@coco.ro",22,"meresipere");
        Student student1 = new Student(202,"papa","papa","papa",27,"pocpoc");
        Student student2 = new Student(203,"for","for","for",25,"pic");
        Student student3 = new Student(204,"doru","doru","doru",18,"doru");
        Student student4 = new Student(205,"miha","miha","miha",20,"miha");

        controllerStudent.addStudent(student);
        controllerStudent.addStudent(student1);
        controllerStudent.addStudent(student2);
        controllerStudent.addStudent(student3);
        controllerStudent.addStudent(student4);

        controllerStudent.ordineAlfabetica();
        controllerStudent.afisare();

        assertEquals(0,controllerStudent.pozitie(204));
    }

    @Test
    public void student() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.student(student.getEmail(), student.getParola());

        assertEquals(true,controllerStudent.student(student.getEmail(), student.getParola()) != null);
    }

    @Test
    public void generareId() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(206,"coco","coco","coco.coco@coco.ro",23,"coco");

        controllerStudent.generareId();

        assertEquals(student.getId() + 1,controllerStudent.generareId());
    }

    @Test
    public void isEmail() {
        ControllerStudent controllerStudent = new ControllerStudent();
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        controllerStudent.isEmail(student.getEmail());

        assertEquals(true,controllerStudent.isEmail(student.getEmail()));

    }
}