/**
 * TareaBreakingBad
 *
 * Juego en el que .....
 *
 * @author Mauro Amarante (A00191903) and Fabian Montemayor (A01280156)
 * @version 1.0
 * @date 2015/2/25
 */

package breakingbad;

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
    private int iContadorBarra;
    private long lTiempoActual;
    private long lTiempoInicial;
    
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
        
        // inicializa la boleana en falso
        bLose = false;
        
        // inicializa la direccion en 0
        iDireccion = 0;
        
        // inicializa la boleana de pausa en falso
        bPause = false;
        
        // inicializa boleana de movimiento en falso
        bMove = false;
        
<<<<<<< HEAD
        // inicializa en 90
        iPortada = 450;
        
        // el juego no inicia hasta presionar el boton del menu
        bPlay = false;
=======
        // inicializa en 200
        iPortada = 200;
>>>>>>> origin/master
        
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
<<<<<<< HEAD
        Image imaBrick1 = Toolkit.getDefaultToolkit().getImage("imagenes/fotobrick1.png");
        Image imaBrick2 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick2.png");
        Image imaBrick3 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick3.png");
        Image imaBrick4 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick4.png");
        Image imaBrick5 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick5.png");
        Image imaBrick6 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick6.png");
        Image imaBrick7 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick7.png");
        Image imaBrick8 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick8.png");
        Image imaBrick9 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick9.png");
        Image imaBrick10 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick10.png");
        Image imaBrick11 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick11.png");
        Image imaBrick12 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick12.png");
        Image imaBrick13 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick13.png");
        Image imaBrick14 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick14.png");
        Image imaBrick15 = Toolkit.getDefaultToolkit().getImage("imagenes/foto brick15.png");
=======
        Image imaBrick1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick1.png"));
        Image imaBrick2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick2.png"));
        Image imaBrick3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick3.png"));
        Image imaBrick4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick4.png"));
        Image imaBrick5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick5.png"));
        Image imaBrick6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick6.png"));
        Image imaBrick7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick7.png"));
        Image imaBrick8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick8.png"));
        Image imaBrick9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick9.png"));
        Image imaBrick10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick10.png"));
        Image imaBrick11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick11.png"));
        Image imaBrick12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick12.png"));
        Image imaBrick13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick13.png"));
        Image imaBrick14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick14.png"));
        Image imaBrick15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fotobrick15.png"));
>>>>>>> origin/master
        
        Animacion aniBrick = new Animacion();
        aniBrick.sumaCuadro(imaBrick1, 100);
        aniBrick.sumaCuadro(imaBrick2, 100);
        aniBrick.sumaCuadro(imaBrick3, 100);
        aniBrick.sumaCuadro(imaBrick4, 100);
        aniBrick.sumaCuadro(imaBrick5, 100);
        aniBrick.sumaCuadro(imaBrick6, 100);
        aniBrick.sumaCuadro(imaBrick7, 100);
        aniBrick.sumaCuadro(imaBrick8, 100);
        aniBrick.sumaCuadro(imaBrick9, 100);
        aniBrick.sumaCuadro(imaBrick10, 100);
        aniBrick.sumaCuadro(imaBrick11, 100);
        aniBrick.sumaCuadro(imaBrick12, 100);
        aniBrick.sumaCuadro(imaBrick13, 100);
        aniBrick.sumaCuadro(imaBrick14, 100);
        aniBrick.sumaCuadro(imaBrick15, 100);
        
        // crea los cuadros
        lklDrogas = new LinkedList();
        
        // posiciones de los cuadros
        int iPosX = 5;
        int iPosY = 35;
        
        for (int iI = 0; iI < 20; iI++) {
            Base basDroga = new Base(iPosX, iPosY, 
                    imaBrick1, aniBrick);
            iPosX += 105;
            if (iI % 7 == 0) {
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
        addMouseListener(this); //se eescucha al mouse
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
        while (true) {
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
         aniPortada.actualiza(lTiempoTranscurrido);
         
         // movimiento de la bola
         basBola.setX(basBola.getX() + iBallXSpeed);
         basBola.setY(basBola.getY() + iBallYSpeed);
         
         // movimiento de la barra
         if (bMove) {
             if (iContadorBarra < 20) {
                if (iDireccion == 1) {
                    basBarra.setX(basBarra.getX() - 3);
                }  
                else if (iDireccion == 2) {
                    basBarra.setX(basBarra.getX() + 3);
                }
                iContadorBarra++;
             }
             else {
                bMove = false;
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
            // si choca abajo pierde
            bLose = true;
        }
        if (basBola.getY() < 20) {
            // si choca arriba
            iBallYSpeed *= -1;
        }
        // si choca con la barra
        if (basBola.intersecta(basBarra)) {
            calcBallAngle();
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
            if (basBrick.intersecta(basBola)) {
                
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
        
<<<<<<< HEAD
        
        // Inicializan el DoubleBuffer
        if (imaImagenJFrame == null){
            imaImagenJFrame = createImage (this.getSize().width, 
                                this.getSize().height);
            graGraficaJFrame = imaImagenJFrame.getGraphics ();
        }

        if (iPortada > 0) {
            graGraficaJFrame.drawImage(aniPortada.getImagen(), 0, 0, this);
            iPortada--;
        } 
        
        else if (!bPlay) {
            URL urlImagenMenu = this.getClass().
                                    getResource("imagenes/menu.png");
            Image imaImagenMenu = Toolkit.getDefaultToolkit()
                                        .getImage(urlImagenMenu);
            graGraficaJFrame.drawImage(imaImagenMenu, 0, 0, this);
        }
        
        else {
        // Actualiza la imagen de fondo.
        URL urlImagenFondo = this.getClass().getResource("imagenes/nivel1.jpeg");
        Image imaImagenFondo = Toolkit.getDefaultToolkit().getImage(urlImagenFondo);
        graGraficaJFrame.drawImage(imaImagenFondo, 0, 0, iWIDTH, iHEIGHT, this);
        }
        // Actualiza el Foreground.
        graGraficaJFrame.setColor (getForeground());
        paint1(graGraficaJFrame);
        
        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenJFrame, 0, 0, this);
        
=======
        else {
            // Inicializan el DoubleBuffer
            if (imaImagenJFrame == null){
                imaImagenJFrame = createImage (this.getSize().width, 
                                    this.getSize().height);
                graGraficaJFrame = imaImagenJFrame.getGraphics ();
            }

            // Actualiza la imagen de fondo.
            URL urlImagenFondo = this.getClass().getResource("imagenes/nivel1.jpeg");
            Image imaImagenFondo = Toolkit.getDefaultToolkit().getImage(urlImagenFondo);
            graGraficaJFrame.drawImage(imaImagenFondo, 0, 0, iWIDTH, iHEIGHT, this);

            // Actualiza el Foreground.
            graGraficaJFrame.setColor (getForeground());
            paint1(graGraficaJFrame);

            // Dibuja la imagen actualizada
            graGrafico.drawImage (imaImagenJFrame, 0, 0, this);
        }
>>>>>>> origin/master
       
    }
    
    /**
      * Metodo <I>paint1</I> 
      * En este metodo se dibuja la imagen con la posicion actualizada,
      * ademas que cuando la imagen es cargada te despliega una advertencia.
      * @param graDibujo es el <code>objeto grafico</code> usado para dibujar.
      */
    public void paint1(Graphics graDibujo) {
<<<<<<< HEAD
        if (!bPlay && iPortada <= 0) {
            basBotonPlay.paint(graDibujo, this);
            basBotonHigh.paint(graDibujo, this);
            basBotonInst.paint(graDibujo, this);
        }
        
        else if (basBola != null && bPlay){
=======
        if (basBarra != null && lklDrogas != null && 
                basBola != null && iPortada <= 0){
>>>>>>> origin/master
            basBola.paint(graDibujo, this);
            basBarra.paint(graDibujo, this);
            for (Base basBrick : lklDrogas) {
                basBrick.paint(graDibujo, this);
            }
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
            if (!bPause) {
                bPause = true;
            }
            else {
                bPause = false;
            }
        }
    }

    /**
      * Metodo <I>calcBallAngle</I> tomado de 
      * http://www.flashgametuts.com/tutorials/as3/how-to-create-a-brick-breaker-game-in-as3-part-2/.<P>
      * En este metodo se calcula el angulo para rebotar la bola de la barra.
      */   
    public void calcBallAngle() {
        // la posición es la bola menos la barra
        int iBallPosition = basBola.getX() - basBarra.getX();
        // iHitPercent convierte la posición en un porcnetaje
        // La izquierda es -.5
        // La derecha es .5
        // El centro es 0
        double iHitPercent = ((double)iBallPosition / (basBarra.getAncho() 
                - basBola.getAncho())) - .5;
        // multiplica el hitpercent por un numero para hacerlo grande
        // hace que la bola rebote
        iBallXSpeed = (int) (iHitPercent * 10);
        // hace que la bola rebote para arriba
        iBallYSpeed *= -1;
        
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
    public void mouseClicked(MouseEvent e) {
       
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
