/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import utils.Validation;

/**
 *
 * @author a
 */
public class Triangle extends Shape {
   private double sideA;
   private double sideB;
   private double sideC;

   public Triangle() {
   }

   public Triangle(double sideA, double sideB, double sideC) {
      this.sideA = sideA;
      this.sideB = sideB;
      this.sideC = sideC;
   }

   public double getSideA() {
      return this.sideA;
   }

   public void setSideA(double sideA) {
      this.sideA = sideA;
   }

   public double getSideB() {
      return this.sideB;
   }

   public void setSideB(double sideB) {
      this.sideB = sideB;
   }

   public double getSideC() {
      return this.sideC;
   }

   public void setSideC(double sideC) {
      this.sideC = sideC;
   }

   public double getPerimeter() {
      return this.sideA + this.sideB + this.sideC;
   }

   public double getArea() {
      double p = (this.sideA + this.sideB + this.sideC) / 2.0D;
      return Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
   }

   public void printResult() {
      System.out.println("-----Triangle-----");
      System.out.println("Side A: " + this.sideA);
      System.out.println("Side B: " + this.sideB);
      System.out.println("Side C: " + this.sideC);
      System.out.println("Area: " + this.getArea());
      System.out.println("Perimeter: " + this.getPerimeter());
   }

   public void input() {
      while(true) {
         this.sideA = Validation.getDouble("Please input side A of Triangle: ", "Please enter number > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
         this.sideB = Validation.getDouble("Please input side B of Triangle: ", "Please enter number > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
         this.sideC = Validation.getDouble("Please input side C of Triangle: ", "Please enter number > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
         if (this.sideA + this.sideB > this.sideC && this.sideA + this.sideC > this.sideB && this.sideB + this.sideC > this.sideA) {
            return;
         }

         System.out.println("Sum of two side must be more than side remaining! Try again!");
      }
   }
}
