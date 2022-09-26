/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.si400a.pre.analisador.textos;

/**
 *
 * @author saina
 */
public class Controller {

    public void go(String[] args) {
        for (String txt : args) {
            Processamento instancia = new Processamento();
            instancia.lerRemoverTitulo(txt);
            instancia.removerPont(",");
            instancia.removerPont("!");
            instancia.removerPont(".");
            instancia.removerPont("'");
            instancia.removerPont("\"");
            instancia.removerPont("-");
            instancia.removerPont("(");
            instancia.removerPont(")");
            instancia.removerPont();
            instancia.lowerCase();
            instancia.mapear();
            Exportacao.escrever(instancia.getMap(), txt);
        }
    }
}
