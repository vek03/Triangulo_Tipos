package ex4;

//importa todas as classes contidas em swing e awt
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Victor Cardoso
 * Vek Histories
 */

//sua classe herda da classe JFrame que contém todas as funções de interface
public class Ex4 extends JFrame
{
    //declarando objetos de rotulo
    JLabel rotulo1,rotulo2, rotulo3, exibir, titulo1;
    //declarando objetos de caixa de texto
    JTextField texto1,texto2, texto3;
    //declarando objeto botão de finalizar programa
    JButton calcular, limpar;
    
    //método construtor contendo todos os atributos da janela de interface
    public Ex4()
    {
        //função que chama a super classe do JFrame
        super("Identificar Triângulo");
        
        //Container é uma classe que contem todos os obejtos
        Container tela = getContentPane();
        
        //declara o layout como nulo para poder modificá-lo
        setLayout(null);
        
        //instancia de objetos com os valores predefinidos
        rotulo1 = new JLabel("Lado 1: ");
        rotulo2 = new JLabel("Lado 2: ");
        rotulo3 = new JLabel("Lado 3: ");
        exibir = new JLabel("");
        titulo1 = new JLabel("Identificar Triângulo");
        
        //instancia de objetos de caixa de texto com tamanho predefinido
        texto1 = new JTextField(15);
        texto2 = new JTextField(15);
        texto3 = new JTextField(15);
        
        //instancia do objeto botão para sair 
        calcular = new JButton("Verificar Tipo");
        limpar = new JButton("Limpar");
        
        //lugar da janela onde será impresso: margem direita, altura(de cima para baixo), tamanho em caracteres, grossura.  
        //legenda local
        titulo1.setBounds(125,20,200,20);
        rotulo1.setBounds(20,60,200,20);
        rotulo2.setBounds(20,90,200,20);
        rotulo3.setBounds(20,120,200,20);
        
        //resultado local
        exibir.setBounds(240,90,500,20);
        
        //caixa de texto local
        texto1.setBounds(70,61,70,20);
        texto2.setBounds(70,91,70,20);
        texto3.setBounds(70,121,70,20);
       
        //botões local
        calcular.setBounds(20,165,125,20);
        limpar.setBounds(160,165,100,20);
        
        titulo1.setFont(new Font("Arial", Font.BOLD, 17));
        
        //método para limpar caixas de texto
        limpar.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    exibir.setVisible(false);
                    texto1.setText(null);
                    texto2.setText(null);
                    texto3.setText(null);
                    texto1.requestFocus();//passa o foco para está caixa de texto
                }
            }
        );
        
        //método para calculkar a baskara
        calcular.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    double l1, l2, l3;
                    l1 = Double.parseDouble(texto1.getText());
                    l2 = Double.parseDouble(texto2.getText());
                    l3 = Double.parseDouble(texto3.getText());
                    exibir.setVisible(true);
                    
                    if(l1 == l2 && l2 == l3){
                    exibir.setText("Triângulo Equilátero");
                    }else
                     {
                        if(l1 == l2 || l2 == l3 || l3 == l1)
                        {
                            exibir.setText("Triângulo Isósceles");
                        } else
                          {
                              exibir.setText("Triângulo Escaleno");
                          }
                     }
                }
            }
        );
          
        
        //visibilidade do resultado apenas quando calculo for efetuado
        exibir.setVisible(false);
        
        //exibição de tudo
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(rotulo3);
        tela.add(exibir);
        tela.add(titulo1);
        
        tela.add(texto1);
        tela.add(texto2);
        tela.add(texto3);
        
        tela.add(calcular);
        tela.add(limpar);
        
        //declarando o tamanho em que a janela deve abrir
        setSize(450, 250);
        
        //visibilidade da janela
        setVisible(true);
        
        //define o local do monitor em que será aberta a janela
        setLocationRelativeTo(null);
    }
    
    //método main
    public static void main(String[] args) 
    {
        //intância de objeto(classe com os atributos)
        Ex4 app = new Ex4();
        //chamando a janela
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
