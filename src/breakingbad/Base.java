/**
 * Base
 *
 * Modela la definición de todos los objetos de tipo
 * <code>Base</code>
 *
 * @author Mauro Amarante (A00191903) and Fabian Montemayor (A01280156)
 * @version 2.0 
 * @date 11/02/15
 */

package breakingbad;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Base {

    private int iX;     //posicion en x.       
    private int iY;     //posicion en y.
    private int iAncho; //ancho del objeto
    private int iAlto; //largo del objeto
    private Image imaImagen;	//imagen.
    private Animacion aniAnimacion; // animacion de la base
    private boolean bAnimar;    // boleana de si se anima o no

    /**
     * Base
     * 
     * Metodo constructor usado para crear el objeto animal
     * creando el icono a partir de una imagen
     * 
     * @param iX es la <code>posicion en x</code> del objeto.
     * @param iY es la <code>posicion en y</code> del objeto.
     * @param iAncho es el <code>ancho</code> del objeto.
     * @param iAlto es el <code>Largo</code> del objeto.
     * @param imaImagen es la <code>imagen</code> del objeto.
     * 
     */
    public Base(int iX, int iY , int iAncho, int iAlto, Image imaImagen) {
        this.iX = iX;
        this.iY = iY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        this.imaImagen = imaImagen;
        this.bAnimar = false;
    }
    
    /**
     * Base
     * 
     * Metodo constructor usado para crear el objeto animal
     * creando el icono a partir de una imagen sin alto ni ancho
     * 
     * @param iX es la <code>posicion en x</code> del objeto.
     * @param iY es la <code>posicion en y</code> del objeto.
     * @param imaImagen es la <code>imagen</code> del objeto.
     * 
     */
    public Base(int iX, int iY, Image imaImagen) {
        this.iX = iX;
        this.iY = iY;
        this.imaImagen = imaImagen;
        ImageIcon imiImagen = new ImageIcon (imaImagen);
        this.iAncho = imiImagen.getIconWidth();
        this.iAlto = imiImagen.getIconHeight();  
    }
    
        /**
     * Base
     * 
     * Metodo constructor usado para crear el objeto animal
     * creando el icono a partir de una imagen sin alto ni ancho
     * 
     * @param iX es la <code>posicion en x</code> del objeto.
     * @param iY es la <code>posicion en y</code> del objeto.
     * @param imaImagen es la <code>imagen</code> del objeto.
     * 
     */
    public Base(int iX, int iY, Image imaImagen, Animacion aniAnimacion) {
        this.iX = iX;
        this.iY = iY;
        this.imaImagen = imaImagen;
        ImageIcon imiImagen = new ImageIcon (imaImagen);
        this.iAncho = imiImagen.getIconWidth();
        this.iAlto = imiImagen.getIconHeight();
        this.aniAnimacion = aniAnimacion;
        this.bAnimar = false;
    }

    
    /**
     * setX
     * 
     * Metodo modificador usado para cambiar la posicion en x del objeto
     * 
     * @param iX es la <code>posicion en x</code> del objeto.
     * 
     */
    public void setX(int iX) {
        this.iX = iX;
    }

    /**
     * getX
     * 
     * Metodo de acceso que regresa la posicion en x del objeto 
     * 
     * @return iX es la <code>posicion en x</code> del objeto.
     * 
     */
    public int getX() {
            return iX;
    }

    /**
     * setY
     * 
     * Metodo modificador usado para cambiar la posicion en y del objeto 
     * 
     * @param iY es la <code>posicion en y</code> del objeto.
     * 
     */
    public void setY(int iY) {
            this.iY = iY;
    }

    /**
     * getY
     * 
     * Metodo de acceso que regresa la posicion en y del objeto 
     * 
     * @return posY es la <code>posicion en y</code> del objeto.
     * 
     */
    public int getY() {
        return iY;
    }

    /**
     * setImagen
     * 
     * Metodo modificador usado para cambiar el icono de imagen del objeto
     * tomandolo de un objeto imagen
     * 
     * @param imaImagen es la <code>imagen</code> del objeto.
     * 
     */
    public void setImagen(Image imaImagen) {
        this.imaImagen = imaImagen;
    }

    /**
     * getImagen
     * 
     * Metodo de acceso que regresa la imagen que representa el icono del objeto
     * 
     * @return la imagen a partide del <code>icono</code> del objeto.
     * 
     */
    public Image getImagen() {
        return imaImagen;
    }

    /**
     * getAncho
     * 
     * Metodo de acceso que regresa el ancho del icono 
     * 
     * @return un <code>entero</code> que es el ancho de la imagen.
     * 
     */
    public int getAncho() {
        return iAncho;
    }

    /**
     * getAlto
     * 
     * Metodo que  da el alto del icono 
     * 
     * @return un <code>entero</code> que es el alto de la imagen.
     * 
     */
    public int getAlto() {
        return iAlto;
    }
    
    /**
     * getAnimacion
     * 
     * Metodo de acceso que regresa la animacion  del objeto 
     * 
     * @return aniAnimacion es la <code>animacion</code> del objeto.
     * 
     */
    public Animacion getAnimacion() {
            return aniAnimacion;
    }
    
        /**
     * setX
     * 
     * Metodo modificador usado para cambiar la boleana de animacion
     * 
     * @param bAnimar es la <code>boleana de animacion</code> del objeto.
     * 
     */
    public void setAnimar(boolean bAnimar) {
        this.bAnimar = bAnimar;
    }

    /**
     * getX
     * 
     * Metodo de acceso que regresa la boleana de animacion
     * 
     * @return bAnimar es la <code>boleana de animacion</code> del objeto.
     * 
     */
    public boolean isAnimar() {
            return bAnimar;
    }
    /**
     * paint
     * 
     * Metodo para pintar el animal
     * 
     * @param graGrafico    objeto de la clase <code>Graphics</code> para graficar
     * @param imoObserver  objeto de la clase <code>ImageObserver</code> es el 
     *    Applet donde se pintara
     * 
     */
    public void paint(Graphics graGrafico, ImageObserver imoObserver) {
        if (bAnimar) {
            graGrafico.drawImage(aniAnimacion.getImagen(), getX(), getY(), getAncho(), 
                getAlto(), imoObserver);
        }
        else {
            graGrafico.drawImage(getImagen(), getX(), getY(), getAncho(), 
                getAlto(), imoObserver);
        }
    }
        
    

    /**
     * equals
     * 
     * Metodo para checar igualdad con otro objeto
     * 
     * @param objObjeto    objeto de la clase <code>Object</code> para comparar
     * @return un valor <code>boleano</code> que sera verdadero si el objeto
     *   que invoca es igual al objeto recibido como parámetro
     * 
     */
    public boolean equals(Object objObjeto) {
        // si el objeto parametro es una instancia de la clase Base
        if (objObjeto instanceof Base) {
            // se regresa la comparación entre este objeto que invoca y el
            // objeto recibido como parametro
            Base basParam = (Base) objObjeto;
            return this.getX() ==  basParam.getX() && 
                    this.getY() == basParam.getY() &&
                    this.getAncho() == basParam.getAncho() &&
                    this.getAlto() == basParam.getAlto() &&
                    this.getImagen() == basParam.getImagen();
        }
        else {
            // se regresa un falso porque el objeto recibido no es tipo Base
            return false;
        }
    }

    /**
     * toString
     * 
     * Metodo para obtener la interfaz del objeto
     * 
      * @return un valor <code>String</code> que representa al objeto
     * 
     */
    public String toString() {
        return " x: " + this.getX() + " y: "+ this.getY() +
                " ancho: " + this.getAncho() + " alto: " + this.getAlto();
    }
    
    /*
     * intersecta
     *
     * Metodo que checa si una base intersecta a otro
     *
     * @param objObjeto es un objeto de la clase <code>Object</code>
     * @return un boleano para saber si intersecta o no
     */
    public boolean intersecta(Object objObjeto) {
        if (objObjeto instanceof Base) {
            // crea un objeto rectangulo de este objeto
            Rectangle rctEsteObjeto = new Rectangle(this.getX(), this.getY(),
                    this.getAncho(), this.getAlto());
            Base basObjeto = (Base) objObjeto;
            // crea un objeto rectangulo del objeto parametro
            Rectangle rctObjetoParam = new Rectangle(basObjeto.getX(),
                    basObjeto.getY(), basObjeto.getAncho(), basObjeto.getAlto());
            // regresa la intereccion entre ellos
            return rctEsteObjeto.intersects(rctObjetoParam);
        } 
        else {
            return false;
        }
    }
    
    /*
     * intersectaMouse
     *
     * Metodo que checa si un animal intersecta a otro
     *
     * @param objObjeto es un objeto de la clase <code>Object</code>
     * @return un boleano para saber si intersecta o no
     */
    public boolean intersectaMouse(int iX, int iY) {
        Rectangle rctEsteObjeto = new Rectangle(this.getX(), this.getY(),
                    this.getAncho(), this.getAlto());
        return rctEsteObjeto.contains(iX, iY);
    }
}