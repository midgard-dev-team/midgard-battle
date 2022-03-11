/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ferraris.ivbi.midgardbattle.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOSERVIZIO {
    private static BufferedReader tastiera=new BufferedReader(new InputStreamReader(System.in));
    
    
    public static void stampaMessaggio(String msg){
        System.out.println(msg);
    }
    
    public static int inserisciIntero(String msg){
        try {
            int num;
            stampaMessaggio(msg);
            num=Integer.parseInt(tastiera.readLine());
            
            return num;
        } catch (IOException ex) {
            Logger.getLogger(IOSERVIZIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static double inserisciDouble(String msg){
        try {
            double num;
            stampaMessaggio(msg);
            num=Double.parseDouble(tastiera.readLine());
            
            return num;
        } catch (IOException ex) {
            Logger.getLogger(IOSERVIZIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static String inserisciString(String msg){
        String s = "";
        stampaMessaggio(msg);
        try {
            s = tastiera.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}