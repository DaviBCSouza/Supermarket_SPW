abstract class Genero(protected val nome: String) {
    abstract fun get(): String
    abstract fun set(value: String)

    @JvmName("getNomeGenero")
    fun getNome(): String {
        return nome
    }
}