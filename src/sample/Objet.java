package sample;

public class Objet {
    private int id ;
    private int poid ;
    private int gain ;


    public Objet(){

    }
    public Objet(int id,int poid,int gain){
        this.id=id;
        this.poid=poid;
        this.gain=gain;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public int getPoid() {
        return poid;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getId() {
        return id;
    }
}
