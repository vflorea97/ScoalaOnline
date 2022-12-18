package ro.mycode.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {

    @Test
    void getProfesor() {
        Profesor profesor = new Profesor(501,"Ionel","Pascu","pascu.ionel89@gmail.com","ionel501","ioniepure");

        assertEquals(501,profesor.getId());
        assertEquals("Ionel",profesor.getNume());
        assertEquals("Pascu",profesor.getPrenume());
        assertEquals("pascu.ionel89@gmail.com",profesor.getMail());
        assertEquals("ionel501",profesor.getUserId());
        assertEquals("ioniepure",profesor.getParola());
    }

    @Test
    void setProfesor() {
        Profesor profesor = new Profesor(501,"Ionel","Pascu","pascu.ionel89@gmail.com","ionel501","ioniepure");

        profesor.setId(500);
        profesor.setNume("Ione");
        profesor.setPrenume("Pasc");
        profesor.setMail("pascu.ionel89@gmail.co");
        profesor.setUserId("Ionel501");
        profesor.setParola("ioniepur");

        assertEquals(500,profesor.getId());
        assertEquals("Ione",profesor.getNume());
        assertEquals("Pasc",profesor.getPrenume());
        assertEquals("pascu.ionel89@gmail.co",profesor.getMail());
        assertEquals("Ionel501",profesor.getUserId());
        assertEquals("ioniepur",profesor.getParola());

    }
}