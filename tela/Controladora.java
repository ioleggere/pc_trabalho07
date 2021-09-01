package tela;
import java.util.concurrent.Semaphore;
import threads.Filosofo;
import threads.Jantar;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 02 de junho de 2021
Alteracao: 05 de junho de 2021
Nome.....: Controladora.java
Funcao...: Classe de controle, onde o que aparece na tela e os processos sao controlados.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Controladora {
  //Tela
  public static JFrame janela = new JFrame("Jantar dos Udyr's");
  private JLabel fundo = new JLabel();

  //Imagem dos garfos
  public static JLabel garfo1 = new JLabel();
  public static JLabel garfo2 = new JLabel();
  public static JLabel garfo3 = new JLabel();
  public static JLabel garfo4 = new JLabel();
  public static JLabel garfo5 = new JLabel();
  public static JLabel garfo6 = new JLabel();
  public static JLabel garfo7 = new JLabel();
  public static JLabel garfo8 = new JLabel();
  public static JLabel garfo9 = new JLabel();
  public static JLabel garfo10 = new JLabel();

  //Textos
  public static JTextField fenix = new JTextField("Hmmm, uga pensante uga");
  public static JTextField tartaruga = new JTextField("Hmmm, uga pensante uga");
  public static JTextField urso = new JTextField("Hmmm, uga pensante uga");
  public static JTextField tigre = new JTextField("Hmmm, uga pensante uga");
  public static JTextField guardiao = new JTextField("Hmmm, uga pensante uga");

  public static JTextField pensar1 = new JTextField("Tempo para Pensar");
  public static JTextField comer1 = new JTextField("Tempo para comer");

  public static JTextField pensar2 = new JTextField("Tempo para Pensar");
  public static JTextField comer2 = new JTextField("Tempo para comer");

  public static JTextField pensar3 = new JTextField("Tempo para Pensar");
  public static JTextField comer3 = new JTextField("Tempo para comer");

  public static JTextField pensar4 = new JTextField("Tempo para Pensar");
  public static JTextField comer4 = new JTextField("Tempo para comer");

  public static JTextField pensar5 = new JTextField("Tempo para Pensar");
  public static JTextField comer5 = new JTextField("Tempo para comer");

  //Silders
  private JSlider velpensar1 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);
  private JSlider velcomer1 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);

  private JSlider velpensar2 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);
  private JSlider velcomer2 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);

  private JSlider velpensar3 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);
  private JSlider velcomer3 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);

  private JSlider velpensar4 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);
  private JSlider velcomer4 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);

  private JSlider velpensar5 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);
  private JSlider velcomer5 = new JSlider(JSlider.HORIZONTAL, 10, 30, 20);

  //Fontes
  String family = "Impact";
  int style = Font.PLAIN;
  int size = 13;
  Font f = new Font(family, style, size);

  String family2 = "Arial";
  int style2 = Font.PLAIN;
  int size2 = 9;
  Font f2 = new Font(family2, style2, size2);

  //Variaveis do problema
  public static int n = 5; //Numero de filosofos
  public static Filosofo[] filosofoslista = new Filosofo[n];
  public static Semaphore mutex = new Semaphore(1);
  public static Semaphore[] garfos = new Semaphore[n];
  public static Jantar j = new Jantar(); //Thread do jantar
  public Controladora(){

    //Configuracoes da janela
    janela.setSize(500,500);
    janela.setResizable(false);
    janela.setLocationRelativeTo(null);
    janela.setVisible(true);
    janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
    janela.getContentPane().setLayout(null);
    
    //Configuracoes do fundo
    fundo = new JLabel(new ImageIcon(getClass().getResource("/img/fundoudi.png")));
    fundo.setSize(400,400);
    
    //Configuracoes dos textos
    fenix.setEditable(false);
    tartaruga.setEditable(false);
    urso.setEditable(false);
    tigre.setEditable(false);
    guardiao.setEditable(false);

    comer1.setFont(f2);
    pensar1.setFont(f2);

    comer2.setFont(f2);
    pensar2.setFont(f2);

    comer3.setFont(f2);
    pensar3.setFont(f2);

    comer4.setFont(f2);
    pensar4.setFont(f2);

    comer5.setFont(f2);
    pensar5.setFont(f2);

    //Configurando garfos
    garfo1 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo2 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo3 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo4 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo5 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo6 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo7 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo8 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo9 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));
    garfo10 = new JLabel(new ImageIcon(getClass().getResource("/img/garfoo.png")));

    //Configuracoes do primeiro
    garfo1.setBounds(10,25, 140,110); //60 no x 20 no y
    garfo2.setBounds(10,25, 280, 112);
    fenix.setBounds(60, 9, 120, 20);
    pensar1.setBounds(170,59,85,15);
    velpensar1.setBounds(170,75,40,10);
    comer1.setBounds(170,85,85,15);
    velcomer1.setBounds(170,100,40,10);

    //Configuracoes do segundo filosofo
    garfo3.setBounds(10,25, 500, 100);
    garfo4.setBounds(10,25, 610, 100);
    tartaruga.setBounds(240,11, 120, 20);
    pensar2.setBounds(330,59,85,15);
    velpensar2.setBounds(330,75,40,10);
    comer2.setBounds(330,85,85,15);
    velcomer2.setBounds(330,100,40,10);

    //Configuracoes do terceiro filosofo
    garfo5.setBounds(10,25, 540, 370);
    garfo6.setBounds(10,25, 690, 370);
    tigre.setBounds(270,140,120,20);
    pensar3.setBounds(380,220,85,15);
    velpensar3.setBounds(380,240,40,10);
    comer3.setBounds(380,255,85,15);
    velcomer3.setBounds(380,270,40,10);

    //Configuracoes do quarto filosofo
    garfo7.setBounds(10,25, 320, 540);
    garfo8.setBounds(10,25, 450, 540);
    guardiao.setBounds(140,370,120,20);
    pensar4.setBounds(260,310,85,15);
    velpensar4.setBounds(260,330,40,10);
    comer4.setBounds(260,350,85,15);
    velcomer4.setBounds(260,370,40,10);

    //Configuracoes do quinto filosofo
    garfo9.setBounds(10,25, 60, 390);
    garfo10.setBounds(10,25, 210, 390);
    urso.setBounds(20,150,120, 20);
    pensar5.setBounds(30,300,85,15);
    velpensar5.setBounds(30,320,40,10);
    comer5.setBounds(30,340,85,15);
    velcomer5.setBounds(30,360,40,10);
    
    //Configuracoes extras
    fenix.setFont(f);
    tartaruga.setFont(f);
    tigre.setFont(f);
    guardiao.setFont(f);
    urso.setFont(f);
    garfo1.setVisible(false);
    garfo2.setVisible(false);
    garfo3.setVisible(false);
    garfo4.setVisible(false);
    garfo5.setVisible(false);
    garfo6.setVisible(false);
    garfo7.setVisible(false);
    garfo8.setVisible(false);
    garfo9.setVisible(false);
    garfo10.setVisible(false);

    //Adicionando os elementos na tela
    fundo.add(garfo1);
    fundo.add(garfo2);
    fundo.add(garfo3);
    fundo.add(garfo4);
    fundo.add(garfo5);
    fundo.add(garfo6);
    fundo.add(garfo7);
    fundo.add(garfo8);
    fundo.add(garfo9);
    fundo.add(garfo10);
    fundo.add(urso);
    fundo.add(tigre);
    fundo.add(fenix);
    fundo.add(tartaruga);
    fundo.add(guardiao);
    janela.add(comer1);
    janela.add(pensar1);
    janela.add(velcomer1);
    janela.add(velpensar1);
    janela.add(comer2);
    janela.add(pensar2);
    janela.add(velcomer2);
    janela.add(velpensar2);
    janela.add(comer3);
    janela.add(pensar3);
    janela.add(velcomer3);
    janela.add(velpensar3);
    janela.add(comer4);
    janela.add(pensar4);
    janela.add(velcomer4);
    janela.add(velpensar4);
    janela.add(comer5);
    janela.add(pensar5);
    janela.add(velcomer5);
    janela.add(velpensar5);
    janela.add(fundo);
    janela.repaint();

    //Criando os semaforos e filosofos automaticamente
    for(int i = 0; i < n; i++){
      filosofoslista[i] = new Filosofo(i);
      garfos[i] = new Semaphore(0);
    } //Fim do for

    //Configurando os vizinhos de cada filosofo
    for(int i = 0; i < n; i++){
      filosofoslista[i].setVizinhos();
    } //Fim do for

    j.start(); //Iniciando a Thread do jantar

    //Configuracoes das acoes dos sliders
    velcomer1.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecomer1 = velcomer1.getValue() + 1;
        filosofoslista[0].setVelocidadecomer(velocidadecomer1 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velpensar1.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadepensar1 = velpensar1.getValue() + 1;
        filosofoslista[0].setVelocidadepensar(velocidadepensar1 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener
    
    velcomer2.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecomer2 = velcomer2.getValue() + 1;
        filosofoslista[1].setVelocidadecomer(velocidadecomer2 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velpensar2.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadepensar2 = velpensar2.getValue() + 1;
        filosofoslista[1].setVelocidadepensar(velocidadepensar2 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velcomer3.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecomer3 = velcomer3.getValue() + 1;
        filosofoslista[2].setVelocidadecomer(velocidadecomer3 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velpensar3.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadepensar3 = velpensar3.getValue() + 1;
        filosofoslista[2].setVelocidadepensar(velocidadepensar3 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velcomer4.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecomer4 = velcomer4.getValue() + 1;
        filosofoslista[3].setVelocidadecomer(velocidadecomer4 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velpensar4.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadepensar4 = velpensar4.getValue() + 1;
        filosofoslista[3].setVelocidadepensar(velocidadepensar4 * 100);
      } //Fim do stateChanged
       
    }); //Fim do ChangeListener

    velcomer5.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadecomer5 = velcomer5.getValue() + 1;
        filosofoslista[4].setVelocidadecomer(velocidadecomer5 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener

    velpensar5.addChangeListener(new ChangeListener(){

      @Override
      public void stateChanged(ChangeEvent e) {
        int velocidadepensar5 = velpensar5.getValue() + 1;
        filosofoslista[4].setVelocidadepensar(velocidadepensar5 * 100);
      } //Fim do stateChanged
      
    }); //Fim do ChangeListener
  } //Fim do construtor Controladora()  
} //Fim da classe Controladora
