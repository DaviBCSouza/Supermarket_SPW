package generos

import Genero

class Achocolatado(nome: String) : Genero(nome) {
    override fun get(): String {
        return nome
    }

    override fun set(value: String) {
        // Implementação específica para Achocolatado
    }
}