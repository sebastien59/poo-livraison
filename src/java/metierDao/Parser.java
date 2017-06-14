/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metierDao;

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
import models.Client;
import models.Constante;
import models.Depot;

/**
 *
 * @author sebastien
 */
public class Parser {
    private String file;
    private int lineStart;
    private int nbLine;
    private int nbColumn;
    private Depot depot;
    private List<Client> clients;
    private Constante Const = new Constante();
    
    public Parser(String file) {
        this.file = file;
        this.nbLine=0;
        this.nbColumn=0;
        this.lineStart=0;
        this.clients = new ArrayList<Client>();
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
                Const.setPark(Integer.parseInt(values[1]));
                break;
            case 3:
                Const.setSwap(Integer.parseInt(values[1]));
                break;
            case 4:
                Const.setExchange(Integer.parseInt(values[1]));
                break;
            case 5:
                Const.setPickup(Integer.parseInt(values[1]));
                break;
        }
    }
    
    public void parseFleet(String str, int line){
        String[] values = str.split(";");
        
        switch(line){
            case 2:
                Const.setTruckCapacity(Integer.parseInt(values[1]));
                Const.setTruckCostKm(Double.parseDouble(values[2]));
                Const.setTruckCostH(Double.parseDouble(values[3]));
                Const.setTruckCostUsage(Double.parseDouble(values[4]));
                Const.setTruckOperatingTime(Integer.parseInt(values[5]));
                break;
            case 3:
                Const.setSemiTrailerCapacity(Integer.parseInt(values[1]));
                Const.setSemiTrailerCostKm(Double.parseDouble(values[2]));
                Const.setSemiTrailerCostH(Double.parseDouble(values[3]));
                Const.setSemiTrailerCostUsage(Double.parseDouble(values[4]));
                Const.setSemiTrailerOperatingTime(Integer.parseInt(values[5]));
                break;
            case 4:
                Const.setSwapBodyCapacity(Integer.parseInt(values[1]));
                Const.setSwapBodyCostKm(Double.parseDouble(values[2]));
                Const.setSwapBodyCostH(Double.parseDouble(values[3]));
                Const.setSwapBodyCostUsage(Double.parseDouble(values[4]));
                Const.setSwapBodyOperatingTime(Integer.parseInt(values[5]));
                break;
        }
    }
    
    public void parseLocations(String str){
        String[] values = str.split(";");
        this.nbColumn = values.length;
        
        if(values[0].equals("DEPOT")){
            int id = Integer.parseInt(values[1].replace("D",""));
            depot = new Depot(values[1], values[3], id, values[1], Double.parseDouble(values[4]), Double.parseDouble(values[5]));
        }
        else if(values[0].equals("CUSTOMER")){
            int id = Integer.parseInt(values[1].replace("C",""));
            
            clients.add(new Client(id, values[1], Double.parseDouble(values[8]), Double.parseDouble(values[6]), id, values[1], Double.parseDouble(values[4]), Double.parseDouble(values[5]), !values[7].equals("0")));
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
        
        while ((str=l.readLine())!=null)
        {
            currentColumn = 0;
            
            if(str.contains(";")){
                String[] values = str.split(";");

                for(String s: values){
                    currentColumn++;
                    M.setContent(currentLine, currentColumn, Double.parseDouble(s));
                }

                currentLine++;
            }
        }
        
        return M;
    }

    public Depot getDepot() {
        return depot;
    }

    public List<Client> getClients() {
        return clients;
    }
    
    public static void main(String[] args) throws IOException {
        Parser p=new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/SwapActions.csv");
        Parser p2=new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/Fleet.csv");
        Parser p3= new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/dima/DistanceTimesData.csv");
        Parser p4= new Parser("/Users/sebastien/Documents/IG2I/Cours/L4/POO/projet/projet2017/small_normal/Locations.csv");
        
        try{
            p.read();
            p2.read();
            p3.read();
            p3.makeMatrice();
            
            p4.read();
        }catch(FileNotFoundException ex){
            System.out.println("test");
        }
    }
}
