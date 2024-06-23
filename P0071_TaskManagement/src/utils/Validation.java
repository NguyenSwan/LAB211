/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author a
 */
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public int getInt(String mess, int min, int max){
        int n;
        while (true) {            
            try {
                System.out.print(mess);
                n = Integer.parseInt(sc.nextLine());
                if(min <= n && n <= max)
                    break;
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter an interger in range: " +min+ " -> " +max);
            }
        }
        return n;
    }
    
    public double getDouble(String mess,double min,double max){
     double n ;
     while(true){
      try{
          System.out.print(mess);
          n = Double.parseDouble(sc.nextLine());
          if(min<= n && n<=max)
              break;
          throw new NumberFormatException();
      }
      catch(NumberFormatException ex){
           System.out.println("Please enter an real number in range: "+min+"->"+max );
        
      }
     }
     return n;
    }
    
//    public String getDate(String mess, String error, String format){
//        SimpleDateFormat simpleDate = new SimpleDateFormat(format);
//        Date date = null;
////        simpleDate.setLenient(false);  //ktra ngay 1 cach nghiem ngat hon
//        String value = "";
//        while (true) {            
//            try {
//                System.out.print(mess);
//                value = sc.nextLine();
//                date = simpleDate.parse(value);
//                break;
//            } catch (ParseException e) {
//                System.out.println(error);
//            }
//        }
//        return value;
//    }
    
    public String getDate(String mess, String error, String format){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    String value = "";
    while (true) {            
        try {
            System.out.print(mess);
            value = sc.nextLine();
            LocalDate.parse(value, formatter);
            break;
        } catch (DateTimeParseException e) {
            System.out.println(error + " (Format: " + format + ")");
        }
    }
    return value;
}
    
    public String getString(String regex, String mess){
        String str = null;
        boolean check;
        do {            
            check = true;
            System.out.print(mess);
            str = sc.nextLine();
            if(!str.matches(regex)){
                check = false;
                break;
            }
        } while (check== false);
        return str;
    }
}
