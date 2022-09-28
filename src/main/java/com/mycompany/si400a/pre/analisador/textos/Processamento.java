/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.si400a.pre.analisador.textos;

import java.io.BufferedReader;
import java.io.File;
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
    TreeMap<String, String> map = new TreeMap();

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Map<String, String> getMap() {
        return map;
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

    public void removerPont() {
        if (this.texto.contains("  ") || this.texto.contains("   ")) {
            setTexto(this.texto.replace("  ", ""));
            setTexto(this.texto.replace("   ", ""));
        }
    }

    public void lowerCase() {
        setTexto(this.texto.toLowerCase());
    }

    public void mapear() {
        String[] aux = this.texto.split(" ");
        int cont = 0;

        //cria um mapeamento somente com as chaves
        for (String key : aux) {
            this.map.put(key, "");
        }

        //garante que não vai extrapolar o tamanho do vetor
        while (cont < aux.length - 1) {
            //verifica se o valor já não existe naquele mapa
            if (!map.get(aux[cont]).contains(aux[cont + 1])) {
                this.map.put(aux[cont], this.map.get(aux[cont]) + ", " + aux[cont + 1]);
            }
            cont++;
        }
    }
}
