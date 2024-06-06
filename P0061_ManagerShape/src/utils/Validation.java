/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author a
 */
public class Validation {
   private static final Scanner sc = new Scanner(System.in);

   public static double getDouble(String messageInfo, String messageErrorOutOfRange, String messageErrorNumber, double min, double max) {
      while(true) {
         try {
            System.out.println(messageInfo);
            double number = Double.parseDouble(sc.nextLine());
            if (number >= min && number <= max) {
               return number;
            }

            System.out.println(messageErrorOutOfRange);
         } catch (Exception var9) {
            System.out.println(messageErrorNumber);
         }
      }
   }

}
