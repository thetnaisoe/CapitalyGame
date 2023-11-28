/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Service extends Field{
    private final int penalty;
    public Service(String type, int penalty){
        super(type);
        this.penalty = penalty;
    }
    
    @Override
    public int getPrice(){
        return this.penalty;
    }
    
    @Override
    public void landedOn(Player p){
        p.penaltyPay(this);
    }
    
    @Override
    public String toString(){
        return super.toString() + "Penaly Price =[" + penalty + "]";
        
    }
}
