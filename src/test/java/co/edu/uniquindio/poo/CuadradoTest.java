package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Cuadrado
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class CuadradoTest {
    private static final Logger LOG = Logger.getLogger(CuadradoTest.class.getName());

    @Test
    public void AreaCuadradoLadoPositivo() {
        LOG.info("Iniciado test AreaCuadradoLadoPositivo");

        var cuadrado = new Cuadrado(10);

        assertEquals(100.0, cuadrado.calcularArea(), App.PRECISION);

        LOG.info("Finalizando test AreaCuadradoLadoPositivo");
    }

    @Test
    public void AreaCuadradoLadoNegativo() {
        LOG.info("Iniciado test AreaCuadradoLadoNegativo");

        assertThrows(Throwable.class, () -> new Cuadrado(-10));

        LOG.info("Finalizando test AreaCuadradoLadoNegativo");
    }

}
