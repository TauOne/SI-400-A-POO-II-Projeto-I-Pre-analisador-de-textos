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
 * Classe para criação o arquivo .csv
 *
 * @author
 */
public class Exportacao {

    /**
     * Método unico da classe para criação do arquivo<br>
     * e escrita no mesmo, contendo o mesmo nome do arquivo<br>
     * de origem porém num formato .csv<br>
     * <b>Uso:</b><br>
     * Exportacao.escrever(Mapa(chave String , valor String), String nome do
     * arquivo);<br>
     *
     * @param map Recebe de preferência uma TreeMap para ser escrita no arquivo
     * de destino<br>
     * @param arg Recebe o nome do arquivo no formato .txt a ser convertido em
     * .csv.
     * @author
     */
    public static void escrever(Map<String, String> map, String arg) {
        arg = arg.replace(".txt", "");
        arg += ".csv";
        try {
            FileWriter arq = new FileWriter(arg);
            try ( PrintWriter gravarArq = new PrintWriter(arq)) {
                arg = "";
                for (String key : map.keySet()) {
                    arg += key + map.get(key) + "\n";
                }
                gravarArq.println(arg);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
