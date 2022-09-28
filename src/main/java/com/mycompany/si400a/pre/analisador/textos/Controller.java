/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.si400a.pre.analisador.textos;

import java.util.Scanner;

/**
 *Classe que carrega toda a lógica do programa.
 * @author 
 */
public class Controller {
    /**
     * Método único para executar sequencialmente toda a lógica do programa<br>
     * <b>Uso:</b><br>
     * ObjetoController.go();<br>
     * Inicialmente recebe os nomes dos arquivos a serem trabalhados para gravar<br>
     * em um Array de Strings<br>
     * Após isso para cada elemento desse Array de Strings ela executas as seguintes<br>
     * tarefas de maneira sequencial:
     *  Criar um objeto processamento<br>
     *  Ler o texto e remover o Título<br>
     *  Remover todas as pontuações<br>
     *  Remover os espaços em branco consecutivos<br>
     *  Tornar todos os carcteres minúsculos<br>
     *  Mapear o texto<br>
     *  Criar o arquivo .csv<br>
     *  @author 
     */
    public void go() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] args = line.split(" ");
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
