/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author ThetNaingSoe
 */
public class Field {
    
    protected String type;
    protected String status;
    protected Player owner;
    
    public Field(String type){
        this.type = type;
        this.status = "available";
        this.owner = null;
    }
    
    public String getType(){
        return type;
    }
    
    public String isStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public int getPrice() {
        return 0; //overriden in child classes
    }
    
    public Player getOwner(){
        return owner;
    }
    
    public void setOwner(Player owner){
        this.owner = owner;
    }
    
    public void landedOn(Player p){} //overriden in child classes
    
    @Override
    public String toString(){
         return " Property = [" + type + " ]  Owner Name = [ " + (status != "available" ? owner.getName() : "null") + " ] status of Property = [ " +
                status + " ]  " ;
    }
}
