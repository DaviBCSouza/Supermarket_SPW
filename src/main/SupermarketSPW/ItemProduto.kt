class ItemProduto(private val codigo: Int, var nome: String, private val validade: Data, val produto: Produto) {
    override fun toString(): String {
        return "$nome (${produto.getNome()}), Val: $validade"
    }

    fun getCodigo(): Int {
        return codigo
    }


    @JvmName("getNomeItemProduto")
    fun getNome(): String {
        return nome
    }

    fun getValidade(): Data {
        return validade
    }

    @JvmName("getProdutoItemProduto")
    fun getProduto(): Produto {
        return produto
    }

    fun valido(): Boolean {
        val hoje = Data.dataHoje()
        return !validade.antes(hoje)
    }
}