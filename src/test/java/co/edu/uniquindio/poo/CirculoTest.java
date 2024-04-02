package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Circulo
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class CirculoTest {
    private static final Logger LOG = Logger.getLogger(CirculoTest.class.getName());

    @Test
    public void AreaCirculoRadioPositivo() {
        LOG.info("Iniciado test AreaCirculoRadioPositivo");

        var circulo = new Circulo(10);

        assertEquals(314.159, circulo.calcularArea(), App.PRECISION);

        LOG.info("Finalizando test AreaCirculoRadioPositivo");
    }

    @Test
    public void AreaCirculoRadioNegativo() {
        LOG.info("Iniciado test AreaCirculoRadioNegativo");

        assertThrows(Throwable.class, () -> new Circulo(-10));

        LOG.info("Finalizando test AreaCirculoRadioNegativo");
    }
}
