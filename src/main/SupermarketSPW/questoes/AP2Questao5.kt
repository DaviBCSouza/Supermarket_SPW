package questoes

import SupermercadoWeb

class AP2Questao5 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinho = supermercado.getCarrinho()

            // Selecionar os itens do estoque com código ímpar e adicioná-los ao carrinho
            for (item in estoque.getItens().toList()) {
                if (item.getCodigo() % 2 != 0) {
                    if (estoque.getItens().contains(item)) {
                        carrinho.adicionaItem(item, estoque)
                        // Verifica novamente se o item está no estoque antes de removê-lo
                        if (estoque.getItens().contains(item)) {
                            estoque.saiItem(item)
                        }
                    }
                }
            }

            // Mostrar os itens do carrinho, sua quantidade e o valor total
            println("*-*-*-*-*-*-*-* ITENS DO CARRINHO *-*-*-*-*-*-*-*")
            println("%-4s %-20s %-10s %-8s %-10s".format("CÓD", "NOME", "QUANTIDADE", "PREÇO", "TOTAL"))
            println("---  -------------       ---------   ------   ------")

            var valorTotalCarrinho = 0.0

            for (item in carrinho.getItens()) {
                val codigo = item.getCodigo()
                val nome = item.getProduto().getNome()
                val quantidade = carrinho.getItens().size
                val preco = String.format("%.2f", item.getProduto().getPreco()).replace(',', '.')
                val total =
                    String.format("%.2f", quantidade * item.getProduto().getPreco()).replace(',', '.')

                valorTotalCarrinho += total.toDouble()

                println("%-4d %-20s %-10d R$$preco R$$total".format(codigo, nome, quantidade, preco, total))
            }

            // Mostrar os itens restantes no estoque e o total de itens no estoque
            println("\n*-*-*-*-*-*-*-* ITENS RESTANTES NO ESTOQUE *-*-*-*-*-*-*-*")
            println("%-4s %-20s %-10s".format("CÓD", "NOME", "QUANTIDADE"))
            println("---  -------------         ---------")

            for (item in estoque.getItens()) {
                val codigo = item.getCodigo()
                val nome = item.getProduto().getNome()
                val quantidade = estoque.qtdItens()

                println("%-4d %-20s %-10d".format(codigo, nome, quantidade))
            }

            val totalItensEstoque = estoque.qtdItens()
            println("\nTotal de itens no estoque: $totalItensEstoque")
            println("Valor total do carrinho: R$%.2f".format(valorTotalCarrinho))
        }
    }
}

fun main() {
    AP2Questao5.main()
}
