package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase ZonaParque
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class ZonaParqueTest {
    private static final Logger LOG = Logger.getLogger(ZonaParqueTest.class.getName());

    @Test
    public void ValorZonaCircularArena() {
        LOG.info("Iniciado test ValorZonaCircularArena");

        var zona = new ZonaParque("Zona 1", new Circulo(10), Material.ARENA);

        assertEquals(3141592.65, zona.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorZonaCircularArena");
    }

    @Test
    public void ValorZonaRectangularGramaSintetica() {
        LOG.info("Iniciado test ValorZonaRectangularGramaSintetica");

        var zona = new ZonaParque("Zona 1", new Rectangulo(10, 20), Material.GRAMA_SINTETICA);

        assertEquals(7000000.0, zona.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorZonaRectangularGramaSintetica");
    }

    @Test
    public void ValorZonaCuadradaGramaNatural() {
        LOG.info("Iniciado test ValorZonaCuadradaGramaNatural");

        var zona = new ZonaParque("Zona 1", new Cuadrado(10), Material.GRAMA_NATURAL);

        assertEquals(2000000.0, zona.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorZonaCuadradaGramaNatural");
    }

    @Test
    public void ValorZonaTrianguloRectanguloAsfalto() {
        LOG.info("Iniciado test ValorZonaTrianguloRectanguloAsfalto");

        var zona = new ZonaParque("Zona 1", new TrianguloRectangulo(10,20), Material.ASFALTO);

        assertEquals(4000000.0, zona.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorZonaTrianguloRectanguloAsfalto");
    }
}
