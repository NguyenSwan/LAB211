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
public class Circle extends Shape {
   private double radius;

   public Circle() {
   }

   public Circle(double radius) {
      this.radius = radius;
   }

   public double getRadius() {
      return this.radius;
   }

   public void setRadius(double radius) {
      this.radius = radius;
   }

   public double getPerimeter() {
      return 6.283185307179586D * this.radius;
   }

   public double getArea() {
      return 3.141592653589793D * this.radius * this.radius;
   }

   public void printResult() {
      System.out.println("-----Circle-----");
      System.out.println("Radius: " + this.radius);
      System.out.println("Area: " + this.getArea());
      System.out.println("Perimeter: " + this.getPerimeter());
   }

   public void input() {
      this.radius = Validation.getDouble("Please input radius of Circle: ", "Please enter number > 0", "Invalid!", Double.MIN_VALUE, Double.MAX_VALUE);
   }
}
