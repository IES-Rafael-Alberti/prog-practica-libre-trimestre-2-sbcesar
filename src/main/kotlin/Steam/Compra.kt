package org.practicatrim2.Steam

class Compra(val juego: Juego) {
    companion object {
        var codigoCompra = 0
    }

    fun generarCodigoCompra() {
        codigoCompra++
    }

    fun comprarJuego() {
        TODO("Compra el juego")
    }

    fun devolverJuego() {
        TODO("Devuelve el juego")
    }

    fun reservarJuego() {
        TODO("Reserva el juego si fechaSalida > fechaActual")
    }

    fun cancelarReserva() {
        TODO("Cancela la reserva, si estadoJuego == reservado se puede cancelar")
    }
}