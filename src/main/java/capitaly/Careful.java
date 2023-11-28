/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Careful extends Player{
    
    public Careful(String name){
        super(name, "Careful", 10000);
    }
    
    @Override
    public boolean buyDecision(Field f){
        return f.getPrice() <= Math.floor(this.getMoney()/2);
    }
}
