/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Tactical extends Player{
    
    public Tactical(String name){
        super(name, "Tactical", 10000);
        tacticalPlayerDecision = true;
    }
    
    @Override
    public boolean buyDecision(Field f){
        boolean flag = false;
        if(this.enoughMoney(f) && tacticalPlayerDecision){
            flag = true;
            this.setTacticalPlayerDecision();
        }
        return flag;
    }
}
