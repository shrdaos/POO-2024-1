package co.edu.uniquindio.poo;

/**
 * Clase que agrupa los datos de un triángulo rectángulo,
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class TrianguloRectangulo extends FiguraGeometrica {
    private final double base;
    private final double altura;

    /**
     * Método constructor de la clase TrianguloRectangulo
     * 
     * @param base   valor de la base del triángulo
     * @param altura valor de la altura del triángulo
     */
    public TrianguloRectangulo(double base, double altura) {
        assert base > 0.0 : "Error, no se puede crear un triángulo rectángulo con base negativa";
        assert altura > 0.0 : "Error, no se puede crear un triángulo rectángulo con altura negativa";

        this.base = base;
        this.altura = altura;
    }

    /**
     * Método para obtener el valor de la base del triángulo rectángulo
     * 
     * @return valor de la base del triángulo rectángulo
     */
    public double getBase() {
        return base;
    }

    /**
     * Método para obtener el valor de la altura del triángulo rectángulo
     * 
     * @return valor de la altura del triángulo rectángulo
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Método para calcular el valor del área del triángulo rectángulo
     * 
     * @return valor del área del triángulo rectángulo
     */
    public double calcularArea() {
        return (base * altura) / 2.0;
    }
}
