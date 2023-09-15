class Carrinho {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        if (estoque.getItens().contains(item)) {
            estoque.saiItem(item)
            itens.add(item)
        } else {
            throw IllegalArgumentException("Item não disponível no estoque")
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itens.contains(item)) {
            itens.remove(item)
            estoque.entraItem(item)
        } else {
            throw IllegalArgumentException("Item não encontrado no carrinho")
        }
    }

    fun getItens(): List<ItemProduto> {
        return itens.toList()
    }

    fun totalAPagar(): Double {
        return itens.sumOf { it.produto.getPreco() }
    }
}