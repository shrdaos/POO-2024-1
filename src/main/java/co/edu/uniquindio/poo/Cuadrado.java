package co.edu.uniquindio.poo;

/**
 * Clase que agrupa los datos de un cuadrado,
 * asumiendo que un cuadrado es un rectángulo de lados iguales
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Cuadrado extends Rectangulo {

    /**
     * Método constructor de la clase cuadrado
     */
    public Cuadrado(double lado) {
        super(lado, lado);
    }

}
