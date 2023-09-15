package questoes

import Produto
import SupermercadoWeb

class AFQuestao3 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val produtos = supermercado.getProdutos()

            val produtosMaisBaratos = mutableMapOf<String, Produto>()

            for (produto in produtos) {
                val genero = produto.getGenero().getNome()
                val preco = produto.getPreco()

                if (!produtosMaisBaratos.containsKey(genero) || preco < produtosMaisBaratos[genero]!!.getPreco()) {
                    produtosMaisBaratos[genero] = produto
                }
            }

            println("*-*-*-*-*-*-*-* PRODUTOS MAIS BARATOS POR GÊNERO *-*-*-*-*-*-*-*")
            println("%-20s %-20s %-8s".format("GENERO", "NOME", "PREÇO"))
            println("--------           ----------            -------")

            for ((genero, produto) in produtosMaisBaratos) {
                val nome = produto.getNome()
                val preco = String.format("R$%.2f", produto.getPreco())

                println("%-20s %-20s %-8s".format(genero, nome, preco))
            }
        }
    }
}

fun main() {
    AFQuestao3.main()
}