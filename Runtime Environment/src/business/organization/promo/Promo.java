/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.promo;

/**
 *
 * @author Skull
 */
public class Promo {
    
    private static int count = 0;
    private int id;
    
    private String code;
    private int discountPercent;
    
    public Promo(String code, int discountPercent){
        count++;
        id = count;
        this.code = code;
        this.discountPercent = discountPercent;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    @Override
    public String toString(){
        return code;
    }
}
