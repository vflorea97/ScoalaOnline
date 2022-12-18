package ro.mycode.Controller;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerBookTest {

    @Test
    public void addBook() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,201,"Probleme Matematica");

        controllerBook.addBook(book);

        assertEquals(true,controllerBook.getBookByName("Probleme Matematica") != null);

    }

    @Test
    public void pozitie() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,201,"Probleme Matematica");

        controllerBook.pozitie(book.getBookName());

        assertEquals(0,controllerBook.pozitie(book.getBookName()));
    }

    @Test
    public void removeBook() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,201,"Probleme Matematica");

        controllerBook.removeBook(book.getBookName());


        assertEquals(true,controllerBook.getBookByName(book.getBookName()) == null);
    }

    @Test
    public void upDate() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,201,"Probleme Matematica");

        controllerBook.upDate(book.getBookName(),book);

        assertEquals(true,controllerBook.getBookByName(book.getBookName()) != null);
    }

    @Test
    public void verificareNume() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,201,"Probleme Matematica");

        controllerBook.verificareNume(book.getBookName());

        assertEquals(true,controllerBook.getBookByName(book.getBookName()) != null);
    }

    @Test
    public void verificare() {
        ControllerBook controllerBook = new ControllerBook();
        Book book = new Book(301,201,"Probleme Matematica");

        controllerBook.verificare(book.getBookName());

        assertEquals(true,controllerBook.getBookByName(book.getBookName()) != null);
    }

    @Test
    public void fiindBooksByUserId() {
        ControllerBook controllerBook = new ControllerBook("new");
        Book book = new Book(301,201,"Probleme Matematica");
        Book book1 = new Book(302,202,"Limba Romana");

        controllerBook.addBook(book);
        controllerBook.addBook(book1);

        ArrayList<Integer> studentId = new ArrayList<>();
        studentId.add(201);
        studentId.add(202);

        controllerBook.fiindBooksByUserId(book.getStudentId());

        assertEquals(book,controllerBook.getBookByStudentId(studentId.get(0)));
    }

}