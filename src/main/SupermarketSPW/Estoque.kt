import java.text.SimpleDateFormat

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

    fun getItens(dataReferencia: String): List<ItemProduto> {
        val itensAntigos = mutableListOf<ItemProduto>()

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dataReferenciaDate = dateFormat.parse(dataReferencia)

        for (item in itens) {
            val dataValidadeItem = dateFormat.parse(item.getValidade().toString())
            if (!item.valido() || dataValidadeItem.before(dataReferenciaDate)) {
                itensAntigos.add(item)
            }
        }

        return itensAntigos
    }

    fun removeItensVencidos(): List<ItemProduto> {
        val itensValidos = mutableListOf<ItemProduto>()

        for (item in itens) {
            if (!item.valido()) {
                itensValidos.add(item)
            }
        }

        itens.clear()
        itens.addAll(itensValidos)

        return itensValidos
    }

    fun qtdItens(): Int {
        return itens.size
    }
}