package threads;
import static tela.Controladora.n;
import static tela.Controladora.filosofoslista;
import static tela.Controladora.mutex;
import static tela.Controladora.garfos;
import static tela.Controladora.j;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matricula: 201911534
Inicio...: 02 de junho de 2021
Alteracao: 05 de junho de 2021
Nome.....: Filosofo.java
Funcao...: Classe Filosofo, representado a thread de cada filosofo
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Filosofo extends Thread{

  //Variaveis do filosofo
  int id;
  Filosofo esquerda;
  Filosofo direita;
  private int velocidadepensar = 1000;
  private int velocidadecomer = 1500;
  private int estado = 0; //pensando
  public int getEstado() {
    return this.estado;
}

  public void run(){
    while(true){
      try {
        pensar();
        pegargarfo();
        comer();
        soltargarfos();
      } catch (InterruptedException e) {
      } //Fim do try catch
    } //Fim do while
  } //Fim do run

  /********************************************************************* 
  * Metodo: setEstado.
  * Funcao: Passa para o metodo garfoVisivel o estado atual do filosofo e seu id.
  * Parametros: Inteiro e, representando o estado do filosofo.
  * Retorno: void.
  ********************************************************************* */
  public void setEstado(int e) {
    estado = e;
    switch(estado){
      case 0:
        j.garfoVisivel(id, 0);
        break;
      case 1:
        j.garfoVisivel(id, 1);
        break;
      case 2:
        j.garfoVisivel(id, 2);
        break;
    } //Fim do switch
  } //Fim do metodo setEstado

  public Filosofo(int i){
    this.id = i;
  } //Fim do construtor Filosofo()

  /********************************************************************* 
  * Metodo: setVisinhos.
  * Funcao: Define, por meio de uma formula, o vizinho a esquerda e o visinho a direita do filosofo.
  * Parametros: Nenhum.
  * Retorno: void.
  ********************************************************************* */
  public void setVizinhos(){
    this.esquerda = filosofoslista[(this.id - 1 + n)%n];
    this.direita = filosofoslista[(this.id + 1 + n)%n];
  }  //Fim do metodo setVizinhos()

  /********************************************************************* 
  * Metodo: pensar.
  * Funcao: Para a thread por um determinado tempo.
  * Parametros: Nenhum.
  * Retorno: void.
  ********************************************************************* */
  public void pensar() throws InterruptedException{
    sleep(velocidadepensar);
  } //Fim do metodo pensar()
  
  /********************************************************************* 
  * Metodo: comer.
  * Funcao: Para a thread por um determinado tempo.
  * Parametros: Nenhum.
  * Retorno: void.
  ********************************************************************* */
  public void comer() throws InterruptedException{
    sleep(velocidadecomer);
  } //Fim do metodo comer()

  /********************************************************************* 
  * Metodo: pegargarfo.
  * Funcao: Metodo que acessa o semaphoro dos garfos para verificar se os garfos estao disponiveis com o metodo teste.
  * Parametros: Nenhum.
  * Retorno: void.
  ********************************************************************* */
  public void pegargarfo() throws InterruptedException{
    mutex.acquire();
    setEstado(1);
    testar(this);
    mutex.release();
    garfos[id].acquire();
  } //Fim do metodo pegargarfo()

  /********************************************************************* 
  * Metodo: soltargarfos
  * Funcao: Metodo que faz o filosofo voltar ao estado inicial e avisar os vizinhos que os semaphores estao disponiveis.
  * Parametros: Nenhum.
  * Retorno: void.
  ********************************************************************* */
  public void soltargarfos() throws InterruptedException{
    mutex.acquire();
    setEstado(0);
    testar(esquerda);
    testar(direita);
    mutex.release();    
  } //Fim do metodo soltargarfos()
  
  /********************************************************************* 
  * Metodo: testar
  * Funcao: Metodo para verificar se os vizinhos ja nao pegaram os garfos da esquerda e da direita do filosofo atual.
  * Parametros: Nenhum.
  * Retorno: void.
  ********************************************************************* */
  private void testar(Filosofo f){
    if(f.estado == 1 && f.esquerda.estado != 2 && f.direita.estado != 2){
      f.setEstado(2);
      garfos[f.id].release();
    } //Fim do if
  } //Fim do metodo testar()

  public int getVelocidadepensar() {
    return velocidadepensar;
  } //Fim do metodo getVelocidadepensar

  public void setVelocidadepensar(int velocidadepensar) {
    this.velocidadepensar = velocidadepensar;
  } //Fim do metodo getVelocidadepensar

  public int getVelocidadecomer() {
    return velocidadecomer;
  } //Fim do metodo getVelocidadecomer()

  public void setVelocidadecomer(int velocidadecomer) {
    this.velocidadecomer = velocidadecomer;
  } //Fim do metodo setVelocidadecomer
} //Fim da classe Filosofo