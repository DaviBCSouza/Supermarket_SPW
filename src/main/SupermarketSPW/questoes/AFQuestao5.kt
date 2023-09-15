package questoes

import Carrinho
import Estoque
import SupermercadoWeb

class AFQuestao5 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinho = supermercado.getCarrinho()

            val copiaEstoque = estoque.getItens().toMutableList()

            println("*-*-*-*-*-*-*-* ESTOQUE INICIAL E CARRINHO VAZIO *-*-*-*-*-*-*-*")
            mostrarEstoqueItens(estoque, carrinho)

            for (i in 1..10) {
                val itemAleatorio = copiaEstoque.randomOrNull()
                if (itemAleatorio != null) {
                    carrinho.adicionaItem(itemAleatorio, estoque)
                    copiaEstoque.remove(itemAleatorio)
                }
            }

            println("\n*-*-*-*-*-*-*-* ESTOQUE APÓS PREENCHER O CARRINHO *-*-*-*-*-*-*-*")
            mostrarEstoqueItens(estoque, carrinho)

            for (item in carrinho.getItens()) {
                estoque.entraItem(item)
            }

            carrinho.limparCarrinho()

            println("\n*-*-*-*-*-*-*-* ESTOQUE APÓS RECONECTAR ITENS DO CARRINHO E LIMPAR O CARRINHO *-*-*-*-*-*-*-*")
            mostrarEstoqueItens(estoque, carrinho)
        }

        private fun mostrarEstoqueItens(estoque: Estoque, carrinho: Carrinho) {
            println("%-4s %-20s %-20s %-10s %-8s".format("CÓD", "NOME", "GENERO", "MARCA", "PREÇO"))
            println("--- -------------         -------------       --------- -------")

            for (item in estoque.getItens()) {
                val codigo = item.getCodigo()
                val nome = item.getProduto().getNome()
                val genero = item.getProduto().getGenero().getNome()
                val marca = item.getProduto().getMarca().getNome()
                val preco = String.format("R$%.2f", item.getProduto().getPreco())

                println("%-4s %-20s %-20s %-10s %-8s".format(codigo, nome, genero, marca, preco))
            }

            println("\n*-*-*-*-*-*-*-* CARRINHO *-*-*-*-*-*-*-*")
            println("%-4s %-20s %-20s %-10s %-8s".format("CÓD", "NOME", "GENERO", "MARCA", "PREÇO"))
            println("--- -------------         -------------       --------- -------")

            for (item in carrinho.getItens()) {
                val codigo = item.getCodigo()
                val nome = item.getProduto().getNome()
                val genero = item.getProduto().getGenero().getNome()
                val marca = item.getProduto().getMarca().getNome()
                val preco = String.format("R$%.2f", item.getProduto().getPreco())

                println("%-4s %-20s %-20s %-10s %-8s".format(codigo, nome, genero, marca, preco))
            }
        }
    }
}

fun main() {
    AFQuestao5.main()
}