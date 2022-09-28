/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.si400a.pre.analisador.textos;

//import java.util.Map;
//import java.util.TreeMap;

/**
 *
 * @author Wara Inti Pardo 218904
 */
public class main {

    public static void main(String[] args) {
        try {
            Controller inicio = new Controller();
            inicio.go();
        } catch (Exception e) {
            System.out.println("Falha Catastrófica");
        }
    }
}
