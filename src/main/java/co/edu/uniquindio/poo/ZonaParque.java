package co.edu.uniquindio.poo;

/**
 * Clase que agrupa los datos de una zona del parque
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class ZonaParque {

    private final String nombre;
    private final FiguraGeometrica forma;
    private final Material material;

    /**
     * Método constructor de la clase ZonaParque
     * 
     * @param nombre   nombre de la zona del parque
     * @param forma    forma geométrica de la zona del parque
     * @param material material de la zona del parque
     */
    public ZonaParque(String nombre, FiguraGeometrica forma, Material material) {
        this.nombre = nombre;
        this.forma = forma;
        this.material = material;
    }

    /**
     * Método para obtener el nombre de la zona del parque
     * 
     * @return nombre de la zona del parque
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la forma geométrica de la zona del parque
     * 
     * @return forma geométrica de la zona del parque
     */
    public FiguraGeometrica getForma() {
        return forma;
    }

    /**
     * Método para obtener el material de la zona del parque
     * 
     * @return material de la zona del parque
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Método para calcular el valor de la zona del parque
     * independiente de la forma geométrica y del material
     * 
     * @return el valor de la zona (productor entre el área de la zona y el valor
     *         del metro cuadrado)
     */
    public double calcularValor() {
        return forma.calcularArea() * material.getValorMetroCuadrado();
    }

}
