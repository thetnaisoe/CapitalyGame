/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

import java.util.ArrayList;
/**
 *
 * @author ThetNaingSoe
 */
public class Player {
    
    private String name;
    private String strategy;
    private int money;
    private int position;
    protected boolean tacticalPlayerDecision;
    private ArrayList<Field> owned_properties;
    
    public Player(String name, String strategy, int money){
        this.name = name;
        this.strategy = strategy;
        this.money = money;
        this.owned_properties = new ArrayList<>();
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getStrategy() 
    {
        return strategy;
    }

    public void setStrategy(String strategy)
    {
        this.strategy = strategy;
    }

    public int getMoney() 
    {
        return money;
    }

    public void setMoney(int token)
    {
        this.money = money+ token;
    }

    public int getPosition()
    {
        return position;
    }
    
    public void setPosition(int position) 
    {
        this.position = position;
    }

  public void addField(Field f)
  {
      owned_properties.add(f);
  }

    public boolean isTacticalPlayerDecision()
    {
        return tacticalPlayerDecision;
    }

    public void setTacticalPlayerDecision() 
    {
        tacticalPlayerDecision = !tacticalPlayerDecision;
    }

    public ArrayList<Field> getOwned_properties() 
    {
        return owned_properties;
    }
    
    public boolean enoughMoney(Field f){
        return (this.getMoney() >= f.getPrice());
    }
    
    public void giveReward(Field f){
        this.setMoney(f.getPrice());
    }
    
    public boolean buyDecision(Field f){
        return true; //according to player type
    }
    
    public int totalProperties(){
        return owned_properties.size();
    }
    
    public void removeAllFields(){
        for(Field f : owned_properties){
            f.setStatus("available");
            f.setOwner(null);
        }
        owned_properties.clear();
    }
    
    public void penaltyPay(Field f){
        if(this.getMoney() >= f.getPrice()){
            this.setMoney(-f.getPrice());
        }
        else{
            this.removeAllFields();
        }
    }
    
    public boolean buyField(Field f){
        if("available".equals(f.status)){
            if(this.buyDecision(f)){
                this.addField(f);
                this.setMoney(-1000);
                f.setOwner(this);
                f.setStatus("owned");
                return true;
            }
        }
        return false;
    }
    
    public boolean builtHouse(Field f){
        if("owned".equals(f.status) && f.getOwner().getName().equals(name)){
            if(this.getMoney() >= 4000 && this.buyDecision(f)){
                f.setStatus("house");
                this.setMoney(-4000);
                return true;
            }
        }
        return false;
    }
    
    public void payRent(Field f){
        if("owned".equals(f.status) && !name.equals(f.getOwner().getName())){
            if(this.getMoney() >= 500){
                this.setMoney(-500);
                f.getOwner().setMoney(500);
            }
            else if("house".equals(f.status) && !name.equals(f.getOwner().getName())){
                if(this.getMoney() >= 2000){
                    this.setMoney(-2000);
                    f.getOwner().setMoney(2000);
                }
            }
        }
    }
    
    public void buyOrPay(Field f){
        if(buyField(f)){
            
        }
        else if(builtHouse(f)){
            
        }
        else payRent(f);
    }
    
    
}
