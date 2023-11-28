/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Greedy extends Player{
    
    public Greedy(String name){
        super(name, "Greedy", 10000);
    }
    
    @Override
    public boolean buyDecision(Field f){
        return this.enoughMoney(f);
    }
}
