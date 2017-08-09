package Beans;

/**
 * Created by HP on 28/6/2017.
 */

public class UsuarioBeans {

    private int cod;
    private  String nom,ape,mail,pass;

    public UsuarioBeans() {
    }

    public UsuarioBeans(int cod,String nom, String ape, String mail, String pass) {
        this.cod = cod;
        this.nom = nom;
        this.ape = ape;
        this.mail = mail;
        this.pass = pass;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return  cod + " - " + nom + " - " + ape + " - " + mail ;
    }
}

