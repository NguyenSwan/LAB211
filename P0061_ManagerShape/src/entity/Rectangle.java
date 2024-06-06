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
public class Rectangle extends Shape {
   private double width;
   private double length;

   public Rectangle() {
   }

   public Rectangle(double width, double length) {
      this.width = width;
      this.length = length;
   }

   public double getWidth() {
      return this.width;
   }

   public void setWidth(double width) {
      this.width = width;
   }

   public double getLength() {
      return this.length;
   }

   public void setLength(double length) {
      this.length = length;
   }

   public double getPerimeter() {
      return 2.0D * (this.width + this.length);
   }

   public double getArea() {
      return this.width * this.length;
   }

   public void printResult() {
      System.out.println("-----Rectangle-----");
      System.out.println("Width: " + this.width);
      System.out.println("Length: " + this.length);
      System.out.println("Area: " + this.getArea());
      System.out.println("Perimeter: " + this.getPerimeter());
   }

   public void input() {
      this.width = Validation.getDouble("Please input side width of Rectangle: ", "Please enter number > 0", "invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
      this.length = Validation.getDouble("Please input side length of Rectangle: ", "Please enter number >=" + this.width, "invalid!", this.width, Double.MAX_VALUE);
   }
}
