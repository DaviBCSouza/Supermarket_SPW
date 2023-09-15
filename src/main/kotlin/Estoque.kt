class Estoque {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun entraItem(item: ItemProduto) {
        itens.add(item)
    }

    fun saiItem(item: ItemProduto): ItemProduto {
        val removido = itens.remove(item)
        if (removido) return item
        else throw IllegalArgumentException("Item não encontrado no estoque")
    }

    fun getItens(marca: Marca): List<ItemProduto> {
        return itens.filter { it.produto.marca == marca }
    }

    fun getItens(produto: Produto): List<ItemProduto> {
        return itens.filter { it.produto == produto }
    }

    fun getItens(genero: Genero): List<ItemProduto> {
        return itens.filter { it.produto.genero == genero }
    }

    fun getItens(): List<ItemProduto> {
        return itens.toList()
    }

    fun qtdItens(): Int {
        return itens.size
    }
}