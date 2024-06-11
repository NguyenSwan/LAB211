/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.Worker;
import java.util.List;
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
    public String getCode(String msg,String errol,List<Worker> wlist, int mode){
     String s;
       while(true){
         
           System.out.print(msg);
           s = sc.nextLine();
           if(!s.toUpperCase().isEmpty()){
            if((mode==1 && getWorker(s,wlist)==null)
                    ||(mode==2 && getWorker(s, wlist)!=null))
                break;
           }
           System.err.println(errol);
          
       }
       
        return s;
    }
    public static Worker getWorker (String code,List<Worker> wList){
        for (Worker o : wList) {
            if(o.getCode().equalsIgnoreCase(code)){
                return o;
            }
        }
        return null;
    }
}
