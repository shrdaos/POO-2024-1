package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Rectangulo
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class RectanguloTest {
    private static final Logger LOG = Logger.getLogger(RectanguloTest.class.getName());

    @Test
    public void AreaRectanguloAnchoAltoPositivo() {
        LOG.info("Iniciado test AreaRectanguloAnchoAltoPositivo");

        var rectangulo = new Rectangulo(10, 20);

        assertEquals(200.0, rectangulo.calcularArea(), App.PRECISION);

        LOG.info("Finalizando test AreaRectanguloAnchoAltoPositivo");
    }

    @Test
    public void AreaRectanguloAnchoNegativo() {
        LOG.info("Iniciado test AreaRectanguloAnchoNegativo");

        assertThrows(Throwable.class, () -> new Rectangulo(-10,20));

        LOG.info("Finalizando test AreaRectanguloAnchoNegativo");
    }

    @Test
    public void AreaRectanguloAltoNegativo() {
        LOG.info("Iniciado test AreaRectanguloAltoNegativo");

        assertThrows(Throwable.class, () -> new Rectangulo(10,-20));

        LOG.info("Finalizando test AreaRectanguloAltoNegativo");
    }

}
