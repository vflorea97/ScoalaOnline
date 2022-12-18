package ro.mycode.Controller;

import ro.mycode.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerStudent {

    private ArrayList<Student> studenti;

    public ControllerStudent (){
        studenti = new ArrayList<>();
        this.load();
    }
    public ControllerStudent (String text){
        studenti = new ArrayList<>();
    }

    public void load (){
        try{
            File file = new File("D:\\mycode\\incapsulare\\Proiecte\\student-management\\src\\ro\\mycode\\Data\\student.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String text = scanner.nextLine();
                Student student = new Student(text);
                this.studenti.add(student);
            }
            scanner.close();
        }catch (Exception e){
        }
    }
    public void save(){
        try {
            File file = new File("D:\\mycode\\incapsulare\\Proiecte\\student-management\\src\\ro\\mycode\\Data\\student.txt");
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.print(this.toSave());
            printWriter.close();

        }catch (Exception e){

        }
    }
    public String toSave (){
        String text = "";
        int i = 0;
        for (i = 0; i < studenti.size() - 1; i++){
            text += this.studenti.get(i).toSave() + "\n";
        }
        text += this.studenti.get(i).toSave();
        return text;
    }

    public void afisare (){
        for (int i = 0; i < studenti.size(); i++){
            System.out.println(studenti.get(i).descriere());
        }
    }

    public Student getStudentByEmail (String email){
        for (int i = 0; i < studenti.size(); i++){
            if (studenti.get(i).getEmail().equals(email)){
                return studenti.get(i);
            }
        }
        return null;
    }
    public Student getStudentById (int id){
        for (int i = 0; i < studenti.size(); i++){
            if (studenti.get(i).getId() == id){
                return studenti.get(i);
            }
        }
        return null;
    }
    public void addStudent (Student student){
        if (getStudentByEmail(student.getEmail()) == null) {
            this.studenti.add(student);
        }
    }

    public int pozitie (int id){
        for (int i = 0; i < studenti.size(); i++){
            if (studenti.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void removeStudent (int id){
        int poz = pozitie(id);
        if (poz != -1){
            this.studenti.remove(poz);
        }
    }

    public void upDate (int id, Student s){
        int poz = pozitie(id);
        Student student = this.studenti.get(poz);
        if (s.getId() != 0){
            student.setId(s.getId());
        }
        if (!s.getFirstName().equals("")){
            student.setFirstName(s.getFirstName());
        }
        if (!s.getLastName().equals("")){
            student.setLastName(s.getLastName());
        }
        if (!s.getEmail().equals("")){
            student.setEmail(s.getEmail());
        }
        if (s.getAge() != 0){
            student.setAge(s.getAge());
        }
    }

    public boolean verificareStudent (int id){
        for (int i = 0; i < studenti.size(); i++){
            if (studenti.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public void verificare (int id){
        if (!verificareStudent(id)){
            System.out.println("Nu exista acest student, inrodu alt id!");
        }
    }

    public Student acelasiCurs (int studentId){
        for (int i = 0; i < studenti.size(); i++){
            if (studenti.get(i).getId() == studentId){
                return studenti.get(i);
            }
        }
        return null;
    }

    public void ordineAlfabetica (){
        boolean run = false;
        do {
            run = true;
            for (int i = 0; i < studenti.size() - 1; i++){
                if (studenti.get(i).getLastName().compareTo(studenti.get(i + 1).getLastName()) > 0){
                    Student element = studenti.get(i);
                    studenti.set(i, studenti.get(i + 1));
                    studenti.set(i + 1, element);
                    run = false;
                }
            }
        }
        while (!run);
    }

    public Student student (String username, String parola){
        for (int i = 0; i < studenti.size(); i++){
            if(studenti.get(i).getEmail().equals(username) && studenti.get(i).getParola().equals(parola)){
                return studenti.get(i);
            }
        }
        return null;
    }

    //generate id
    public int generareId (){

        if(this.studenti.size()>0){

             return  studenti.get(studenti.size()-1).getId()+1;
        }

        return 1;
    }

    public boolean isEmail(String mail){
        for (int i = 0; i < studenti.size(); i++){
            if (studenti.get(i).getEmail().equals(mail))
                return true;
        }
        return false;
    }

}
