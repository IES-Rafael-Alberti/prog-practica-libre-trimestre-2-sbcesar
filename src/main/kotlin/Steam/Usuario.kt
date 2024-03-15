package org.practicatrim2.Steam

/**
 * Clase que representa a un usuario de la plataforma Steam.
 *
 * @property nombre El nombre del usuario.
 * @property nick El apodo del usuario.
 */
class Usuario(
    private var nombre: String,
    private var nick: String,
) {
    private val biblioteca:Biblioteca = Biblioteca()
    private val amigos: MutableList<Usuario> = mutableListOf()
    private val juegosDeseados: MutableList<Juego> = mutableListOf()

    companion object {
        lateinit var ID: String
    }

    init {
        ID = generarIdRandom()
    }

    /**
     * Genera un ID aleatorio para el usuario.
     *
     * @return El ID generado.
     */
    private fun generarIdRandom(): String {
        val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        val id = (1..4)
            .map { caracteres.random() }
            .joinToString("")
        return id
    }

    /**
     * Cambia el nombre del usuario.
     *
     * @param nuevoNombre El nuevo nombre del usuario.
     */
    fun cambiarNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    /**
     * Cambia el apodo del usuario.
     *
     * @param nuevoNick El nuevo apodo del usuario.
     */
    fun cambiarNick(nuevoNick: String) {
        nick = nuevoNick
    }

    /**
     * Agrega un usuario a la lista de amigos.
     *
     * @param usuario El usuario que se desea agregar como amigo.
     */
    fun agregarAmigo(usuario: Usuario) {
        amigos.add(usuario)
    }

    /**
     * Agrega un juego a la biblioteca del usuario.
     *
     * @param juego El juego que se desea agregar a la biblioteca del usuario.
     */
    fun agregarJuegoABiblioteca(juego: Juego) {
        biblioteca.agregarJuego(juego)
    }

    /**
     * Agrega un juego a la lista de juegos deseados del usuario.
     *
     * @param juego El juego que se desea agregar a la lista de juegos deseados del usuario.
     */
    fun agregarJuegoDeseado(juego: Juego) {
        juegosDeseados.add(juego)
    }

    /**
     * Devuelve una representación en cadena del perfil del usuario.
     *
     * @return Una cadena que representa el perfil del usuario.
     */
    fun mostrarPerfil() : String {
        return "\nID: $ID\nNombre: $nombre\nNick: $nick"
    }

}