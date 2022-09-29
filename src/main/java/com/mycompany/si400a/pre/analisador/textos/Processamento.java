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
 * Classe para trabalhar em cima <br>
 * do texto e mapea-lo.
 * @author 
 */
public class Processamento {
    private String texto = "";
    private TreeMap<String, String> map = new TreeMap();
    /**
     * Método acessor publico do atributo texto.<br>
     * <b>Uso:</b>
     * Objeto.getTexto();<br>
     * @return um objeto do tipo String <br>
     * contendo o valor do atributo texto.
     * @author Matheus Roberto Mariano 246029
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Método modificador público do atributo texto.<br>
     * <b>Uso:</b>
     * Objeto.setTexto(String texto);<br>
     * @param texto é um Objeto do tipo String<br>
     * que sobrescreve o conteúdo do atributo texto.
     * @author Matheus Roberto Mariano 246029
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
     /**
     * Método acessor publico do atributo map.<br>
     * <b>uso:</b>
     * Objeto.getMap();<br>
     * @return um objeto do tipo TreeMap<br>
     * contendo o valor do atributo map.
     * @author Matheus Roberto Mariano 246029
     */
    public Map<String, String> getMap() {
        return map;
    }
    /**
     * Método para fazer a leitura e remoção do título do texto<br>
     * Caso não encontre o Arquivo ou não consiga lê-lo armazena<br>
     * um conteúdo de Erro ao atributo texto do Objeto e mostrá-lo<br>
     * no terminal.<br>
     * <b>Uso:</b>
     * ObjetoProcessamento.lerRemoverTitulo(String arquivo);
     * @param arquivo deve ser um Objeto do tipo String<br>
     * contendo o nome do arquivo a ser lido.
     * @author Tauan Rodrigues 247599
     */
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
                System.out.println(getTexto());
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            setTexto("Erro: Arquivo não encontrado!");
            System.out.println(getTexto());
            System.exit(0);
        }
    }
    /**
     * Método para fazer a remoção de uma pontuação (substring) do texto. <br>
     * <b>Uso:</b> <br>
     * ObjetoProcessamento.removerPont(String splitter); <br>
     * @param splitter deve ser um Objeto do tipo String <br> 
     * contendo a pontuação a ser removido do texto. <br>
     * @author Matheus Roberto Mariano 246029
     */
    public void removerPont(String splitter) {
        if (this.texto.contains(splitter)) {
            setTexto(this.texto.replace(splitter, ""));
        }
    }
    /**
     * Método para fazer a remoção de espaços em branco do texto<br>
     * Ao remover a pontuação podem ser gerados espaços em branco consecutivos<br>
     * <b>Uso:</b>
     * ObjetoProcessamento.removerPont();
     * Use sempre esse método após todos os outros removerPont(String splitter).
     * @author Matheus Roberto Mariano 246029
     */
    public void removerPont() {
        if (getTexto().contains("  ") || getTexto().contains("   ")) {
            setTexto(this.texto.replace("  ", ""));
            setTexto(this.texto.replace("   ", ""));
        }
    }
    /**
     * Método para converter todos os caracteres<br>
     * do texto em letras minúsculas<br>
     * <b>Uso:</b>
     * ObjetoProcessamento.lowerCase();
     * @author Matheus Roberto Mariano 246029
     */
    public void lowerCase() {
        setTexto(this.texto.toLowerCase());
    }
    /**
     * Método para mapear o atributo texto usando uma TreeMap<br>
     * que recebe todas as palavras do texto uma única vez<br>
     * como chave e atribui a elas um valor vazio, para<br>
     * posteriormente concatenar as palavras seguintes a <br>
     * essa chave ao valor das mesmas e armazenar no Atributo<br>
     * map desse objeto<br>
     * <b>Uso:</b>
     * ObjetoProcessamento.mapear();
     * @author Rodrigo Marabesi Machado 187908
     */
    public void mapear() {
        
        String[] aux = this.texto.split(" ");
        int cont = 0;
        
        for (String key : aux) {
            //verifica se existe mais de uma ocorrência de uma mesma palavra
                if(!(key == aux[aux.length-1])){
                    this.map.put(key, "");
                }
                cont++;
        }
        cont = 1;
        //garante que não vai extrapolar o tamanho do vetor
        while (cont < aux.length - 1) {
            //verifica se o valor já não existe naquele mapa
            if (!map.get(aux[cont]).contains(aux[cont + 1])) {
                    this.map.put(aux[cont], this.map.get(aux[cont]) + ", " + aux[cont + 1]);
            }
            cont++;
        }
        //removendo chaves nula
        while (cont < aux.length - 1) {
            if(this.map.get(aux[cont]) == ""){
                this.map.remove(aux[cont]);
            }
            cont++;
        }
    }
}
