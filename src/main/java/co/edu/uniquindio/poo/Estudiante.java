package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Clase para manejar la información de un Estudiante
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Estudiante {
    private final String nombres;
    private final String apellidos;
    private final String numeroIdentificacion;
    private final String correo;
    private final String telefono;
    private final int edad;
    private final Collection<NotaObtenida> notasObtenidas;

    /**
     * Método constructor de la clase Estudiante
     * 
     * @param nombres              nombres del estudiante
     * @param apellidos            apellidos del estudiante
     * @param numeroIdentificacion número de identificación del estudiante
     * @param correo               correo electrónico del estudiante
     * @param telefono             teléfono del estudiante
     * @param edad                 edad del estudiante
     */
    public Estudiante(String nombres, String apellidos, String numeroIdentificacion, String correo, String telefono,
            int edad) {
        assert nombres != null && !nombres.isBlank() : "El nombre debe ser diferente de null";
        assert apellidos != null && !apellidos.isBlank() : "El apellido debe ser diferente de null";
        assert numeroIdentificacion != null && !numeroIdentificacion.isBlank()
                : "El número de identificación debe ser diferente de null";
        assert correo != null && correo.contains("@") : "El correo electrónico debe contener el símbolo @";
        assert telefono != null : "El teléfono no puede ser null";
        assert edad > 0 : "La edad debe ser mayor a cero";

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;

        this.notasObtenidas = new LinkedList<>();
    }

    /**
     * Método para obtener los nombres del estudiante
     * 
     * @return los nombres del estudiante
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método para obtener los apellidos del estudiante
     * 
     * @return los apellidos del estudiante
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método para obtener el número de identificación del estudiante
     * 
     * @return número de identificación del estudiante
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Método para obtener el correo electrónico del estudiante
     * 
     * @return correo electrónico del estudiante
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método para obtener el teléfono del estudiante
     * 
     * @return teléfono del estudiante
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para obtener la edad del estudiante
     * 
     * @return edad del estudiante
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método para adicionar una nota obtenida al estudiante
     * 
     * @param notaObtenida nota obtenida por el estudiante
     */
    public void adicionarNotaObtenida(NotaObtenida notaObtenida) {
        verificarExistenciaNotaObtenida(notaObtenida);
        notasObtenidas.add(notaObtenida);
    }

    /**
     * Método de apoyo (privado) para verificar si existe o no la nota obtenida que
     * se desea adicionar
     * 
     * @param notaObtenida nota obtenida que se quiere verificar que NO exista.
     */
    private void verificarExistenciaNotaObtenida(NotaObtenida nuevaNotaObtenida) {
        boolean esNotaObtenida = false;

        for (NotaObtenida notaObtenida : notasObtenidas) {
            
            if (notaObtenida.getNotaParcial().nombre()
                .equals(nuevaNotaObtenida.getNotaParcial().nombre()))
                esNotaObtenida = true;


        }

        assert !esNotaObtenida;
    }

    /**
     * Método para obtener la nota obtenida dado el nombre de la nota parcial
     * 
     * @param nombreNotaParcial nombre de la nota parcial que se desea buscar.
     * @return la nota obtenida asociada a la nota parcial
     */
    public NotaObtenida getNotaObtenida(String nombreNotaParcial) {
        var posibleNotaObtenida = buscarNotaParcial(nombreNotaParcial);
        assert posibleNotaObtenida.isPresent();

        return posibleNotaObtenida.get();
    }

    /**
     * Método de apoyo (privado) para buscar una posible nota obtenida asociada a
     * una nota parcial
     * 
     * @param nombreNotaParcial nombre de la nota parcial asociada a la nota
     *                          obtenida
     * @return posible nota obtenida (si existe) asociada a la nota parcial del
     *         nombre indicado
     */
    private Optional<NotaObtenida> buscarNotaParcial(String nombreNotaParcial) {
        for (NotaObtenida notaObtenida : notasObtenidas) {
            if(notaObtenida.getNotaParcial().nombre().equals(nombreNotaParcial))
            return Optional.of(notaObtenida);
        }

        return Optional.empty();
    }

    /**
     * Método para obtener una colección NO modificable de las notas parciales del
     * curso.
     * 
     * @return colección no modificable de las notas parciales del curso
     */
    public Collection<NotaObtenida> getNotasObtenidas() {
        return Collections.unmodifiableCollection(notasObtenidas);
    }

    /**
     * Método para actualizar la nota que tiene una nota obtenida por el estudiante
     * 
     * @param nombreNotaParcial nombre de la nota parcial a la que la nota está
     *                          asociada
     * @param notaObtenida      nueva nota obtenida
     */
    public void setNotaObtenida(String nombreNotaParcial, double nuevaNotaObtenida) {
        assert nuevaNotaObtenida >= 0.0 : "La nota obtenida no puede ser menor a cero";
        assert nuevaNotaObtenida <= 5.0 : "La nota obtenida no puede ser mayor a cinco";
        NotaObtenida notaActual= null;
        for (NotaObtenida notaObtenida : notasObtenidas) {
            if(notaObtenida.getNotaParcial().nombre().equals(nombreNotaParcial))
            {
                notaActual = notaObtenida;
                break;
            }
        } 
        assert notaActual != null;

        notaActual.setNotaObtenida(nuevaNotaObtenida);
    }

    /**
     * Método para obtener la nota definitiva usando un promedio ponderado suma de
     * todas (nota * porcentaje)
     * 
     * @return nota definitiva
     */
    public double getDefinitiva() {
        validarNotas100Porciento();
        double definitiva = 0.0;
        for (NotaObtenida notaObtenida : notasObtenidas) {
            double notaParcial = notaObtenida.getNotaObtenida() * notaObtenida.getNotaParcial().porcentaje();
            definitiva += notaParcial;
        }
        return definitiva;
    }

    /**
     * Método de apoyo (privado) para validar que la suma del porcentaje de las
     * notas obtenidas sea 1.0 (100%)
     */
    private void validarNotas100Porciento() {

        double pesoNotas = 0.0;
        for (NotaObtenida notaObtenida : notasObtenidas) {
            double porcentaje = notaObtenida.getNotaParcial().porcentaje();
            pesoNotas += porcentaje;
        }
        assert (1.0 - pesoNotas) <= App.PRECISION : "Las notas parciales no suman 1.0 (100%)";
    }

}
