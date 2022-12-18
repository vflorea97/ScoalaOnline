package ro.mycode.models;

public class Profesor {
    private int id;
    private String nume;
    private String prenume;
    private String mail;
    private String userId;
    private String parola;

    public Profesor (){
        this.id = 0;
        this.nume = "";
        this.prenume = "";
        this.mail = "";
        this.userId = "";
        this.parola = "";
    }
    public Profesor(int id,String nume,String prenume,String mail,String userId,String parola){
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.mail = mail;
        this.userId = userId;
        this.parola = parola;
    }
    public Profesor (String text){
        String [] proprietati = text.split(",");
        this.id = Integer.parseInt(proprietati[0]);
        this.nume = proprietati[1];
        this.prenume = proprietati[2];
        this.mail = proprietati[3];
        this.userId = proprietati[4];
        this.parola = proprietati[5];
    }

    public String descriere (){
        String text = "";
        text += "ID: " + id + "\n";
        text += "Nume: " + nume + "\n";
        text += "Prenume: " + prenume + "\n";
        text += "Mail: " + mail + "\n";
        text += "UserId: " + userId + "\n";
        return text;
    }
    public String toSave (){
        return this.id+","+this.nume+","+this.prenume+","+this.mail+","+this.userId+","+this.parola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
