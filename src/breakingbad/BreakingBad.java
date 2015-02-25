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
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JFrame;

public class BreakingBad extends JFrame implements KeyListener, Runnable{
    /* Declaración de Variables */
    private static final int iWIDTH = 900;  // ancho del JFrame
    private static final int iHEIGHT = 650; // alto del JFrame
    private int iScore;     // puntos del juego
    private boolean bLose;  // boleana de perdida de juego
    private Base basBarra;  // barra del juego
    private Base basBola;   // bola del juego
    private int iBallXSpeed; // velocidad X de la bola
    private int iBallYSpeed; // velocidad Y de la bola
    private int iDireccion; // direccion de la barra (1- izquierda, 2 derecha)
    private boolean bPause; // boleana para pausa
    private boolean bMove;  // boleana de movimiento de la barra
    private int iNivel; // nivel del juego 
    private LinkedList<Animacion> lklDrogas; //Lista de objetos de la clase Animacion
    private Animacion aniPortada;   // Imagen portada
    private long tiempoActual;
    private long tiempoInicial;
    private boolean bPortada;  // boleana de control para animacion portada
    private Image    imaImagenJFrame;   // Imagen a proyectar en JFrame
    private Graphics graGraficaJFrame;  // Objeto grafico de la Imagen
    
    
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
        
        // inicializa boleana de movimiento en falso
        bPortada = true;
        
        // se inicializa en nivel 1
        iNivel = 1;
        
        // se inicializa la bola y sus velocidades
        iBallYSpeed = 8;
        iBallXSpeed = 8;
        URL urlImagenBola = this.getClass().getResource("imagenes/bolaOso.png");
        basBola = new Base(0, 0, 
                Toolkit.getDefaultToolkit().getImage(urlImagenBola));
        
        // reposicionar la bola en medio
        basBola.setX(iWIDTH / 2);
        basBola.setY(iHEIGHT / 2);
        
        // se inicializa la barra
        URL urlImagenBarra = this.getClass().getResource("imagenes/barra.png");
        basBarra = new Base(iWIDTH / 2, 620, 
                Toolkit.getDefaultToolkit().getImage(urlImagenBarra));
        
        //Se cargan las imágenes(cuadros) para la animación de la portada
        Image portada1 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover.png"));
        Image portada2 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover2.png"));
        Image portada3 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover3.png"));
        Image portada4 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover4.png"));
        Image portada5 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover5.png"));
        Image portada6 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover6.png"));
        Image portada7 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover7.png"));
        Image portada8 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover8.png"));
        Image portada9 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover9.png"));
        Image portada10 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover10.png"));
        Image portada11 = Toolkit.getDefaultToolkit().getImage(this.getClass().
                            getResource("imagenes/cover11.png"));
        
        //Se crea la animación de la portada
        aniPortada = new Animacion();
	aniPortada.sumaCuadro(portada1, 2000);
        aniPortada.sumaCuadro(portada2, 100);
        aniPortada.sumaCuadro(portada3, 100);
        aniPortada.sumaCuadro(portada4, 100);
        aniPortada.sumaCuadro(portada5, 100);
        aniPortada.sumaCuadro(portada6, 100);
        aniPortada.sumaCuadro(portada7, 100);
        aniPortada.sumaCuadro(portada8, 100);
        aniPortada.sumaCuadro(portada9, 100);
        aniPortada.sumaCuadro(portada10, 100);
        aniPortada.sumaCuadro(portada11, 100);
        
        
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
        
        addKeyListener(this); // se escucha el teclado
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
         long tiempoTranscurrido =
             System.currentTimeMillis() - tiempoActual;
            
         //Guarda el tiempo actual
       	 tiempoActual += tiempoTranscurrido;

         //Actualiza la animación en base al tiempo transcurrido
         if (!bPortada) {
            aniPortada.actualiza(tiempoTranscurrido);
         }
         
         // movimiento de la bola
         basBola.setX(basBola.getX() + iBallXSpeed);
         basBola.setY(basBola.getY() + iBallYSpeed);
         
         // movimiento de la barra
         if (bMove) {
             if (iDireccion == 1) {
                basBarra.setX(basBarra.getX() - 10);
             }
             else if (iDireccion == 2) {
                basBarra.setX(basBarra.getX() + 10);
             }
             bMove = false;
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
        if (basBola.getX() > iWIDTH - basBola.getX()) {
            // si choca con el lado derecho rebota
            iBallXSpeed *= -1;
        }
        if (basBola.getX() < 0) {
            // si choca con el lado izquierdo
            iBallXSpeed *= -1;
        }
        if (basBola.getY() > iHEIGHT - basBola.getY()) {
            // si choca abajo pierde
            bLose = true;
        }
        if (basBola.getY() < 0) {
            // si choca arriba
            iBallYSpeed *= -1;
        }
        // si choca con la barra
        if (basBola.intersecta(basBarra)) {
            calcBallAngle();
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
    
    /**
      * Metodo <I>paint1</I> 
      * En este metodo se dibuja la imagen con la posicion actualizada,
      * ademas que cuando la imagen es cargada te despliega una advertencia.
      * @param graDibujo es el <code>objeto grafico</code> usado para dibujar.
      */
    public void paint1(Graphics graDibujo) {
        if (basBola != null ){
            basBola.paint(graDibujo, this);
            basBarra.paint(graDibujo, this);
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
        }
        else if (kveEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            // direccion es 2
            iDireccion = 2;
            // prende la boleana
            bMove = true;
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
        int iHitPercent = (int) ((iBallPosition / (basBarra.getAncho() 
                - basBola.getAncho())) - .5);
        // multiplica el hitpercent por un numero para hacerlo grande
        // hace que la bola rebote
        iBallXSpeed = iHitPercent * 10;
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
    
}
