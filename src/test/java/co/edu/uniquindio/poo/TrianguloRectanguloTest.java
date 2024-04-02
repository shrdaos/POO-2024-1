package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase TrianguloRectangulo
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class TrianguloRectanguloTest {
    private static final Logger LOG = Logger.getLogger(TrianguloRectanguloTest.class.getName());

    @Test
    public void AreaTrianguloRectanguloBaseAlturaPositivo() {
        LOG.info("Iniciado test AreaTrianguloRectanguloBaseAlturaPositivo");

        var triangulo = new TrianguloRectangulo(10, 20);

        assertEquals(100.0, triangulo.calcularArea(), App.PRECISION);

        LOG.info("Finalizando test AreaTrianguloRectanguloBaseAlturaPositivo");
    }

    @Test
    public void AreaTrianguloRectanguloBaseNegativa() {
        LOG.info("Iniciado test AreaTrianguloRectanguloBaseNegativa");

        assertThrows(Throwable.class, () -> new TrianguloRectangulo(-10,20));

        LOG.info("Finalizando test AreaTrianguloRectanguloBaseNegativa");
    }

    @Test
    public void AreaTrianguloRectanguloAlturaNegativa() {
        LOG.info("Iniciado test AreaTrianguloRectanguloAlturaNegativa");

        assertThrows(Throwable.class, () -> new TrianguloRectangulo(10,-20));

        LOG.info("Finalizando test AreaTrianguloRectanguloAlturaNegativa");
    }

}
