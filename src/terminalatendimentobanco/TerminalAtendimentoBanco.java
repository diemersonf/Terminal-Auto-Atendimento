package terminalatendimentobanco;

import java.util.Scanner;


public class TerminalAtendimentoBanco 
{
    public static Scanner input = new Scanner(System.in); //para leitura dos dados informados pelo usuário
    public static int conta; //guarda dados da conta
    public static String senha; //guarda dados da senha
    public static int opcao = 0; //guarda opção selecionada no menu 
    public static double saldo; //consulta saldo da conta
    public static int valorRetirada; //guarda o valor à ser sacado
    public static double saldoRet; //guarda o valor do saldo depois da retirada
    public static double valorDep; //guarda o valor a ser depositado
    public static double saldoDep; //guarda o saldo após feito o depósito
    public static double resto; //para análisar se digitou um multiplo da cédula que a máquina possui
    public static int opcaoSair; //verifica se volta ao menu principal ou sair do sistema
        
    public static void main(String[] args) //método de inicialização do sistema
    {   
        System.out.printf("Bem Vindo ao seu banco 24 horas.\n Tecle Enter para continuar...\n"); 
        solicitaDadosDaConta(); //método para captar as informações da conta      
    }  
    
    public static void solicitaDadosDaConta()
    {        
        System.out.printf("Insira o número de sua conta: \n");
        conta = input.nextInt();

        if (conta == 19358)
        {
            System.out.printf("Digite sua Senha de 6 números: \n");
            senha = input.next();
            
            if ("010512".equals(senha)) //senha em string pois possui zero como número inicial
            {
                menuPrincipal(); //chama o método de menu principal
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
    
    public static void menuPrincipal() //exibe tela de opões do sistema
    {
        System.out.printf("Bem Vindo ao menu principal. Digite a opção desejada.\n\n");
        System.out.printf("1 - Consulta Saldo\n");
        System.out.printf("2 - Saque\n");        
        System.out.printf("3 - Depósito\n");        
        System.out.printf("4 - Sair\n");        
      
        opcao = input.nextInt();        
        lerOpcaoMenuPrincipal(opcao);
    }
    
    public static void lerOpcaoMenuPrincipal(int retMenuPrincipal) //executa a opção escolhida pelo usuário
    {
        if (retMenuPrincipal == 1)
        {
            verificaSaldo();
            System.out.printf("Seu saldo atual é de: %.2f\n\n", saldo);  
            fimDeLanc();
        }else if (retMenuPrincipal == 2)
        {
            realizaSaque();
            fimDeLanc();
        }else  if (retMenuPrincipal == 3)
        {
            realizaDeposito();
            System.out.printf("Seu saldo atual é de: %.2f\n", saldoDep);
            fimDeLanc();
        }else if (retMenuPrincipal == 4)
        {
            sairSistema();
        }else if (retMenuPrincipal != 1 || retMenuPrincipal != 2 || retMenuPrincipal != 3 || retMenuPrincipal != 4)
        {
            System.out.printf("Você digitou uma opção inválida: \n");
            menuPrincipal();
        }
    }
    
    public static double verificaSaldo() //faz o select no banco de dados e retorna o saldo para o cliente
    {
        saldo = 632.50;
        return saldo;
    }
    
    public static void realizaSaque() //método para realização de saques
    {
        System.out.printf("Estamos com cédulas de R$ 10,00\nDigite o valor que deseja retirar.\n");
        valorRetirada = input.nextInt();
        
        resto = valorRetirada % 10;
        
        if(resto != 0) //verifica se o valor digitado é correspondente com as cédulas que estão na máquina
        {
            System.out.printf("O valor do saque deverá ser multiplo de R$ 10,00. Tente novamente!!!\n");
            realizaSaque();
        } else
        {
            saldo = verificaSaldo();
            saldoRet = saldo - valorRetirada;
            System.out.printf("Saldo Anterior: %.2f\nVocê sacou:%d\nSeu saldo atual é de: %.2f\n", saldo, valorRetirada, saldoRet);
        }
    }
    
    public static double realizaDeposito() //método para realizar o depósito na conta
    {
        System.out.printf("Lembramos que são aceitos apenas notas em papel...\n\nInforme o valor que deseja depositar:");
        valorDep = input.nextDouble();
        
        saldo = verificaSaldo();
        saldoDep = saldo + valorDep;
        
        return saldoDep;
    }
    
    public static void sairSistema()
    {
        System.out.println("Obrigado por usar nossos serviços.");
        System.exit(0);
    }
    
    public static void fimDeLanc() //método para verificar se retorna ao menu, após fazer uma transação
    {                    
            System.out.printf("Para voltar ao menu inicial digite 1, para sair digite qualquer tecla\n");
            opcaoSair = input.nextInt();
            
            if (opcaoSair == 1)
            {
                menuPrincipal();
            } else sairSistema();
    }
}
