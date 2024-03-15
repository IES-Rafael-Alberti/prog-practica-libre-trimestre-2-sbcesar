package org.practicatrim2.GestionDeDatos

import org.practicatrim2.Steam.Usuario

/**
 * Objeto para gestionar la consola y las interacciones con el usuario.
 */
object GestionConsola {

    /**
     * Muestra un menú con las opciones disponibles para el usuario.
     */
    fun mostrarMenu() {
        println("=== Menú de opciones ===")
        println("1. Mostrar perfil")
        println("2. Modificar perfil")
        println("3. Buscar juego por nombre")
        println("4. Buscar juego por desarrollador")
        println("5. Agregar amigo")
        println("6. Agregar juego a biblioteca")
        println("7. Agregar juego deseado")
        println("8. Salir")
        println("=========================")
        print("Ingrese su opción: ")
    }

    /**
     * Ejecuta la acción correspondiente a la opción seleccionada por el usuario.
     *
     * @param opcion La opción seleccionada por el usuario.
     * @param usuario El usuario actual.
     */
    fun ejecutarOpcion(opcion: Int, usuario: Usuario) {
        when (opcion) {
            1 -> {
                println(usuario.mostrarPerfil())
                println()
            }
            2 -> {
                println("=== Modificar perfil ===")
                println("1. Cambiar nombre")
                println("2. Cambiar nick")
                println("Ingrese la opción:")
                val opcionModificacion = readln().toIntOrNull()
                when (opcionModificacion) {
                    1 -> {
                        print("Ingrese el nuevo nombre: ")
                        val nuevoNombre = readln()
                        usuario.cambiarNombre(nuevoNombre)
                        println("Nombre cambiado exitosamente.")
                    }
                    2 -> {
                        print("Ingrese el nuevo nick: ")
                        val nuevoNick = readln()
                        usuario.cambiarNick(nuevoNick)
                        println("Nick cambiado exitosamente.")
                    }
                    else -> println("Opción no válida")
                }
            }
            3 -> {
                println("=== Buscando juego por nombre ===")
                println("Introduce el nombre del juego a buscar: ")
                val nombreJuego = readln()
                buscarJuegoNombre(nombreJuego)
            }
            4 -> {
                println("=== Buscando juego por desarrollador ===")
                println("Introduce el nombre del desarrollador a buscar: ")
                val nombreDesarrollador = readln()
                buscarJuegoDesarrollador(nombreDesarrollador)
            }
            5 -> {
                //AgregarAmigo
            }
            6 -> {
                //Agregar juego a biblioteca
            }
            7 -> {
                //Agrega juegos a la lista de deseados
            }
            8 -> {
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción no válida")
        }
    }

    /**
     * Crea un nuevo usuario a partir de la información proporcionada por el usuario.
     *
     * @return El nuevo usuario creado.
     */
    fun crearUsuario(): Usuario {
        print("Nombre: ")
        val nombre = readln()
        print("Nick: ")
        val nick = readln()

        return Usuario(nombre, nick)
    }

    /**
     * Busca un juego por su nombre en la base de datos de juegos.
     *
     * @param nombre El nombre del juego a buscar.
     */
    private fun buscarJuegoNombre(nombre: String) {
        val gestionJuegos = GestionJuegos()
        val indice = gestionJuegos.obtenerNombre().indexOf(nombre)

        if (indice != -1) {
            println("Juegos por nombre: ")
            println("Nombre: ${gestionJuegos.obtenerNombre()[indice]}")
            println("Descripción: ${gestionJuegos.obtenerDescripcion()[indice]}")
            println("Espacio de Almacenamiento: ${gestionJuegos.obtenerEspacioAlmacenamiento()[indice]} GB")
            println("Precio: ${gestionJuegos.obtenerPrecio()[indice]}")
            println("Desarrollador: ${gestionJuegos.obtenerDesarrollador()[indice]}")
            println("Fecha de Lanzamiento: ${gestionJuegos.obtenerFechaLanzamiento()[indice]}")
            println("Tipo de Juego: ${gestionJuegos.obtenerTipoJuego()[indice]}")
        } else {
            println("El juego no fue encontrado.")
        }
    }

    /**
     * Busca juegos desarrollados por un determinado desarrollador en la base de datos de juegos.
     *
     * @param desarrollador El nombre del desarrollador cuyos juegos se quieren buscar.
     */
    private fun buscarJuegoDesarrollador(desarrollador: String) {
        val gestionJuegos = GestionJuegos()
        val juegosPorDesarrollador = gestionJuegos.obtenerDesarrollador()
            .mapIndexedNotNull { c, v -> if (v.toString() == desarrollador) c else null }

        if (juegosPorDesarrollador.isNotEmpty()) {
            println("Juegos desarrollados por $desarrollador:")
            juegosPorDesarrollador.forEach { indice ->
                println("Nombre: ${gestionJuegos.obtenerNombre()[indice]}")
                println("Descripción: ${gestionJuegos.obtenerDescripcion()[indice]}")
                println("Espacio de Almacenamiento: ${gestionJuegos.obtenerEspacioAlmacenamiento()[indice]} GB")
                println("Precio: ${gestionJuegos.obtenerPrecio()[indice]}")
                println("Fecha de Lanzamiento: ${gestionJuegos.obtenerFechaLanzamiento()[indice]}")
                println("Tipo de Juego: ${gestionJuegos.obtenerTipoJuego()[indice]}")
            }
        } else {
            println("No se encontraron juegos desarrollados por $desarrollador.")
        }
    }

}