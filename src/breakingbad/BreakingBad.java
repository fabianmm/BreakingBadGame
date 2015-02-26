/**
 * TareaBreakingBad
 *
 * Juego en el que una bolita rebota con una barra que mueve el jugador, con el
 * fin de destruir los cuadros de arriba.
 *
 * @author Mauro Amarante (A00191903) and Fabian Montemayor (A01280156)
 * @version 1.0
 * @date 2015/2/25
 */

package breakingbad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JFrame;

public class BreakingBad extends JFrame implements KeyListener, MouseListener, 
                                                        Runnable{
    /* Declaración de Variables */
    private static final int iWIDTH = 900;  // ancho del JFrame
    private static final int iHEIGHT = 650; // alto del JFrame
    private int iScore;     // puntos del juego
    private int iVidas;     // vidas del juego
    private boolean bLose;  // boleana de perdida de juego
    private Base basBarra;  // barra del juego
    private Base basBola;   // bola del juego
    private Base basBotonPlay;  //boton para inciar el juego
    private Base basBotonHigh;  //boton para highscores
    private Base basBotonInst;  //boton para ver las instrucciones
    private int iBallXSpeed; // velocidad X de la bola
    private int iBallYSpeed; // velocidad Y de la bola
    private int iDireccion; // direccion de la barra (1- izquierda, 2 derecha)
    private boolean bPause; // boleana para pausa
    private boolean bMove;  // boleana de movimiento de la barra
    private boolean bPlay;  //booleana para iniciar el juego
    private int iNivel; // nivel del juego 
    private LinkedList<Base> lklDrogas; //Lista de objetos de la clase Animacion
    private Animacion aniPortada;   // Imagen portada
    private int iPortada;  // contador de portada
    private Image    imaImagenJFrame;   // Imagen a proyectar en JFrame
    private Graphics graGraficaJFrame;  // Objeto grafico de la Imagen
    private int iContadorBarra; // contador de la barra
    private long lTiempoActual; // tiempo actual
    private long lTiempoInicial;    // tiempo inicial
    private int iContadorBloque;    // contador de animacion del bloque
    private int iCantidadBloques;   // cantidad de bloques destruidos
    private boolean bRestart;   // boleana para volver a empezar
    
    /** 
     * BreakingBad
     * 
     * Constructor de la clase <code>BreakingBad</code>.<P>
     * Define la apariencia y funcionalidad del JFrame.
     * Crea e inicializa las variables de la clase 
     * <code>BreakingBad</code>
     * 
     */
    
    public BreakingBad() {
        // inicializa score en 0
        iScore = 0;
        
        // inicializa vidas en 3
        iVidas = 3;
        
        //inicia el contador del bloque en 0
        iContadorBloque = 0;
        
        // inicializa la boleana en falso
        bLose = false;
        
        // inicializa la direccion en 0
        iDireccion = 0;
        
        // inicializa la boleana de pausa en falso
        bPause = false;
        
        // inicializa boleana de movimiento en falso
        bMove = false;
        
        // inicializa la boleana para volver a empezar en falso
        bRestart = false;
        
        // inicializa en 450
        iPortada = 460;
        
        // el juego no inicia hasta presionar el boton del menu
        bPlay = false;

        // inicializa la cantidad de bloques destruidos en 0
        iCantidadBloques = 0;
        
        // se inicializa en nivel 1
        iNivel = 1;
        
        // se inicializa la bola y sus velocidades
        iBallYSpeed = 5;
        iBallXSpeed = 5;
        URL urlImagenBola = this.getClass().getResource("imagenes/bolaOso.png");
        basBola = new Base(0, 0, 
                Toolkit.getDefaultToolkit().getImage(urlImagenBola));
        iContadorBarra = 0;
        
        // reposicionar la bola en medio
        basBola.setX(iWIDTH / 2);
        basBola.setY(580);
        
        // se inicializa la barra
        URL urlImagenBarra = this.getClass().getResource("imagenes/barra.png");
        basBarra = new Base(iWIDTH / 2 - 75, 600, 
                Toolkit.getDefaultToolkit().getImage(urlImagenBarra));
        
        //Se cargan las imágenes(cuadros) para la animación de la portada
        Image portada1 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro1.png"));
        Image portada2 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro2.png"));
        Image portada3 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro3.png"));
        Image portada4 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro4.png"));
        Image portada5 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro5.png"));
        Image portada6 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro6.png"));
        Image portada7 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro7.png"));
        Image portada8 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro8.png"));
        Image portada9 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro9.png"));
        Image portada10 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro10.png"));
        Image portada11 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro11.png"));
        Image portada12 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro12.png"));
        Image portada13 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro13.png"));
        Image portada14 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro14.png"));
        Image portada15 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro15.png"));
        Image portada16 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro16.png"));
        Image portada17 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro17.png"));
        Image portada18 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro18.png"));
        Image portada19 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro19.png"));
        Image portada20 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro20.png"));
        Image portada21 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro21.png"));
        Image portada22 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro22.png"));
        Image portada24 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro24.png"));
        Image portada25 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro25.png"));
        Image portada26 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro26.png"));
        Image portada27 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro27.png"));
        Image portada28 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro28.png"));
        Image portada29 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro29.png"));
        Image portada30 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro30.png"));
        Image portada31 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro31.png"));
        Image portada32 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/intro32.png"));
        
        //Se crea la animación de la portada
        aniPortada = new Animacion();
	aniPortada.sumaCuadro(portada1, 500);
        aniPortada.sumaCuadro(portada2, 300);
        aniPortada.sumaCuadro(portada3, 300);
        aniPortada.sumaCuadro(portada4, 300);
        aniPortada.sumaCuadro(portada5, 300);
        aniPortada.sumaCuadro(portada6, 300);
        aniPortada.sumaCuadro(portada7, 300);
        aniPortada.sumaCuadro(portada8, 300);
        aniPortada.sumaCuadro(portada9, 2000);
        aniPortada.sumaCuadro(portada10, 200);
        aniPortada.sumaCuadro(portada11, 200);
        aniPortada.sumaCuadro(portada12, 200);
        aniPortada.sumaCuadro(portada13, 200);
        aniPortada.sumaCuadro(portada14, 1000);
        aniPortada.sumaCuadro(portada15, 200);
        aniPortada.sumaCuadro(portada16, 200);
        aniPortada.sumaCuadro(portada17, 200);
        aniPortada.sumaCuadro(portada18, 200);
        aniPortada.sumaCuadro(portada19, 300);
        aniPortada.sumaCuadro(portada20, 300);
        aniPortada.sumaCuadro(portada21, 300);
        aniPortada.sumaCuadro(portada22, 300);
        aniPortada.sumaCuadro(portada24, 300);
        aniPortada.sumaCuadro(portada25, 300);
        aniPortada.sumaCuadro(portada26, 300);
        aniPortada.sumaCuadro(portada27, 300);
        aniPortada.sumaCuadro(portada28, 200);
        aniPortada.sumaCuadro(portada29, 200);
        aniPortada.sumaCuadro(portada30, 200);
        aniPortada.sumaCuadro(portada31, 200);
        aniPortada.sumaCuadro(portada32, 200);
        
        // se cargan las imagenes de la animacion de los bricks
        Image imaBrick1 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick1.png"));
        Image imaBrick2 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick2.png"));
        Image imaBrick3 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick3.png"));
        Image imaBrick4 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick4.png"));
        Image imaBrick5 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick5.png"));
        Image imaBrick6 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick6.png"));
        Image imaBrick7 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick7.png"));
        Image imaBrick8 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick8.png"));
        Image imaBrick9 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick9.png"));
        Image imaBrick10 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick10.png"));
        Image imaBrick11 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick11.png"));
        Image imaBrick12 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick12.png"));
        Image imaBrick13 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick13.png"));
        Image imaBrick14 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick14.png"));
        Image imaBrick15 = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("imagenes/fotobrick15.png"));

        // crea la animacion del brick
        Animacion aniBrick = new Animacion();
        aniBrick.sumaCuadro(imaBrick1, 50);
        aniBrick.sumaCuadro(imaBrick2, 50);
        aniBrick.sumaCuadro(imaBrick3, 50);
        aniBrick.sumaCuadro(imaBrick4, 50);
        aniBrick.sumaCuadro(imaBrick5, 50);
        aniBrick.sumaCuadro(imaBrick6, 50);
        aniBrick.sumaCuadro(imaBrick7, 50);
        aniBrick.sumaCuadro(imaBrick8, 50);
        aniBrick.sumaCuadro(imaBrick9, 50);
        aniBrick.sumaCuadro(imaBrick10, 50);
        aniBrick.sumaCuadro(imaBrick11, 50);
        aniBrick.sumaCuadro(imaBrick12, 50);
        aniBrick.sumaCuadro(imaBrick13, 50);
        aniBrick.sumaCuadro(imaBrick14, 50);
        aniBrick.sumaCuadro(imaBrick15, 50);
        
        // crea los cuadros
        lklDrogas = new LinkedList();
        
        // posiciones de los cuadros
        int iPosX = 5;
        int iPosY = 35;
        
        // se posicionan y agregan a la lista cada uno de los cuadros
        for (int iI = 1; iI <= 27; iI++) {
            Base basDroga = new Base(iPosX, iPosY, 
                    imaBrick1, aniBrick);
            iPosX += 100;
            if (iI % 9 == 0) {
                iPosX = 5;
                iPosY += 55;
            }
            lklDrogas.add(basDroga);
        }
        
        //Definir imagenen para boton play
	URL urlImagenBotonPlay = this.getClass()
                                        .getResource("imagenes/botonPlay.png");
        
        //se crea el objeto para boton play
	basBotonPlay = new Base(0, 0,
                	Toolkit.getDefaultToolkit().getImage(urlImagenBotonPlay));
        
        // se posiciona el boton
 	iPosX = (iWIDTH / 2) - (basBotonPlay.getAncho() / 2);    
        iPosY = (iHEIGHT / 2) - (basBotonPlay.getAlto() / 2);
        
        basBotonPlay.setX(iPosX);
        basBotonPlay.setY(iPosY + 20);
        
        //Definir imagenen para boton Highscores
	URL urlImagenBotonHigh = this.getClass()
                                        .getResource("imagenes/botonHigh.png");
        
        //se crea el objeto para boton highscires
	basBotonHigh = new Base(0, 0,
                	Toolkit.getDefaultToolkit().getImage(urlImagenBotonHigh));
        
        // se posiciona el boton
 	iPosX = (iWIDTH / 2) - (basBotonHigh.getAncho() / 2);    
        iPosY = (iHEIGHT / 2) - (basBotonHigh.getAlto() / 2);
        
        basBotonHigh.setX(iPosX + 250);
        basBotonHigh.setY(iPosY + 20);
        
        //Definir imagenen para boton instruccion
	URL urlImagenBotonInst = this.getClass()
                                        .getResource("imagenes/botonInst.png");
        
        //se crea el objeto para boton instrucciones
	basBotonInst = new Base(0, 0,
                	Toolkit.getDefaultToolkit().getImage(urlImagenBotonInst));
        
        // se posiciona el boton
 	iPosX = (iWIDTH / 2) - (basBotonInst.getAncho() / 2);    
        iPosY = (iHEIGHT / 2) - (basBotonInst.getAlto() / 2);
        
        basBotonInst.setX(iPosX - 250);
        basBotonInst.setY(iPosY + 20);
        
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
        
        addKeyListener(this); // se escucha el teclado
        addMouseListener(this); //se escucha al mouse
    }
    
    /** 
     * run
     * 
     * Metodo sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, que contendrá las instrucciones
     * de nuestro juego.
     * 
     */
    public void run() {
        //Guarda el tiempo actual del sistema
        lTiempoActual = System.currentTimeMillis();
        /* mientras dure el juego, se actualizan posiciones de jugadores
           se checa si hubo colisiones para desaparecer jugadores o corregir
           movimientos y se vuelve a pintar todo
        */ 
        while (iVidas > 0) {
            if (!bPause) {
                actualiza();
                checaColision();             
            }
            repaint();
            try {
                // El thread se duerme
                Thread.sleep(20);
            }
            catch (InterruptedException iexError) {
                System.out.println("Hubo un error en el juego " + 
                        iexError.toString());
            }
        }
    }

    /** 
     * actualiza
     * 
     * Metodo que actualiza la posicion de los objetos 
     * 
     */
    public void actualiza() {
    //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
         long lTiempoTranscurrido =
             System.currentTimeMillis() - lTiempoActual;
            
         //Guarda el tiempo actual
       	 lTiempoActual += lTiempoTranscurrido;

         //Actualiza la animación en base al tiempo transcurrido
         if (iPortada > 0) {
             aniPortada.actualiza(lTiempoTranscurrido);
         }
         
         // si ya empezó el juego
         if (bPlay) {
             
            if (bRestart) {
                // reinicia todas las variables
                iNivel = 1;
                iCantidadBloques = 0;
                iScore = 0;
                iVidas = 0;
                // dibuja todos los bloques otra vez en sus posiciones originales             
                int iPosX = 5;
                int iPosY = 35;
                int iI = 1;
                for (Base basBrick : lklDrogas) {
                    basBrick.setX(iPosX);
                    basBrick.setY(iPosY);
                    iPosX += 100;
                    if (iI % 9 == 0) {
                       iPosX = 5;
                       iPosY += 55;
                    }
                    iI++;
                }
                // se reposiciona la bolita
                basBola.setX(iWIDTH / 2);
                basBola.setY(580);
                iBallXSpeed = 5;
                iBallYSpeed = 5;
                
                // se reposiciona la barra
                basBarra.setX(iWIDTH / 2 - 75);
                basBarra.setY(600);
                bRestart = false;
            }
            
            // checa el nivel
            if (iCantidadBloques == 27) {
                iNivel++;
                iCantidadBloques = 0;
                // dibuja todos los bloques otra vez en sus posiciones originales             
                int iPosX = 5;
                int iPosY = 35;
                int iI = 0;
                for (Base basBrick : lklDrogas) {
                    basBrick.setX(iPosX);
                    basBrick.setY(iPosY);
                    iPosX += 100;
                    if (iI % 9 == 0) {
                       iPosX = 5;
                       iPosY += 55;
                    }
                    iI++;
                }
                
                // se reposiciona la bolita
                basBola.setX(iWIDTH / 2);
                basBola.setY(580);
                iBallXSpeed = 5;
                iBallYSpeed = 5;
                
                // se reposiciona la barra
                basBarra.setX(iWIDTH / 2 - 75);
                basBarra.setY(600);
             }
             
            // movimiento de la bola
            basBola.setX(basBola.getX() + iBallXSpeed);
            basBola.setY(basBola.getY() + iBallYSpeed);

            // movimiento de la barra con un contador para que se mueva fluido
            if (bMove) {
                if (iContadorBarra < 20) {
                    if (iDireccion == 1) {
                       basBarra.setX(basBarra.getX() - 5);
                    }  
                    else if (iDireccion == 2) {
                       basBarra.setX(basBarra.getX() + 5);
                    }
                    iContadorBarra++;
                }
                else {
                   bMove = false;
                }
            }
            
            // animacion de los bricks
            for (Base basBrick : lklDrogas) {
                if (basBrick.isAnimar()) {
                    if (iContadorBloque >= 30) {
                        iContadorBloque = 0;
                        basBrick.setX(basBrick.getX() * -1);
                        basBrick.setY(basBrick.getY() * -1);
                        basBrick.setAnimar(false);
                    }
                    else {
                        basBrick.getAnimacion().actualiza(lTiempoTranscurrido);
                        iContadorBloque++;
                    }
                }
            }
         }
         
         
         
         
    }
    
    /**
     * checaColision
     * 
     * Metodo usado para checar la colision entre objetos
     * 
     */
    public void checaColision() {
        // hacer que la bola rebote con las paredes
        if (basBola.getX() > iWIDTH - basBola.getAncho()) {
            // si choca con el lado derecho rebota
            iBallXSpeed *= -1;
        }
        if (basBola.getX() < 0) {
            // si choca con el lado izquierdo
            iBallXSpeed *= -1;
        }
        if (basBola.getY() > iHEIGHT - basBola.getAlto()) {
            // si choca abajo pierde vida
            iVidas--;
            // se reposiciona la bolita
            basBola.setX(iWIDTH / 2);
            basBola.setY(580);
            iBallXSpeed = 5;
            iBallYSpeed = 5;
            // se reposiciona la barra
            basBarra.setX(iWIDTH / 2 - 75);
            basBarra.setY(600);
            
        }
        if (basBola.getY() < 20) {
            // si choca arriba
            iBallYSpeed *= -1;
        }
        // si choca con la barra
        if (basBola.intersecta(basBarra)) {
            iBallYSpeed *= -1;
            iBallXSpeed = calcBallAngle(basBarra);
        }
        
        // que la barra no se salga
        if (basBarra.getX() < 0) {
            basBarra.setX(0);
        }
        else if (basBarra.getX() > iWIDTH - basBarra.getAncho()) {
            basBarra.setX(iWIDTH - basBarra.getAncho());
        }
        
        // checa los bricks
        for (Base basBrick : lklDrogas) {
            if (basBrick.intersecta(basBola) && !basBrick.isAnimar()) {
                // lo desaparece
                basBrick.setAnimar(true);
                
                // aumenta 100 al score
                iScore += 100;
                
                // rebota verticalmente
                iBallYSpeed *= -1;
                iBallXSpeed = calcBallAngle(basBrick);
                
                if (basBola.getY() > basBrick.getY() && 
                        basBola.getY() < basBrick.getY() + basBrick.getAlto()) {
                    iBallXSpeed *= -1;
                }
                // suma 1 a cantidad de bloques
                iCantidadBloques++;
            }
        }
        
    }
    
    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>JFrame</code>,
     * heredado de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada,
     * ademas que cuando la imagen es cargada te despliega una advertencia.
     * @param graGrafico es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics graGrafico) {
        // Inicializan el DoubleBuffer
        if (imaImagenJFrame == null){
            imaImagenJFrame = createImage (this.getSize().width, 
                                this.getSize().height);
            graGraficaJFrame = imaImagenJFrame.getGraphics ();
        }
        
        // dibuja la portada
        if (iPortada > 0) {
            graGraficaJFrame.drawImage(aniPortada.getImagen(), 0, 0, this);
            iPortada--;
        } 
        
        //si no se ha presionado el boton de play
        else if (!bPlay) {
            URL urlImagenMenu = this.getClass().
                                    getResource("imagenes/menu.png");
            switch (iNivel) {
                case 1: { //menu
                   urlImagenMenu = this.getClass().
                                            getResource("imagenes/menu.png");
                    break;    
                }
                case 2: { //highscores
                    urlImagenMenu = this.getClass().
                                            getResource("imagenes/nivel2.jpeg");
                    break;    
                }
                case 3: { //instrucciones
                    urlImagenMenu = this.getClass().
                                            getResource("imagenes/nivel3.jpeg");
                    break;    
                }
            }
            
            Image imaImagenMenu = Toolkit.getDefaultToolkit()
                                        .getImage(urlImagenMenu);
            graGraficaJFrame.drawImage(imaImagenMenu, 0, 0, this);
        }
        
        else {
            // Actualiza la imagen de fondo dependiendo del nivel
            URL urlImagenFondo = this.getClass().
                                            getResource("imagenes/nivel1.jpeg");
            switch (iNivel) {
                case 1: { //1 nivel
                   urlImagenFondo = this.getClass().
                                            getResource("imagenes/nivel1.jpeg");
                    break;    
                }
                case 2: { //2 nivel
                    urlImagenFondo = this.getClass().
                                            getResource("imagenes/nivel2.jpg");
                    break;    
                }
                case 3: { //3 nivel
                    urlImagenFondo = this.getClass().
                                            getResource("imagenes/nivel3.png");
                    break;    
                }
            }
            Image imaImagenFondo = Toolkit.getDefaultToolkit().
                                        getImage(urlImagenFondo);
            graGraficaJFrame.drawImage(imaImagenFondo, 0, 0, 
                                                        iWIDTH, iHEIGHT, this);
        }
        // Actualiza el Foreground.
        graGraficaJFrame.setColor (getForeground());
        paint1(graGraficaJFrame);
        
        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenJFrame, 0, 0, this);     
    }
    
    /**
      * Metodo <I>paint1</I> 
      * En este metodo se dibuja la imagen con la posicion actualizada,
      * ademas que cuando la imagen es cargada te despliega una advertencia.
      * @param graDibujo es el <code>objeto grafico</code> usado para dibujar.
      */
    public void paint1(Graphics graDibujo) {
        if (!bPlay && iPortada <= 0) {
            // dibuja los botones
            basBotonPlay.paint(graDibujo, this);
            basBotonHigh.paint(graDibujo, this);
            basBotonInst.paint(graDibujo, this);
        }
        
        else if (basBarra != null && lklDrogas != null && 
                                            basBola != null && bPlay) {
            // dibula los objetos
            basBola.paint(graDibujo, this);
            basBarra.paint(graDibujo, this);
            for (Base basBrick : lklDrogas) {
                basBrick.paint(graDibujo, this);
            }
            
            // dibuja vidas y score
            graDibujo.setColor(Color.white);
            graDibujo.drawString("Score: " + iScore, 800, 640);
            graDibujo.drawString("Vidas: " + iVidas, 700, 640);
        }
        else {
            //Da un mensaje mientras se carga el dibujo	
            graDibujo.drawString("No se cargo la imagen..", 20, 20);
        }
    }
    
    
    /**
      * Metodo <I>keyTyped</I> sobrescrito de la interface <code>KeyListener</code>.<P>
      * En este metodo maneja el evento que se genera al teclear cualquier la tecla.
      * @param kveEvent es el <code>evento</code> generado al presionar las teclas.
      */    
    public void keyTyped(KeyEvent kveEvent) {
        // No se utiliza
    }

    /**
      * Metodo <I>keyPressed</I> sobrescrito de la interface <code>KeyListener</code>.<P>
      * En este metodo maneja el evento que se genera al presionar cualquier la tecla.
      * @param kveEvent es el <code>evento</code> generado al presionar las teclas.
      */    
    public void keyPressed(KeyEvent kveEvent) {
        if (kveEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            // direccion es 1
            iDireccion = 1;
            // prende boleana
            bMove = true;
            iContadorBarra = 0;
        }
        else if (kveEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            // direccion es 2
            iDireccion = 2;
            // prende la boleana
            bMove = true;
            iContadorBarra = 0;
        }
    }

    /**
      * Metodo <I>keyReleased</I> sobrescrito de la interface <code>KeyListener</code>.<P>
      * En este metodo maneja el evento que se genera al liberar cualquier la tecla.
      * @param kveEvent es el <code>evento</code> generado al liberar las teclas.
      */    
    public void keyReleased(KeyEvent kveEvent) {
        if (kveEvent.getKeyCode() == KeyEvent.VK_P) {
            // cambia la boleana de pausa
            bPause = !bPause;
        }
        else if (kveEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            bRestart = true;
        }
    }

    /**
      * Metodo <I>calcBallAngle</I> tomado de 
      * http://www.flashgametuts.com/tutorials/as3/how-to-create-a-brick-breaker-game-in-as3-part-2/.<P>
      * En este metodo se calcula el angulo para rebotar la bola de la barra.
      * @param Base basObjeto es el objeto de referencia para el angulo
      * @return iHitPercent * 10 es el angulo al que rebota
      */   
    public int calcBallAngle(Base basObjeto) {
        // la posición es la bola menos la barra
        int iBallPosition = basBola.getX() - basObjeto.getX();
        // iHitPercent convierte la posición en un porcnetaje
        // La izquierda es -.5
        // La derecha es .5
        // El centro es 0
        double iHitPercent = ((double)iBallPosition / (basObjeto.getAncho() 
                - basBola.getAncho())) - .5;
        // multiplica el hitpercent por un numero para hacerlo grande
        // hace que la bola rebote
        return (int) (iHitPercent * 10);
        
        
    }
   
    
    /**
     * main
     * Metodo inicial de todo el problema
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea una instancia del juego
        BreakingBad brbJuego = new BreakingBad();
        brbJuego.setSize(iWIDTH, iHEIGHT);
        brbJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        brbJuego.setVisible(true);
    }

     /**
     * mouseClicked
     * 
     * Metodo sobrescrito de la clase <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar el mouse.
     * 
     * @param mseEvent es el <code>MoseEvent</code> que se genera en 
     * al presionar.
     * 
     */
    public void mouseClicked(MouseEvent mseEvent) {
       // no se utiliza
    }

     /**
     * mousePressed
     * 
     * Metodo sobrescrito de la clase <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar el mouse.
     * 
     * @param mseEvent es el <code>MoseEvent</code> que se genera en 
     * al presionar.
     * 
     */
    public void mousePressed(MouseEvent mseEvent) {
        // no hay codigo pero se debe escribir el metodo
    }

     /**
     * mouseReleased
     * 
     * Metodo sobrescrito de la clase <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar el mouse.
     * 
     * @param mseEvent es el <code>MoseEvent</code> que se genera en 
     * al presionar.
     * 
     */
    public void mouseReleased(MouseEvent mseEvent) {
        // si el usuario presiono un boton
        if (basBotonPlay.intersectaMouse(mseEvent.getX(), mseEvent.getY())) {
            bPlay = true;  
        }
    }

     /**
     * mouseEntered
     * 
     * Metodo sobrescrito de la clase <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera cuando el mouse entra en
     * el applet.
     * 
     * @param mseEvent es el <code>MoseEvent</code> que se genera en 
     * al presionar.
     * 
     */
    public void mouseEntered(MouseEvent mseEvent) {
        // no hay codigo pero se debe escribir el metodo
    }

     /**
     * mouseExited
     * 
     * Metodo sobrescrito de la clase <code>MouseListener</code>.<P>
     * En este metodo maneja el evento que se genera cuando el mouse sale del
     * applet.
     * 
     * @param mseEvent es el <code>MoseEvent</code> que se genera en 
     * al presionar.
     * 
     */
    public void mouseExited(MouseEvent mseEvent) {
        // no hay codigo pero se debe escribir el metodo
    }
    
}
