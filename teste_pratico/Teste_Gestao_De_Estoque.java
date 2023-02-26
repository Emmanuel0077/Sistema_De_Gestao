
package emmanuel.teste_pratico;

import java.util.Scanner;



public class Teste_Gestao_De_Estoque {
    public static void main(String[] Emmanuel) {
        Scanner in = new Scanner(System.in);
        Produto pdt = new Produto();
        pdt.Menu();//metodo para exibir o menu
        int escolha; 
        do{
            escolha = in.nextInt();
            if (escolha==1 ||escolha ==2||escolha==3 ||escolha ==4||escolha==5 ||escolha ==6){//Verifica se o input corresponde às opcoes do menu 
                if(escolha==1){
                    pdt.Registar();//Chama o metodo para registar novo produto
                    pdt.Menu();
                    }
            
                    if(escolha==2){
                    pdt.Editar();//Chama o metodo para editar um produto existente
                    pdt.Menu();
                    }
            
                    if(escolha==3){
                    pdt.Remover();//Chama o metodo para remover um produto existente
                    pdt.Menu();
                    }
            
                    if(escolha==4){
                    pdt.Lista_Produtos();//Chama o metodo para exibir a lista de produtos
                    pdt.Menu();
                    }
            
                    if(escolha==5){
                    pdt.Registar_Venda();//Chama o metodo para registar nova venda
                    pdt.Menu();
                    }
            
                    if(escolha==6){
                    System.out.println("Concluido");
                    }
            }else{
                System.out.println("Opcao Invalida"+'\n'+"Tente novamente"); break;
                
            }
            
        
        }while(escolha!=6);
        
        
    }
    
    // Utilizei uma sequencia de if's porque tive alguns bugs com o switch case :)
    
}
