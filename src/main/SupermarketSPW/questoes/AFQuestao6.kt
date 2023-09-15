class AFQuestao6 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()

            val estoque = supermercado.getEstoque()
            val carrinhoA = supermercado.getCarrinhoA()
            val carrinhoB = supermercado.getCarrinhoB()

            estoque.getItens().filter { it.valido() }.forEach {
                carrinhoA.adicionaItem(it, estoque)
            }

            estoque.getItens().filter { !it.valido() }.forEach {
                carrinhoB.adicionaItem(it, estoque)
            }

            println("*-*-*-*-*-*-*-* ESTOQUE *-*-*-*-*-*-*-*")
            estoque.getItens().forEach {
                println(it.toString())
            }

            println("\n*-*-*-*-*-*-*-* CARRINHO A *-*-*-*-*-*-*-*")
            carrinhoA.getItens().forEach {
                println(it.toString())
            }

            println("\n*-*-*-*-*-*-*-* CARRINHO B *-*-*-*-*-*-*-*")
            carrinhoB.getItens().forEach {
                println(it.toString())
            }
        }
    }
}

fun main() {
    AFQuestao6.main()
}