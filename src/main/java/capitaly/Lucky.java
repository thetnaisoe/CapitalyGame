/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Lucky extends Field {
    
    private int price;
    public Lucky(String type, int price){
        super(type);
        this.price = price;
    }
    
    @Override
    public int getPrice(){
        return this.price;
    }
    
    @Override
    public void landedOn(Player p){
        p.giveReward(this);
    }
    
    @Override
    public String toString(){
        return super.toString() + "Price = [" + price + "]";
        
    }
}
