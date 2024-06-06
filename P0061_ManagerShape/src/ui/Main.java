/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import entity.Circle;
import entity.Rectangle;
import entity.Shape;
import entity.Triangle;

/**
 *
 * @author a
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("====Calculator Shape Program====");
        Shape[] shapes = new Shape[]{new Rectangle(), new Circle(), new Triangle()};

        int i;
        for(i = 0; i < shapes.length; ++i) {
           shapes[i].input();
        }

        for(i = 0; i < shapes.length; ++i) {
           shapes[i].printResult();
        }
    }
}
