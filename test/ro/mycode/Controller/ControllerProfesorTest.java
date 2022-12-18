package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Profesor;

import static org.junit.jupiter.api.Assertions.*;

class ControllerProfesorTest {

    @Test
    public void addProfesor() {
        ControllerProfesor controllerProfesor = new ControllerProfesor();
        Profesor profesor = new Profesor(501,"Ionel","Pascu","pascu.ionel89@gmail.com","ionel501","ioniepure");

        controllerProfesor.addProfesor(profesor);

        assertEquals(true,controllerProfesor.getProfesorByUserId(profesor.getUserId()) != null);
    }

    @Test
    public void profesor() {
        ControllerProfesor controllerProfesor = new ControllerProfesor();
        Profesor profesor = new Profesor(501,"Ionel","Pascu","pascu.ionel89@gmail.com","ionel501","ioniepure");

        controllerProfesor.profesor(profesor.getUserId(),profesor.getParola());

        assertEquals(true,controllerProfesor.profesor(profesor.getUserId(), profesor.getParola()) != null);
    }

    @Test
    public void generareId() {
        ControllerProfesor controllerProfesor = new ControllerProfesor();
        Profesor profesor = new Profesor(504,"Alex","Avram","alx.avr5@yahoo.com","alex504","alxalx");

        controllerProfesor.generareId();

        assertEquals(profesor.getId() + 1, controllerProfesor.generareId());
    }
}