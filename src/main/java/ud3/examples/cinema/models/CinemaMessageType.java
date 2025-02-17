package ud3.examples.cinema.models;

import java.io.Serializable;

/**
 * Enumeració amb els diferents tipus de missatges que podem trobar
 * <p>
 * Aquesta classe implementa Serialitzable per poder ser convertida a
 * bytes i poder ser enviada mitjançant sockets.
 */
public enum CinemaMessageType implements Serializable {
    /**
     * El tipus GET s'utilitza per sol·licitar algun element del servidor
     */
    GET,
    /**
     * El tipus POST s'utilitza per enviar algun element al servidor
     */
    POST,
    /**
     * El tipus SUCCESS s'utilitza per indicar que l'acció s'ha dut a terme correctament
     */
    SUCCESS,
    /**
     * El tipus ERROR s'utilitza per indicar que l'acció no s'ha dut a terme correctament
     */
    ERROR
}
