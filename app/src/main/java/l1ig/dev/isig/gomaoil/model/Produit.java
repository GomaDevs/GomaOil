package l1ig.dev.isig.gomaoil.model;

/**
 * Created by Michelo on 01/11/15.
 */

public class Produit {

    private String designation;
    private float prix;

    //try to create a constructor
    public Produit(){
        //null constructor
    }

    public Produit(String designation, float price){
        this.designation=designation;
        this.prix=price;
    }



    public String getDesignation(){
        return this.designation;
    }

    public void setDesignation(String Designation){
        this.designation=Designation;
    }

    public float getPrix(){
        return this.prix;
    }

    public void setPrix(float price){
        this.prix=price;
    }

}
