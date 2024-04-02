package co.edu.uniquindio.poo;

/**
 * Clase que agrupa los datos de un círculo
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Circulo extends FiguraGeometrica {

    private final double radio;

    /**
     * Método constructor de la clase Circulo
     * 
     * @param radio valor del radio del círculo
     */
    public Circulo(double radio) {
        assert radio > 0.0 : "Error, no se puede crear un círculo con radio negativo";

        this.radio = radio;
    }

    /**
     * Método para obtener el valor del radio del círculo
     * 
     * @return valor del radio del círculo
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Método para calcular el área del círculo usando el radio definido
     */
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

}
