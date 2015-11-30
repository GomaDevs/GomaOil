package l1ig.dev.isig.gomaoil.model;

/**
 * Created by Michelo on 01/11/15.
 */
public class Diesel extends Produit {

    private String quality;

    public Diesel(){
        //null constructor
    }

    public Diesel(String design, float price){
        super(design,price);
    }

    public Diesel(String design, float price, String quality){
        super(design, price);
        this.quality=quality;
    }

    public void setQuality(String qlte){
        this.quality=qlte;
    }

    public String getQuality(){
        return this.quality;
    }

}
