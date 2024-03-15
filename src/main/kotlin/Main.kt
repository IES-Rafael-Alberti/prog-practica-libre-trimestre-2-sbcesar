package org.practicatrim2

import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.terminal.Terminal
import org.practicatrim2.GestionDeDatos.GestionConsola

fun main() {
    val terminal = Terminal()

    val tituloApi = "                                                                                                 BIENVENIDO A STEAM"
    println()
    println()
    terminal.println(TextColors.brightBlue(tituloApi))

    println("Inicio de sesion")
    val usuario = GestionConsola.crearUsuario()
    println("Sesion iniciada correctamente")
    println()

    while (true) {
        GestionConsola.mostrarMenu()
        print("Ingrese su opción: ")
        val opcion = readln().toIntOrNull()

        if (opcion != null) {
            GestionConsola.ejecutarOpcion(opcion, usuario)
        } else {
            println("Opción no válida. Por favor ingrese un número válido.")
        }
    }

}