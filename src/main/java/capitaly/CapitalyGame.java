/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package capitaly;
import exceptions.NegativeNumberException;
import exceptions.NegativeNumberInputException;
import exceptions.EmptyFileException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author ThetNaingSoe
 */
public class CapitalyGame{
    
    public static void main(String[] args) {
        
        try {
            System.out.println("Please Enter Number of Rounds?");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            ProcessFiles data = new ProcessFiles();
            data.readData("./src/main/java/capitaly/InputFiles/test.txt");
            data.readDice("./src/main/java/capitaly/InputFiles/dice.txt", input);
            
        } 
        catch(FileNotFoundException e){
            System.out.println("File not found!");  
        } 
        catch (EmptyFileException e){
            System.out.println("Empty File!");
        }
        
        catch(InputMismatchException e){
            System.out.println("Something is wrong in the file format or in the input.");
        }
        
        catch(NegativeNumberException negative){
            System.out.println("Negative or Zero Number is in the File");
             
        }
        
        catch(NegativeNumberInputException negativeInput){
            System.out.println("Please give positive number of rounds");
             
        }
        
        catch( NoSuchElementException element){
            System.out.println("No Such thing exist in File");
             
        }

        catch(Exception e){
            System.out.println("No of rounds is out of bound!");
             
        }      
          
    }
    
}
  
