package questoes

import SupermercadoWeb
import java.util.*

class AP2Questao6 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinho = supermercado.getCarrinho()
            val random = Random()

            val quantidadeItensNoCarrinho = random.nextInt(estoque.qtdItens() + 1)

            for (i in 0..<quantidadeItensNoCarrinho) {
                val itemSelecionado = estoque.getItens().random()

                if (!itemSelecionado.valido()) {
                    carrinho.adicionaItem(itemSelecionado, estoque)
                }
            }

            println("*-*-*-*-*-*-*-* ITENS DO CARRINHO *-*-*-*-*-*-*-*")
            println("%-4s %-20s %-10s".format("CÓD", "NOME", "QUANTIDADE"))
            println("---  -------------         ---------")

            for (item in carrinho.getItens()) {
                val quantidade = carrinho.getItens().size
                println("%-4d %-20s %-10d".format(item.getCodigo(), item.getProduto().getNome(), quantidade))
            }

            println("\n*-*-*-*-*-*-*-* ITENS RESTANTES NO ESTOQUE *-*-*-*-*-*-*-*")
            println("%-4s %-20s %-10s".format("CÓD", "NOME", "QUANTIDADE"))
            println("---  -------------         ---------")

            for (item in estoque.getItens()) {
                val quantidade = estoque.qtdItens()
                println("%-4d %-20s %-10d".format(item.getCodigo(), item.getProduto().getNome(), quantidade))
            }

            val totalItensEstoque = estoque.qtdItens()
            println("\nTotal de itens no estoque: $totalItensEstoque")
        }
    }
}

fun main() {
    AP2Questao6.main()
}