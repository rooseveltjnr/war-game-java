package br.unicap.nomedisciplina.atividade00;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;

        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    break;
                case 2:
                    System.out.println("Você saiu");
                    break;
                default:
                    System.out.println("Tecla inválida");
                    break;
            }
        } while (op != 2);
    }

    public static void menu(){
        System.out.println("1 - Começar um novo jogo \n" +
                "2 - Sair \n");
    }
}
