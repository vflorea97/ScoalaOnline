package ro.mycode.Controller;

import ro.mycode.models.Enrolment;
import ro.mycode.models.Profesor;
import ro.mycode.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerProfesor {

    private ArrayList<Profesor> profesori;

    public ControllerProfesor (){
        profesori = new ArrayList<>();
        this.load();
    }
    public void load (){
        try{
            File file = new File("D:\\mycode\\incapsulare\\Proiecte\\student-management\\src\\ro\\mycode\\Data\\profesor.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String text = scanner.nextLine();
                Profesor profesori = new Profesor(text);
                this.profesori.add(profesori);
            }
            scanner.close();

        }catch (Exception e){

        }
    }
    public void save (){
        try {
            File file = new File("D:\\mycode\\incapsulare\\Proiecte\\student-management\\src\\ro\\mycode\\Data\\profesor.txt");
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
        for (i = 0; i < profesori.size() - 1; i++){
            text += this.profesori.get(i).toSave() + "\n";
        }
        text += this.profesori.get(i).toSave();
        return text;
    }

    public  void afisare (){
        for (int i = 0; i < profesori.size(); i++){
            System.out.println(profesori.get(i).descriere());
        }
    }

    public Profesor getProfesorByUserId(String useId){
        for (int i = 0; i < profesori.size(); i++){
            if (profesori.get(i).getUserId().equals(useId)){
                return profesori.get(i);
            }
        }
        return null;
    }
    public void addProfesor (Profesor profesor){
        if (getProfesorByUserId(profesor.getUserId()) == null) {
            this.profesori.add(profesor);
        }
    }
    public Profesor profesor (String username, String parola){
        for (int i = 0; i < profesori.size(); i++){
            if(profesori.get(i).getUserId().equals(username) && profesori.get(i).getParola().equals(parola)){
                return profesori.get(i);
            }
        }
        return null;
    }
    public int generareId (){
        if(this.profesori.size()>0){
            return  profesori.get(profesori.size() - 1).getId() + 1;
        }
        return 1;
    }

    public boolean isEmail(String mail){
        for (int i = 0; i < profesori.size(); i++){
            if (profesori.get(i).getMail().equals(mail))
                return true;
        }
        return false;
    }


}
