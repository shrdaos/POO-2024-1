package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Clase abstracta para definir que toda figura geométrica debe tener un método
 * calcularArea.
 * 
 * @author Área de programación UQ
 * @since 2024-04
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class ProyectoGobernacion {
    private Collection<ParqueInfantil> parques;

    /**
     * Método constructor de la clase Proyecto
     */
    public ProyectoGobernacion() {
        this.parques = new LinkedList<>();
    }

    /**
     * Método para adicionar un parque infantil al proyecto
     * 
     * @param parqueInfantil parque infantil que se desea adicionar
     */
    public void addParqueInfantil(ParqueInfantil parqueInfantil) {
        assert !existeParqueInfantil(parqueInfantil.getNombre());

        parques.add(parqueInfantil);
    }

    /**
     * Método para obtener un parque usando el nombre
     * 
     * @param nombre nombre del parque que se desea buscar
     * @return el parque (si existe) que tiene el nombre indicado
     */
    public ParqueInfantil getParque(String nombre) {
        Predicate<ParqueInfantil> nombreIgual = parque -> parque.getNombre().equals(nombre);
        var posibleParque = parques
                .stream()
                .filter(nombreIgual)
                .findAny();

        assert posibleParque.isPresent();

        return posibleParque.get();
    }

    /**
     * Método para obtener los parques ordenados por nombre de un municipio
     * 
     * @param municipio nombre del municipio que se desea obtener los parques
     * @return colección de los parques del municipio ordenado por nombre
     */
    public Collection<ParqueInfantil> getParquesMunicipio(String municipio) {
        var comparador = Comparator.comparing(ParqueInfantil::getNombre);

        var parquesOrdenados = parques
                .stream()
                .filter(parque -> parque.getMunicipio().name().equals(municipio))
                .sorted(comparador)
                .toList();

        return Collections
                .unmodifiableCollection(parquesOrdenados);
    }

    /**
     * Método para obtener la colección de parques ordenado por valor ascendete
     * 
     * @return colección de los parques ordenado por valor
     */
    public Collection<ParqueInfantil> getParquesOrdenValorAscendete() {
        var comparador = Comparator.comparing(ParqueInfantil::calcularValor);
        var parquesOrdenados = parques
                .stream()
                .sorted(comparador)
                .toList();

        return Collections
                .unmodifiableCollection(parquesOrdenados);
    }

    /**
     * Método para obtener el valor total del proyecto
     * 
     * @return valor total del proyecto
     */
    public double calcularValorProyecto() {
        return parques
                .stream()
                .mapToDouble(n -> n.calcularValor()).sum();
    }

    /**
     * Método privado para determinar si ya existe otro parque con el nombre
     * indicado
     * 
     * @param nombre nombre que se desea verificar si existe o no un parque
     * @return valor lógico que indica si existe o no un parque con el nombre
     *         indicado
     */
    private boolean existeParqueInfantil(String nombre) {
        Predicate<ParqueInfantil> nombreIgual = parque -> parque.getNombre().equals(nombre);
        return parques
                .stream()
                .filter(nombreIgual)
                .findAny()
                .isPresent();
    }

}
