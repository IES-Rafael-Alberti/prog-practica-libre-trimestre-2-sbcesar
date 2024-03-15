package org.practicatrim2.Steam

class Biblioteca {
    private val juegos = mutableListOf<Juego>()

    fun agregarJuego(juego: Juego) {
        juegos.add(juego)
    }

    fun quitarJuego(juego: Juego) {
        juegos.remove(juego)
    }

    fun mostrarBiblioteca(): List<Juego> {
        return juegos.toList()
    }
}