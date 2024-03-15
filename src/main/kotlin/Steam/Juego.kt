package org.practicatrim2.Steam

import java.time.DateTimeException
import java.time.LocalDate

/**
 * Clase que representa un juego en la plataforma Steam.
 *
 * @property nombre El nombre del juego.
 * @property descripcion La descripción del juego.
 * @property espacioAlmacenamiento El espacio de almacenamiento requerido por el juego en GB.
 * @property precio El precio del juego.
 * @property desarrollador El nombre del desarrollador del juego.
 * @property fechaLanzamiento La fecha de lanzamiento del juego en formato "dd-MM-yyyy".
 * @property tipoJuego El tipo de juego, puede ser "Multiplayer" o "SinglePlayer".
 */
class Juego(
    val nombre: String,
    val descripcion: String,
    val espacioAlmacenamiento: Double,
    val precio: Double,
    val desarrollador: String,
    val fechaLanzamiento: String,
    val tipoJuego: String
) {
    init {
        require(nombre.isNotBlank()) { "El nombre del juego no puede estar vacío." }
        require(descripcion.isNotBlank()) { "La descripción del juego no puede estar vacía." }
        require(espacioAlmacenamiento >= 0) { "El espacio de almacenamiento no debe ser negativo." }
        require(precio >= 0) { "El precio no debe ser negativo." }
        require(desarrollador.isNotBlank()) { "El nombre del desarrollador no puede estar vacío." }
        require(validarFechaLanzamiento(fechaLanzamiento)) { "El formato de la fecha de lanzamiento debe ser 'dd-mm-yyyy'." }
        require(tipoJuego != "Multiplayer" && tipoJuego != "SinglePlayer") { "Tipo de juego erroneo." }
    }

    /**
     * Valida el formato de la fecha de lanzamiento.
     *
     * @param fecha La fecha de lanzamiento a validar.
     * @return `true` si el formato es válido, `false` de lo contrario.
     */
    private fun validarFechaLanzamiento(fecha: String) : Boolean {
        return try {
            LocalDate.parse(fecha, java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            true
        } catch (e: DateTimeException) {
            false
        }
    }



}