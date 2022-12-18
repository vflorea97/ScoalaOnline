package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Curs;
import ro.mycode.models.Enrolment;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerEnrolmentTest {

    @Test
    public void addEnrolment() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.addEnrolment(enrolment);

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void pozitie() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.pozitie(enrolment.getId());

        assertEquals(0,controllerEnrolment.pozitie(enrolment.getId()));
    }

    @Test
    public void removeEnrolment() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.removeEnrolment(enrolment.getId());

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) == null);
    }

    @Test
    public void upDate() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.upDate(enrolment.getId(),enrolment);

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void verificareEnrolment() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.verificareEnrolment(enrolment.getId());

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void verificare() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.verificare(enrolment.getId());

        assertEquals(true,controllerEnrolment.getEnrolemntById(enrolment.getId()) != null);
    }

    @Test
    public void findEnrolmentsByUserId() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.findEnrolmentsByUserId(enrolment.getId());

        assertEquals(enrolment.descriere(),controllerEnrolment.getEnrolemntById(enrolment.getId()).descriere());
    }

    @Test
    public void idCurs() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment();
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.idCurs(enrolment.getStudentId());

        assertEquals(enrolment.getCursId(),controllerEnrolment.idCurs(enrolment.getStudentId()));


    }

    @Test
    public void totiInscrisii() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(401,201,102);
        Enrolment enrolment1 = new Enrolment(402,202,102);
        Enrolment enrolment2 = new Enrolment(403,203,102);

        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.addEnrolment(enrolment2);

        ArrayList<Integer> cursId = new ArrayList<>();

        cursId.add(102);

        assertEquals(3,controllerEnrolment.totiInscrisii(enrolment.getCursId()).size());
    }

    @Test
    public void contorStudenti() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("new");
        Enrolment enrolment = new Enrolment(401,201,102);

        controllerEnrolment.addEnrolment(enrolment);

        int contor = controllerEnrolment.contorStudenti(enrolment.getCursId());

        assertEquals(1,controllerEnrolment.contorStudenti(enrolment.getCursId()));
    }

    @Test
    public void contor() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("poc");
        Enrolment enrolment = new Enrolment(401,201,102);
        Enrolment enrolment1 = new Enrolment(402,202,103);
        Enrolment enrolment2 = new Enrolment(403,203,102);
        Enrolment enrolment3 = new Enrolment(404,204,105);
        Enrolment enrolment4 = new Enrolment(405,205,106);
        Enrolment enrolment5 = new Enrolment(406,206,102);
        Enrolment enrolment6 = new Enrolment(407,207,102);
        Enrolment enrolment7 = new Enrolment(408,208,109);
        Enrolment enrolment8 = new Enrolment(409,209,102);
        Enrolment enrolment9 = new Enrolment(410,210,111);

        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.addEnrolment(enrolment2);
        controllerEnrolment.addEnrolment(enrolment3);
        controllerEnrolment.addEnrolment(enrolment4);
        controllerEnrolment.addEnrolment(enrolment5);
        controllerEnrolment.addEnrolment(enrolment6);
        controllerEnrolment.addEnrolment(enrolment7);
        controllerEnrolment.addEnrolment(enrolment8);
        controllerEnrolment.addEnrolment(enrolment9);

        ArrayList<Integer> courseIds= new ArrayList<>();

        courseIds.add(102);
        courseIds.add(109);

        assertEquals(5,controllerEnrolment.contor(courseIds)[0]);

    }

    @Test
    public void ordineDescrescatoare() {
        ControllerEnrolment controllerEnrolment = new ControllerEnrolment("poc");
        Enrolment enrolment = new Enrolment(401, 201,103 );
        Enrolment enrolment1 = new Enrolment(402, 202, 103);
        Enrolment enrolment2 = new Enrolment(403, 203, 103);
        Enrolment enrolment3 = new Enrolment(404, 204, 102);
        Enrolment enrolment4 = new Enrolment(405,205,102);
        Enrolment enrolment5 = new Enrolment(406,206,103);

        controllerEnrolment.addEnrolment(enrolment);
        controllerEnrolment.addEnrolment(enrolment1);
        controllerEnrolment.addEnrolment(enrolment2);
        controllerEnrolment.addEnrolment(enrolment3);
        controllerEnrolment.addEnrolment(enrolment4);
        controllerEnrolment.addEnrolment(enrolment5);

        ArrayList<Integer> cursId = new ArrayList<>();

        cursId.add(101);
        cursId.add(102);
        cursId.add(103);

        int [] contro = controllerEnrolment.contor(cursId);

        controllerEnrolment.ordineDescrescatoare(cursId,contro);

        assertEquals(4,controllerEnrolment.contor(cursId)[0]);
        assertEquals(2,controllerEnrolment.contor(cursId)[1]);
        assertEquals(0,controllerEnrolment.contor(cursId)[2]);


    }
}