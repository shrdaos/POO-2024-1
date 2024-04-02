package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase ParqueInfantil
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class ParqueInfantilTest {
    private static final Logger LOG = Logger.getLogger(ParqueInfantilTest.class.getName());

    @Test
    public void ParqueInfantilNombreNulo() {
        LOG.info("Iniciado test ParqueInfantilNombreNulo");

        assertThrows(Throwable.class, () -> new ParqueInfantil(null, "Descripción", Municipio.ARMENIA));

        LOG.info("Finalizando test ParqueInfantilNombreNulo");
    }

    @Test
    public void ParqueInfantilNombreVacio() {
        LOG.info("Iniciado test ParqueInfantilNombreVacio");

        assertThrows(Throwable.class, () -> new ParqueInfantil("", "Descripción", Municipio.ARMENIA));

        LOG.info("Finalizando test ParqueInfantilNombreVacio");
    }

    @Test
    public void ParqueInfantilDescripcionNula() {
        LOG.info("Iniciado test ParqueInfantilDescripcionNula");

        assertThrows(Throwable.class, () -> new ParqueInfantil("Nombre", null, Municipio.ARMENIA));

        LOG.info("Finalizando test ParqueInfantilDescripcionNula");
    }

    @Test
    public void ParqueInfantilDescripcionVacia() {
        LOG.info("Iniciado test ParqueInfantilDescripcionVacia");

        assertThrows(Throwable.class, () -> new ParqueInfantil("Nombre", "", Municipio.ARMENIA));

        LOG.info("Finalizando test ParqueInfantilDescripcionVacia");
    }

    @Test
    public void ValorParqueSinZonas() {
        LOG.info("Iniciado test ValorParqueSinZonas");

        var parque = new ParqueInfantil("Mi primer recuerdo", "Parque para los primero años de edad",
                Municipio.CALARCA);

        assertEquals(10000.0, parque.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorParqueSinZonas");
    }

    @Test
    public void ValorParqueUnaZonaCircular() {
        LOG.info("Iniciado test ValorParqueUnaZonaCircular");

        var parque = new ParqueInfantil("Mi primer recuerdo", "Parque para los primero años de edad",
                Municipio.CALARCA);

        parque.addZona(new ZonaParque("Zona de mascotas", new Circulo(10), Material.ARENA));

        assertEquals(3151592.65, parque.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorParqueUnaZonaCircular");
    }

    @Test
    public void ValorParqueCuatroZonas() {
        LOG.info("Iniciado test ValorParqueCuatroZonas");

        var parque = new ParqueInfantil("Mi primer recuerdo", "Parque para los primero años de edad",
                Municipio.CALARCA);

        parque.addZona(new ZonaParque("Zona de mascotas", new Circulo(10), Material.ARENA));
        parque.addZona(new ZonaParque("Zona rectangular", new Rectangulo(10, 20), Material.GRAMA_SINTETICA));
        parque.addZona(new ZonaParque("Zona cuadrada", new Cuadrado(10), Material.GRAMA_NATURAL));
        parque.addZona(new ZonaParque("Zona triangular", new TrianguloRectangulo(10, 20), Material.ARENA));

        assertEquals(13151592.65, parque.calcularValor(), App.PRECISION);

        LOG.info("Finalizando test ValorParqueCuatroZonas");
    }

    @Test
    public void ParqueZonasIgualNombre() {
        LOG.info("Iniciado test ParqueZonasIgualNombre");

        var parque = new ParqueInfantil("Mi primer recuerdo", "Parque para los primero años de edad",
                Municipio.CALARCA);

        parque.addZona(new ZonaParque("Zona de mascotas", new Circulo(10), Material.ARENA));

        assertThrows(Throwable.class,
                () -> parque.addZona(new ZonaParque("Zona de mascotas", new Circulo(10), Material.ARENA)));

        LOG.info("Finalizando test ParqueZonasIgualNombre");
    }

}
