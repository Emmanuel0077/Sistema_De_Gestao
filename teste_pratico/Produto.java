
package emmanuel.teste_pratico;

import java.util.LinkedList;
import java.util.Scanner;


public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    
    
    public Produto(){//construtor vazio para possibilitar o instanciamento do objecto na classe main
        
    }
    
    public Produto(String n, double pc, int qtd){//construtor com os paramentros que o objecto vai receber
        this.setnome(n);
        this.setpreco(pc);
        this.setquantidade(qtd);
    }
    
    
    LinkedList<Produto>lista = new LinkedList();// lista ligada, que vai conter os produtos
    
    
    //Getters e setters
    public void setnome(String n){
        nome = n;
    }
    public String getnome(){
        return nome;
    }
    public void setpreco(double p){
        preco = p;
    }
    public double getpreco(){
        return preco;
    }
    public void setquantidade(int qt){
        quantidade = qt;
    }
    public int getquantidade(){
        return quantidade;
    }
    
    public void Menu(){//Metodo para exibicao do menu de opcoes 
        System.out.println(" "+'\n'+"1 - Registar um novo produto" + '\n' + "2 - Editar um produto existente" + '\n' + "3 - Remover um produto existente"+ '\n' + "4 - Consultar o estoque actual" + '\n' + "5 - Registar uma nova venda" + '\n' + "6 - Sair");
    }
    
    public void Registar(){//Metodo para registar um produto,gravando os dados em um objecto do tipo Produto
        int i =1;
        Scanner in = new Scanner(System.in);
        do{   
        System.out.println("Insira o nome do produto: ");
        String name = in.next();
        System.out.println("Insira o preço do produto: ");
        double pc = in.nextDouble();
        System.out.println("Insira a quantidade do produto: ");
        int qt = in.nextInt();
        Produto pt = new Produto(name, pc, qt);//Instanciamento de um objecto do tipo produto com os atributos colhidos pelo teclado
        lista.add(pt);// Adiciona cada produto registado a lista ligada
        System.out.println("Registado com sucesso");
        System.out.println("1 - Registar outro produto" + '\n' + "2 - voltar ao menu inicial");
        i = in.nextInt();
        }while(i==1);
    }
    
    public String toString(){
        return "Nome do Produto: " + this.getnome() + " |Preço do Produto: " + this.getpreco() + " |Quantidade do Produto: " + this.getquantidade();
    }
    
    public void Lista_Produtos(){//metodo para mostrar a lista de produtos
        if(lista.isEmpty()){//Verifica se a lista esta vazia
            System.out.println("Estoque vazio!"); 
        }else{
            Produto pt;
        for(int i = 0; i < lista.size(); i++){
            pt = (Produto)lista.get(i);
            System.out.println((i+1) + " - "+pt.toString());   
        }
        }
        
    }
    
    public void Editar(){
           
        if (!lista.isEmpty()){//Verifica se a lista esta vazia
            Scanner in = new Scanner(System.in);
            Produto pt = new Produto();
            int j;
            for(j = 0; j < lista.size(); j++){//loop para imprimir a lista para que a peesoa possa escolher qual produto vai editar
                pt = (Produto)lista.get(j);
                System.out.println((j+1) + " - "+pt.toString());   
            }
            System.out.println(" " + '\n' + "Insira o numero do produto que deseja editar");
            int x = in.nextInt();
            int i;
            x=(x-1);
            for(i=0;i<lista.size();i++){
                lista.get(i);
                if (x==i && x<=lista.size()){// faz match entre a posicao do objecto na lista e a opcao selecionada
                    System.out.println("Insira o novo nome do produto: ");
                    String n= in.next();
                    System.out.println("Insira o novo preço do produto: ");
                    double p = in.nextDouble();
                    System.out.println("Insira a nova quantidade do produto: ");
                    int q = in.nextInt();
                    Produto ptx= new Produto(n,p,q);//criacao de novo objecto do tipo Produto que vai receber os novos atributos
                    lista.set(i, ptx);//insercao do objecto na posicao escolhida
                    System.out.println(" "+ '\n' + "Actualizado com sucesso");
                }
                
            }
        }else{
            System.out.println("O estoque esta vazio!");
        }
    }
    
    public void Remover(){//metodo para remover algum produto da lista
        if (!lista.isEmpty()){//Verifica se a lista esta vazia
            Scanner in = new Scanner(System.in);
        Produto pt = new Produto();
        int i;
        for(i = 0; i < lista.size(); i++){//loop para exibir a lista de produtos existentes
            pt = (Produto)lista.get(i);
            System.out.println((i+1) + " - "+pt.toString());   
        }
        System.out.println(" " + '\n' + "Insira o numero do produto que deseja remover");
            int x = in.nextInt();
            x=(x-1);
            for(i=0;i<lista.size();i++){  
                if (x==i && x<=lista.size()){
                    lista.get(i);
                    System.out.println(" "+ '\n' + "Removido com sucesso");
                    System.out.println(" ");
                    lista.remove(i);//metodo para remover o objecto na posicao selecionada
                }
                
            }
        }else{
            System.out.println("O estoque esta vazio!");
        }
    }
    

    public void Registar_Venda(){
           
        if (!lista.isEmpty()){//Verifica se a lista esta vazia
             Scanner in = new Scanner(System.in);
            Produto pt = new Produto();
            int j;
            for(j = 0; j < lista.size(); j++){//loop para imprimir a lista para que a peesoa possa escolher qual produto vai editar
                pt = (Produto)lista.get(j);
                System.out.println((j+1) + " - "+pt.toString());   
            }
            System.out.println(" " + '\n' + "Insira o numero do produto que foi vendido");
            int x = in.nextInt();
            int i=0; 
            x=(x-1);
            for(Produto Y: lista){
                Produto pd=lista.get(x);
                if (x==i && x<=lista.size()){// faz match entre a posicao do objecto na lista e a opcao selecionada
                    System.out.println("Insira a quantidade do produto vendido: ");
                    int q = in.nextInt();
                    if(q<=pd.getquantidade()){//Verifica se a quantidade inserida é superior ao estoque
                        q=(pd.getquantidade()-q);//Reduz a quantidade vendida no estoque
                        
                        pd.setquantidade(q);//Redefinicao da nova quantidade
                        System.out.println(" "+ '\n' + "Venda registada com sucesso");
                        break;
                    }else{
                        System.out.println("Quantidade superior ao estoque");
                    }  
                }else{
                    i++;
                }
            }
        }else{
            System.out.println("O estoque esta vazio!");
        }  
    }
    
}

