/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import data.Client;
import data.Constante;
import data.Depot;
import data.Matrice;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebastien
 */
public class Parser {
    private String file;
    private int lineStart;
    private int nbLine;
    private int nbColumn;
    private Depot d;
    private List<Client> liste_client;
    
    public Parser(String file) {
        this.file = file;
        this.nbLine=0;
        this.nbColumn=0;
        this.lineStart=0;
        this.liste_client= new ArrayList<Client>();
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
                    
                    if(this.file.contains("SwapActions.csv") && this.nbLine >1){
                        this.parseSwapActions(str, this.nbLine);
                    }
                    
                    if(this.file.contains("Fleet.csv") && this.nbLine >1){
                        this.parseFleet(str, this.nbLine);
                    }
                    
                    if(this.file.contains("Locations.csv")){
                        this.parseLocations(str);
                        
                        System.out.println(liste_client);
                    }
                    
                    if(this.file.contains("DistanceTimesData.csv")){
                        String[] values = str.split(";");
                        this.nbColumn = values.length;
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
    
    public void parseFleet(String str, int line){
        String[] values = str.split(";");
        
        switch(line){
            case 2:
                Constante.TRUCK_CAPACITY = Integer.parseInt(values[1]);
                Constante.TRUCK_COST_KM = Double.parseDouble(values[2]);
                Constante.TRUCK_COST_H = Double.parseDouble(values[3]);
                Constante.TRUCK_COST_USAGE = Double.parseDouble(values[4]);
                Constante.TRUCK_OPERATING_TIME = Integer.parseInt(values[5]);
                break;
            case 3:
                Constante.SEMI_TRAILER_CAPACITY = Integer.parseInt(values[1]);
                Constante.SEMI_TRAILER_COST_KM = Double.parseDouble(values[2]);
                Constante.SEMI_TRAILER_COST_H = Double.parseDouble(values[3]);
                Constante.SEMI_TRAILER_COST_USAGE = Double.parseDouble(values[4]);
                Constante.SEMI_TRAILER_OPERATING_TIME = Integer.parseInt(values[5]);
                break;
            case 4:
                Constante.SWAP_BODY_CAPACITY = Integer.parseInt(values[1]);
                Constante.SWAP_BODY_COST_KM = Double.parseDouble(values[2]);
                Constante.SWAP_BODY_COST_H = Double.parseDouble(values[3]);
                Constante.SWAP_BODY_COST_USAGE = Double.parseDouble(values[4]);
                Constante.SWAP_BODY_OPERATING_TIME = Integer.parseInt(values[5]);
                break;
        }
    }
    
    public void parseLocations(String str){
        String[] values = str.split(";");
        this.nbColumn = values.length;
        
        if(values[0].equals("DEPOT")){
            int id = Integer.parseInt(values[1].replace("D",""));
            d = new Depot(values[1], values[1], id, values[3], Double.parseDouble(values[4]), Double.parseDouble(values[5]));
        }
        else if(values[0].equals("CUSTOMER")){
            int id = Integer.parseInt(values[1].replace("C",""));
            System.out.println(values[1] + " | "+values[7]);
            liste_client.add(new Client(id, values[1], Double.parseDouble(values[8]), Double.parseDouble(values[6]), id, values[1], Double.parseDouble(values[4]), Double.parseDouble(values[5]), Boolean.parseBoolean(values[7])));
        }
        
        
    }
    
    public void parseDistanceTimesData(String str, int line){
        String[] values = str.split(";");
        this.nbColumn = values.length;
        
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
      
    public Matrice makeMatrice() throws FileNotFoundException, IOException{
        int nbC = this.nbColumn;
        int nbL= this.nbLine;
        int Linestart = this.lineStart;
        
        Matrice M = new Matrice(nbL,nbC);
        
        String str = "";
        FileInputStream fis;
        fis = new FileInputStream(this.file);
        LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
        int currentLine = Linestart;
        int currentColumn = 0;
        System.out.println("Linestart :"+Linestart);
        
        while ((str=l.readLine())!=null)
        {
            currentColumn = 0;
            
            if(str.contains(";")){
                String[] values = str.split(";");

                for(String s: values){
                    currentColumn++;

                    M.setContent(currentLine, currentColumn, Double.parseDouble(s));
                    System.out.println(currentLine+" "+currentColumn+" "+s);
                }

                currentLine++;
            }
        }
        
        return M;
    }
    
    public static void main(String[] args) throws IOException {
        Parser p=new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/SwapActions.csv");
        Parser p2=new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/Fleet.csv");
        Parser p3= new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/dima/DistanceTimesData.csv");
        
        Parser p4= new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/Locations.csv");
        
        try{
            p.read();
            p2.read();
            //p3.read();
            //p3.makeMatrice();
            
            p4.read();
            Constante.string();
        }catch(FileNotFoundException ex){
            System.out.println("test");
        }
    }
}
