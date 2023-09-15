package questoes

import ItemProduto
import SupermercadoWeb
import java.util.*

class AP2Questao7 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()

            val scanner = Scanner(System.`in`)
            println("Digite o nome da marca:")
            val nomeMarca = scanner.nextLine()

            val itensEncontrados = mutableListOf<ItemProduto>()

            for (item in estoque.getItens()) {
                val marca = item.getProduto().getMarca()
                if (marca.getNome().equals(nomeMarca, ignoreCase = true) && item.valido()) {
                    itensEncontrados.add(item)
                }
            }

            if (itensEncontrados.isNotEmpty()) {
                println("*-*-*-*-*-*-*-* ITENS ENCONTRADOS DA MARCA '$nomeMarca' *-*-*-*-*-*-*-*")
                println("%-4s %-20s %-10s".format("CÓD", "NOME", "QUANTIDADE"))
                println("---  -------------         ---------")

                for (item in itensEncontrados) {
                    val quantidade = estoque.qtdItens()
                    println("%-4d %-20s %-10d".format(item.getCodigo(), item.getProduto().getNome(), quantidade))
                }
            } else {
                println("Nenhum item válido da marca '$nomeMarca' foi encontrado.")
            }
        }
    }
}

fun main() {
    AP2Questao7.main()
}