package threads;
import static tela.Controladora.filosofoslista;
import static tela.Controladora.janela;
import static tela.Controladora.garfo1;
import static tela.Controladora.garfo2;
import static tela.Controladora.garfo3;
import static tela.Controladora.garfo4;
import static tela.Controladora.garfo5;
import static tela.Controladora.garfo6;
import static tela.Controladora.garfo7;
import static tela.Controladora.garfo8;
import static tela.Controladora.garfo9;
import static tela.Controladora.garfo10;
import static tela.Controladora.fenix;
import static tela.Controladora.urso;
import static tela.Controladora.tigre;
import static tela.Controladora.tartaruga;
import static tela.Controladora.guardiao;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 02 de junho de 2021
Alteracao: 05 de junho de 2021
Nome.....: Jantar.java
Funcao...: Classe jantar, onde os filosofos vao ser iniciados e a tela sera repintada a cada acao.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Jantar extends Thread{
  private String pensando = "Hmmm, uga pensante uga";
  private String fome = "Uga uga fome uga";
  private String comendo = "Uga uga delicia uga";
  public void run() {

    //Iniciando as threads dos filosofos
    filosofoslista[0].start();
    filosofoslista[1].start();
    filosofoslista[2].start();
    filosofoslista[3].start();
    filosofoslista[4].start();
    while(true){
       try {
          sleep(1250);
          janela.repaint();
        } catch (InterruptedException ie){

        }//Fim do try catch
      } //Fim do while
  } //Fim do run

  /********************************************************************* 
  * Metodo: garfoVisivel.
  * Funcao: Muda o estado de cada filosofo de acordo com seus estados e sleep, alem dos garfos disponiveis.
  * Parametros: id do filosofo, estado do filosofo.
  * Retorno: void.
  ********************************************************************* */
  public void garfoVisivel(int id, int estado){
    switch(id){
      case 0:
        switch(estado){
          case 0:
            garfo1.setVisible(false);
            garfo2.setVisible(false);
            fenix.setText(pensando);
            break;
          case 1:
            fenix.setText(fome);
            break;
          case 2:
            garfo1.setVisible(true);
            garfo2.setVisible(true);
            fenix.setText(comendo);
            break;
        }
      break;
      case 1:
        switch(estado){
          case 0:
            garfo3.setVisible(false);
            garfo4.setVisible(false);
            tartaruga.setText(pensando);
            break;
          case 1:
            tartaruga.setText(fome);
            break;
          case 2:
            garfo3.setVisible(true);
            garfo4.setVisible(true);
            tartaruga.setText(comendo);
            break;
        }
      break;
      case 2:
        switch(estado){
          case 0:
            garfo5.setVisible(false);
            garfo6.setVisible(false);
            tigre.setText(pensando);
            break;
          case 1:
            tigre.setText(fome);
            break;
          case 2:
            garfo5.setVisible(true);
            garfo6.setVisible(true);
            tigre.setText(comendo);
            break;
      }
      break;
      case 3:
        switch(estado){
          case 0:
            garfo7.setVisible(false);
            garfo8.setVisible(false);
            guardiao.setText(pensando);
            break;
          case 1:
            guardiao.setText(fome);
            break;
          case 2:
            garfo7.setVisible(true);
            garfo8.setVisible(true);
            guardiao.setText(comendo);
            break;
      }
      break;
      case 4:
        switch(estado){
          case 0:
            garfo9.setVisible(false);
            garfo10.setVisible(false);
            urso.setText(pensando);
            break;
          case 1:
            urso.setText(fome);
            break;
          case 2:
            garfo9.setVisible(true);
            garfo10.setVisible(true);
            urso.setText(comendo);
            break;
      }
      break;
    }
    janela.repaint();
  } //Fim do metodo garfoVisivel()
} //Fim da classe Jantar
