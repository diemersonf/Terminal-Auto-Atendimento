package terminalatendimentobanco;

import java.util.Scanner;

public class TerminalAtendimentoBanco 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int valor1 = 0;
        int valor2 = 0;
        int soma = 0;
        
        System.out.println("Insira o primeiro valor: ");
        valor1 = input.nextInt();

        System.out.println("Insira o segundo valor: ");
        valor2 = input.nextInt();
        
        soma = valor1 + valor2;
        
        System.out.printf("O Soma de %d e %d é: %d\n", valor1, valor2, soma);        
    }    
}
