/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.si400a.pre.analisador.textos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author saina
 */
public class Processamento {

    private String texto;
    Map<String, String> map = new TreeMap();

    public String getTexto() {
        return texto;
    }

    private void setTexto(String texto) {
        this.texto = texto;
    }

    public void lerRemoverTitulo(String arquivo) {
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();

                //Removendo título-----------------------
                while (linha != null && !linha.isEmpty()) {
                    linha = lerArq.readLine();
                }
                //---------------------------------------
                while (linha != null) {
                    this.texto += (linha + " ");
                    linha = lerArq.readLine();
                }
                arq.close();
            } catch (IOException ex) {
                setTexto("Erro:não foi possível ler o arquivo!");
            }
        } catch (FileNotFoundException ex) {
            setTexto("Erro: Arquivo não encontrado!");
        }
        if (arquivo.contains("Erro")) {
            setTexto("");
        }
    }

    public void removerPont(String splitter) {
        if (this.texto.contains(splitter)) {
            setTexto(this.texto.replace(splitter, ""));
        }
    }

    public void lowerCase() {
        setTexto(this.texto.toLowerCase());
    }

    public void mapeando() {
        String[] aux = this.texto.split(" ");
        int cont = 0;
        for (String key : aux) {
            map.put(key, "");
        }
        while (cont < aux.length - 1) { //garante que não vai extrapolar o tamanho do vetor
            //verifica se o valor não está em branco
            //if (!map.get(aux[cont]).equals("")) {
                //verifica se o valor já não existe naquele mapa
                if (!map.get(aux[cont]).contains(aux[cont + 1])) {
                    map.put(aux[cont], map.get(aux[cont]) + ", " + aux[cont + 1]);
                }
           // } else {
           //     map.put(aux[cont], map.get(aux[cont]) + aux[cont + 1]);
           // }
            cont++;
        }
    }

}
