/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.promo;

import java.util.ArrayList;

/**
 *
 * @author Skull
 */
public class PromoDirectory {
    
    private static ArrayList<Promo> promoList;
    
    public PromoDirectory(){
        promoList = new ArrayList<Promo>();
    }

    public ArrayList<Promo> getPromoList() {
        return promoList;
    }

    public void addPromo(String code, int discountPercent) {
        Promo promo = new Promo(code, discountPercent);
        promoList.add(promo);
    }
    
    public static Boolean isValidPromo(String promo){
        for(Promo p: promoList){
            if(p.getCode().equals(promo))
                return true;
        }
        return false;
    }
    
    public static int getDiscountPercentFromPromo(String promo){
        int returnValue = 0;
        
        for(Promo p: promoList){
            if(p.getCode().equals(promo)){
                returnValue = p.getDiscountPercent();
                break;
            }
        }
        
        return returnValue;
    }
}
