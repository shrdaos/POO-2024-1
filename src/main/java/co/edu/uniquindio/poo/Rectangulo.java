package co.edu.uniquindio.poo;

/**
 * Clase que agrupa los datos de un rectángulo,
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Rectangulo extends FiguraGeometrica {
    private final double ancho;
    private final double alto;

    /**
     * Método constructor de la clase Rectangulo
     * 
     * @param ancho valor del ancho del rectángulo
     * @param alto valor del alto del rectángulo
     */
    public Rectangulo(double ancho, double alto) {
        assert ancho > 0: "Error, no se puede crear un rectángulo con ancho negativo";
        assert alto > 0: "Error, no se puede crear un rectángulo con alto negativo";
       
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * Método para obtener el valor del ancho del rectángulo
     * 
     * @return valor del ancho del rectángulo
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * Método para obtener el valor del alto del rectángulo
     * 
     * @return valor del alto del rectángulo
     */
    public double getLargo() {
        return alto;
    }

    /**
     * Método para calcular el valor del área del rectángulo
     * 
     * @return valor del área del rectángulo
     */
    public double calcularArea() {
        return ancho * alto;
    }
}
