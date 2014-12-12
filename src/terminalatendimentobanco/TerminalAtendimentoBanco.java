package terminalatendimentobanco;

import java.util.Scanner;

public class TerminalAtendimentoBanco 
{
    public static Scanner input = new Scanner(System.in);
    public static int conta;
    public static int senha;
    public static int opcao = 0;
        
    public static void main(String[] args) 
    {   
        System.out.printf("Bem Vindo ao seu banco 24 horas.\n Tecle Enter para continuar...\n"); 
        solicitaDadosDaConta();       
    }  
    
    public static void solicitaDadosDaConta()
    {        
        System.out.printf("Insira o número de sua conta: \n");
        conta = input.nextInt();

        if (conta == 19358)
        {
            System.out.printf("Digite sua Senha de 6 números: \n");
            senha = input.nextInt(); 
            
            if (senha == 010512)
            {
                menuPrincipal();
            }else
            {
                System.out.printf("Senha Incorreta! Tente novamente.\n");
                solicitaDadosDaConta();                 
            }
        } else
        {   
            System.out.printf("Conta não encontrada! Tente novamente.\n");
            solicitaDadosDaConta();
        }          
    }
    
    public static void menuPrincipal()
    {
        System.out.printf("Bem Vindo ao menu principal. Digite a opção desejada./n/n");
        System.out.printf("1 - Consulta Saldo\n");
        System.out.printf("2 - Saque\n");        
        System.out.printf("3 - Depósito\n");        
        System.out.printf("4 - Sair\n");        
      
        opcao = input.nextInt();        
        lerOpcaoMenuPrincipal(opcao);
    }
    
    public static void lerOpcaoMenuPrincipal(int retMenuPrincipal)
    {
        if (retMenuPrincipal == 1)
        {
            verificaSaldo();
        }else if (retMenuPrincipal == 2)
        {
            realizaSaque();
        }else  if (retMenuPrincipal == 3)
        {
            realizaDeposito();
        }else if (retMenuPrincipal == 4)
        {
            System.out.printf("Você digitou uma opção inválida: \n");
        }else if (retMenuPrincipal != 1 || retMenuPrincipal != 2 || retMenuPrincipal != 3 || retMenuPrincipal != 4)
        {
            System.out.printf("Você digitou uma opção inválida: \n");
            menuPrincipal();
        }
    }
    
    public static float verificaSaldo()
    {
       return opcao;
    }
    
    public static void realizaSaque()
    {
        
    }
    
    public static void realizaDeposito()
    {
        
    }
}
