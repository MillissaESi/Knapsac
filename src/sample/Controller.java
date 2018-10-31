package sample;

import java.util.ArrayList;

public class Controller {
    private Sac sac;
    private Objet[] objets;
    private  int gainmax ;
    private ArrayList<Objet> serie=new ArrayList<Objet>(); // la série d'objets pris



    public Objet[] getObjets() {
        return objets;
    }

    public int getGainmax() {
        return gainmax;
    }

    public ArrayList<Objet> getSerie() {
        return serie;
    }

    public Sac getSac() {
        return sac;
    }

    public void setObjets(Objet[] objets) {
        this.objets = objets;
    }

    public void setSac(Sac sac) {
        this.sac = sac;
    }

    public int number_objects(){
        return objets.length;
    }

    public void Serie_Objets(){
        // initialisation des variables

        int nbr = number_objects(); // nombre d'objets existants
        int W=sac.getPoid(); // le poid du sac a dos
        int[][] T=new int[nbr+1][W+1]; // le tableau des résultats
        int j , i ,id;


        for (j=0 ; j<=W ; j++){
            for ( i=0 ; i<=nbr ; i++){
                if ((i==0) || (j==0)){
                    T[i][j]=0;
                }else {
                    id= i -1 ;
                    if (j<this.objets[id].getPoid()){
                        T[i][j]= T[i-1][j];
                    }else {
                        if (T[i-1][j]>=T[i-1][j-this.objets[id].getPoid()]+this.objets[id].getGain()){
                            T[i][j]=T[i-1][j];
                        }else {
                            T[i][j]=T[i-1][j-this.objets[id].getPoid()]+this.objets[id].getGain();
                        }
                    }
                }
            }
        }
        // récupérer le gain max  et la série des objets
        j=W;i=nbr;
        this.gainmax=T[i][j]; // le gain max
        while((i!=0)&&(j!=0) ){

            if(j>=this.objets[i-1].getPoid()){

                if (T[i-1][j]<T[i-1][j-this.objets[i-1].getPoid()]+this.objets[i-1].getGain()){
                      // objet pris
                    this.serie.add(this.objets[i-1]);
                    j=j-this.objets[i-1].getPoid();

                }

            }
            i=i-1;
        }


    }
}
