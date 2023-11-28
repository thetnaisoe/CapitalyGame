/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

import exceptions.NegativeNumberException;
import exceptions.NegativeNumberInputException;
import exceptions.EmptyFileException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 * @author ThetNaingSoe
 */
public class ProcessFiles {
    
    private static ArrayList<Player> allPlayers;
    private final  ArrayList<Field> allFields; 
    private final  ArrayList<Integer> Rolls;
    private static int numberOfallFields;
    private static int  numberOfallPlayers; 
    

    public ProcessFiles() {
        this.allPlayers = new ArrayList<>();
        this.allFields = new ArrayList<>();
        this.Rolls = new ArrayList<>();
    }

    public ArrayList<Player> getallPlayers() {
        return allPlayers;
    }

    public ArrayList<Field> getallFields() {
        return allFields;
    }
    
    public void readData(String filename) throws FileNotFoundException, EmptyFileException, NegativeNumberException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        if(! sc.hasNext())
        {
            throw new EmptyFileException();
        
        }
        numberOfallFields = sc.nextInt();
        Field field = new Field("");
        
        for(int i = 0; i< numberOfallFields; ++i)
        { 
            String type;
            type = sc.next();
                if("Service".equals(type))  
                {
                    field = new Service(type, sc.nextInt());
                }
                
                else if("LuckyField".equals(type ))
                {
                    field = new Lucky(type, sc.nextInt());      
                }
                else if("Property".equals(type))
                {
                    field = new Property(type);
                }
                else
                {
                    System.out.println("The input file has error in format.");
                    System.exit(-1);
                }
                    
                allFields.add(field);
                
        }

       numberOfallPlayers = sc.nextInt();
       if(numberOfallPlayers <= 0)
       {
           throw new NegativeNumberException();
       }
        Player newPlayer = new Player("", "", 0); 
         
        for (int i=0;i<numberOfallPlayers;i++)
        {
            String name = sc.next();
            String strategy = sc.next();
            switch(strategy)
            {
                case "Greedy":
                    newPlayer = new Greedy(name);
                    break;
                case "Careful":
                    newPlayer = new Careful(name);
                    break;
                case "Tactical":
                    newPlayer = new Tactical(name);
                    break;
                default:
                    System.out.println("The input file has error in format.");
                    System.exit(-1);
            }
            allPlayers.add(newPlayer);
        }

    }
 
   
    public void readDice(String filename , int givenR) throws FileNotFoundException, EmptyFileException, NegativeNumberException, NegativeNumberInputException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        if(givenR < 0)
        {
            throw new NegativeNumberInputException();
        }
        
        if(! sc.hasNext())
        {
            throw new EmptyFileException();
        
        }

        while(sc.hasNext())
        {
            int roll = sc.nextInt();
            if(roll < 0)
            {
                throw new NegativeNumberException();
        
            }     
        
            while(roll > numberOfallFields)
            {
                roll -= numberOfallFields;
            }
            Rolls.add(roll);
        }
        
        int count = 0; 
        System.out.println("\n-------------------------\n");
        System.out.println("After " + givenR + " Number of Rounds :");
        System.out.println("\n-------------------------\n");
        for( int i = 0; i < givenR ; ++i)
        {
            for(Player p: allPlayers)
            {
                int turn = Rolls.get(count);
                if ((p.getPosition() + turn) > numberOfallFields )
                { 
                    p.setPosition((p.getPosition() + turn) - numberOfallFields ); 
                }
                else
                {
                    p.setPosition(p.getPosition() + turn);
                }
                Field currentField = allFields.get(p.getPosition()-1);
                currentField.landedOn(p);
                count++;
            }
            
        }
        
       for(Player p : allPlayers)
        {
            System.out.println("Name: " + p.getName() + "\nStrategy: " + p.getStrategy() + "\nMoney Left: " + p.getMoney() +
                               "\nNumber of Properties Owned: " + p.totalProperties() );
            System.out.println("\n---------------------------------\n");        
        }
    
    }
    
}
