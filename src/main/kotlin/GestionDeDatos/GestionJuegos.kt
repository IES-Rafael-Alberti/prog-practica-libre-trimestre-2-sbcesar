package org.practicatrim2.GestionDeDatos

import org.practicatrim2.Steam.Juego
import java.io.File

/**
 * Clase que gestiona la carga y obtención de datos de los juegos desde un archivo.
 */
class GestionJuegos {

    private val listaJuegos = mutableListOf<Juego>()
    private val espaciosAlmacenamiento = mutableListOf<Double>()
    private val precios = mutableListOf<Double>()

    companion object {
        /** Ruta del archivo de base de datos de juegos. */
        const val NOMBREARCHIVOS = "kotlin/BaseDeDatos/JuegosBaseDeDatos.txt"
    }

    init {
        cargarJuegos()
    }

    /**
     * Carga los juegos desde el archivo de base de datos.
     *
     * @return La lista de juegos cargada desde el archivo.
     */
    private fun cargarJuegos():List<Juego> {

        val listaJuegos = mutableListOf<Juego>()

        try {
            val archivoUrl = ClassLoader.getSystemResource(NOMBREARCHIVOS)
            archivoUrl?.openStream()?.bufferedReader()?.useLines { lines ->
                lines.forEach { linea ->
                    val datos = linea.split(":")
                    if (datos.size == 7) {
                        try {
                            val nombre = datos[0]
                            val descripcion = datos[1]
                            val espacioAlmacenamiento = datos[2].toDouble()
                            val precio = datos[3].replace(',', '.').toDouble()
                            val desarrollador = datos[4]
                            val fechaLanzamiento = datos[5]
                            val tipoJuego = datos[6]

                            val juego = Juego(nombre, descripcion, espacioAlmacenamiento, precio, desarrollador, fechaLanzamiento, tipoJuego)
                            listaJuegos.add(juego)
                        } catch (e: NumberFormatException) {
                            println("Error - Error al convertir datos en la línea $linea: ${e.message}")
                        }
                    } else {
                        println("Error - Formato incorrecto en la línea $linea")
                    }
                }
            } ?: println("Error - El archivo de base de datos no se encuentra.")
        } catch (e: Exception) {
            println("Error - ${e.message}")
        }

        return listaJuegos
    }

    /**
     * Obtiene los nombres de los juegos.
     *
     * @return Una cadena con los nombres de los juegos.
     */
    fun obtenerNombre(): String{
        return listaJuegos.map { it.nombre }.joinToString { "\n" }
    }

    /**
     * Obtiene las descripciones de los juegos.
     *
     * @return Una cadena con las descripciones de los juegos.
     */
    fun obtenerDescripcion(): String {
        return listaJuegos.joinToString("\n") { it.descripcion }
    }

    /**
     * Obtiene los espacios de almacenamiento de los juegos.
     *
     * @return Una lista de los espacios de almacenamiento de los juegos.
     */
    fun obtenerEspacioAlmacenamiento(): List<Double> {
        return espaciosAlmacenamiento
    }

    /**
     * Obtiene los precios de los juegos.
     *
     * @return Una lista de los precios de los juegos.
     */
    fun obtenerPrecio(): List<Double> {
        return precios
    }

    /**
     * Obtiene los desarrolladores de los juegos.
     *
     * @return Una cadena con los desarrolladores de los juegos.
     */
    fun obtenerDesarrollador(): String {
        return listaJuegos.map { it.desarrollador }.distinct().joinToString("\n")
    }

    /**
     * Obtiene las fechas de lanzamiento de los juegos.
     *
     * @return Una cadena con las fechas de lanzamiento de los juegos.
     */
    fun obtenerFechaLanzamiento(): String {
        return listaJuegos.joinToString("\n") { it.fechaLanzamiento }
    }

    /**
     * Obtiene los tipos de juego de los juegos.
     *
     * @return Una cadena con los tipos de juego de los juegos.
     */
    fun obtenerTipoJuego(): String {
        return listaJuegos.joinToString("\n") { it.tipoJuego }
    }


}