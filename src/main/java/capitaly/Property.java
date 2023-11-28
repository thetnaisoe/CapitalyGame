/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Property extends Field{
    private final int price; //final or not
    public Property(String type){
        super(type);
        this.price = 1000;
    }
    
    @Override
    public void landedOn(Player p){
        p.buyOrPay(this);
    }
}
