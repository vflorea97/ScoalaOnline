package ro.mycode.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getStudent() {
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        assertEquals(201,student.getId());
        assertEquals("Octavian",student.getFirstName());
        assertEquals("Miuta",student.getLastName());
        assertEquals("octa99@coco.ro",student.getEmail());
        assertEquals(22,student.getAge());
        assertEquals("meresipere",student.getParola());
    }

    @Test
    void setStudent() {
        Student student = new Student(201,"Octavian","Miuta","octa99@coco.ro",22,"meresipere");

        student.setId(200);
        student.setFirstName("Octavia");
        student.setLastName("Miut");
        student.setEmail("octa99@coco.r");
        student.setAge(20);
        student.setParola("mere");

        assertEquals(200,student.getId());
        assertEquals("Octavia",student.getFirstName());
        assertEquals("Miut",student.getLastName());
        assertEquals("octa99@coco.r",student.getEmail());
        assertEquals(20,student.getAge());
        assertEquals("mere",student.getParola());
    }
}