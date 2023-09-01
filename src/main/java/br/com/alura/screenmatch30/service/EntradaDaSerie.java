package br.com.alura.screenmatch30.service;

import java.util.Scanner;

public class EntradaDaSerie {

    public String obeterNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da Série: ");

        return scanner.nextLine().strip().replace(" ", "+");
    }
}
