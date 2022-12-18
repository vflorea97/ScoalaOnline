package ro.mycode.models;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String parola;

    public Student (){
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.age = 0;
        this.parola = "";
    }

    public Student (int id,String firstName,String lastName,String email,int age,String parola){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.parola = parola;
    }

    public Student (String text){
        String [] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.firstName = proprietati[1];
        this.lastName = proprietati[2];
        this.email = proprietati[3];
        this.age = Integer.parseInt(proprietati[4]);
        this.parola = proprietati[5];
    }

    public String descriere (){
        String text = "";
        text += "ID: " + id + "\n";
        text += "First name: " + firstName + "\n";
        text += "Last name: " + lastName + "\n";
        text += "Email: " + email + "\n";
        text += "Age: " + age + "\n";
        return text;
    }

    public String toSave (){
        return this.id+","+this.firstName+","+this.lastName+","+this.email+","+this.age+","+this.parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
