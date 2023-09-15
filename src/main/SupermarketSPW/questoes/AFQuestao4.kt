package questoes

import SupermercadoWeb

class AFQuestao4 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()

            var lucroPotencial = 0.0
            for (item in estoque.getItens()) {
                lucroPotencial += item.getProduto().getPreco()
            }

            println("*-*-*-*-*-*-*-* ESTOQUE ATUAL COM LUCRO POTENCIAL *-*-*-*-*-*-*-*")
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

            println("TOTAL DE ITENS: ${estoque.getItens().size}")
            println("LUCRO POTENCIAL: R$${String.format("%.2f", lucroPotencial)}")

            val itensVencidos = estoque.removeItensVencidos()
            var prejuizo = 0.0
            for (item in itensVencidos) {
                prejuizo += item.getProduto().getPreco()
            }

            println("\n*-*-*-*-*-*-*-* ESTOQUE SEM ITENS VENCIDOS *-*-*-*-*-*-*-*")
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

            println("TOTAL DE ITENS: ${estoque.getItens().size}")

            println("\nPREJUÍZO COM ITENS VENCIDOS: R$${String.format("%.2f", prejuizo)}")
            val lucroReal = lucroPotencial - prejuizo
            println("LUCRO REAL: R$${String.format("%.2f", lucroReal)}")
        }
    }
}

fun main() {
    AFQuestao4.main()
}