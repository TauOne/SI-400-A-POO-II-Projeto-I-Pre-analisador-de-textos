/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.si400a.pre.analisador.textos;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author saina
 */
public class Controller {
    public void go(String[] args){
        List<String> textos = new ArrayList<>();
        for(String txt : args){
            Processamento instancia = new Processamento();
            instancia.lerRemoverTitulo(txt);
            instancia.removerPont(",");
            instancia.removerPont("!");
            instancia.removerPont(".");
            instancia.removerPont("'");
            instancia.removerPont("\"");
            instancia.removerPont("-");
            instancia.lowerCase();
            instancia.mapeando();
            for(String key : instancia.map.keySet()){
                System.out.println(key + instancia.map.get(key));
            }
            System.out.println(instancia.map.entrySet());
            //System.out.println(instancia.getTexto());
        }
    }
}
