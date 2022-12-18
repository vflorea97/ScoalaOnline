package ro.mycode.models;

import org.junit.jupiter.api.Test;
import ro.mycode.Controller.ControllerBook;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void getBook() {
        Book book = new Book(301,201,"Probleme Matematica");

        assertEquals(301,book.getId());
        assertEquals(201,book.getStudentId());
        assertEquals("Probleme Matematica", book.getBookName());
    }

    @Test
    public void setBook() {
        Book book = new Book(301,201,"Probleme Matematica");

        book.setId(300);
        book.setStudentId(200);
        book.setBookName("Mate");

        assertEquals(300,book.getId());
        assertEquals(200,book.getStudentId());
        assertEquals("Mate",book.getBookName());
    }

}