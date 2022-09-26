/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.si400a.pre.analisador.textos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author saina
 */
public class Exportacao {

    public static void escrever(Map<String, String> map, String arg) {
        arg = arg.replace(".txt", "");
        arg += ".csv";
        try {
            FileWriter arq = new FileWriter(arg);
            PrintWriter gravarArq = new PrintWriter(arq);
            arg = "";
            for (String key : map.keySet()) {
                arg += key + map.get(key) + "\n";
            }
            gravarArq.println(arg);
            gravarArq.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
