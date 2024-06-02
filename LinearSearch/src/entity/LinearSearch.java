/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author a
 */
public class LinearSearch {
    
    /**
     *
     * @param array
     * @param key
     * @return
     */
    public int linearSearch(int[] array, int key){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }
    
    /**
     *
     * @param array
     */
    public void display(int[] array){
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i == array.length - 1) {
                str += "]";
            } else {
                str += ", ";
            }
        }
        System.out.println(str);    
    }
}
