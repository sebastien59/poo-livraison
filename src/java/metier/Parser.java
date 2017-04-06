/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import data.Constante;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 *
 * @author sebastien
 */
public class Parser {
    private String file;
    private int lineStart;
    private int nbLine;
    private int nbColumn;
    
    public Parser(String file) {
        this.file = file;
        this.nbLine=0;
        this.nbColumn=0;
        this.lineStart=0;
        
    }
    
    public Boolean read() throws FileNotFoundException, IOException{
        
            String str = "";

            FileInputStream fis;
            fis = new FileInputStream(this.file);
            LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
            
            
            while ((str=l.readLine())!=null)
            {
                if(str.contains(";")){
                    this.nbLine++;
                    /*if(this.nbLine == 1){
                        String[] columns = str.split(";");
                        this.nbColumn = columns.length;
                    }*/
                    if(this.file.contains("SwapActions.csv") && this.nbLine >1){
                        this.parseSwapActions(str, this.nbLine);
                    }
                }
                else{
                    this.lineStart++;
                }
            }

            System.out.println("Nombre de lignes est " + this.nbLine);
            System.out.println("Nombre de colonnes est " + this.nbColumn);
            return true;
       
    }
    
    public void parseSwapActions(String str, int line){
        String[] values = str.split(";");
        
        switch(line){
            case 2:
                Constante.PARK = Integer.parseInt(values[1]);
                break;
            case 3:
                Constante.SWAP = Integer.parseInt(values[1]);
                break;
            case 4:
                Constante.EXCHANGE = Integer.parseInt(values[1]);
                break;
            case 5:
                Constante.PICKUP = Integer.parseInt(values[1]);
                break;
        }
    }
    
    public static void main(String[] args) throws IOException {
        Parser p=new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/SwapActions.csv");
        
        try{
            p.read();
            
            System.out.println("Park : "+ Constante.PARK);
            System.out.println("Swap : "+ Constante.SWAP);
            System.out.println("Exhange : "+ Constante.EXCHANGE);
            System.out.println("PickUp : "+ Constante.PICKUP);
         }catch(FileNotFoundException ex){
            System.out.println("test");
        }
    }
    
}
