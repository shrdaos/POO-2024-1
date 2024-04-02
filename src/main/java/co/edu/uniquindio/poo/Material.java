package co.edu.uniquindio.poo;

/**
 * Clase de tipo enumeración con el valor del metro cuadrado
 * asociado a cada material
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public enum Material {
    // Cada material es en realidad un objeto

    ARENA(10000.0),
    GRAMA_SINTETICA(35000.0),
    GRAMA_NATURAL(20000.0),
    ASFALTO(40000.0);

    private final double valorMetroCuadrado;

    /**
     * Método constructor de la clase tipo enumeración
     * 
     * @param valorMetroCuadrado valor del metro cuadrado del material
     */
    private Material(double valorMetroCuadrado) {
        this.valorMetroCuadrado = valorMetroCuadrado;
    }

    /**
     * Método para obtener el valor del metro cuadrado del material
     * 
     * @return valor del metro cuadrado del material
     */
    public double getValorMetroCuadrado() {
        return valorMetroCuadrado;
    }

}
