class Produto(private val codigo: Int, private var nome: String, private val preco: Double, val marca: Marca, val genero: Genero) {
    override fun toString(): String {
        return "$nome (${marca.getNome()})"
    }

    fun getCodigo(): Int {
        return codigo
    }

    @JvmName("getNomeProduto")
    fun getNome(): String {
        return nome
    }

    fun getPreco(): Double {
        return preco
    }

    @JvmName("getMarcaProduto")
    fun getMarca(): Marca {
        return marca
    }

    @JvmName("getGeneroProduto")
    fun getGenero(): Genero {
        return genero
    }
}
