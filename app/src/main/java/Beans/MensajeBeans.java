package Beans;

public class MensajeBeans {

    private  int cod;
    private String msn, tit;

    public MensajeBeans(){

    }

    public MensajeBeans(int cod, String msn, String tit){
        this.cod=cod;
        this.tit=tit;
        this.msn=msn;
    }
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) { this.msn = msn; }


    @Override
    public String toString() {
        return cod + " - " + msn + " - " + tit ;
    }
}
