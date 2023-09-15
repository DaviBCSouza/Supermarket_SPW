package questoes

import SupermercadoWeb

class AP2Questao3 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque().getItens().filter { it.valido() }

            val generosMarcas = estoque.groupBy { "${it.getProduto().getGenero()} - ${it.getProduto().getMarca()}" }

            println("*-*-*-*-*-*-*-* ESTOQUE POR GÊNERO E NOME *-*-*-*-*-*-*-*")
            println(
                "%-4s %-20s %-20s %-10s %-8s %-10s %-7s".format(
                    "CÓD",
                    "NOME",
                    "GENERO",
                    "MARCA",
                    "PREÇO",
                    "VALIDADE",
                    "VÁLIDO"
                )
            )
            println("---  -----------         -------------         ------    -------   -------- -------")

            for ((_, itens) in generosMarcas) {
                for (item in itens) {
                    val codigo = item.getCodigo()
                    val nome = item.getProduto().getNome()
                    val genero = item.getProduto().getGenero().getNome()
                    val marca = item.getProduto().getMarca().getNome()
                    val preco = String.format("R$%.2f", item.getProduto().getPreco())
                    val validade = item.getValidade().toString()
                    val valido = "sim"

                    println(
                        "%-4d %-20s %-20s %-10s %-8s %-10s %-7s".format(
                            codigo,
                            nome,
                            genero,
                            marca,
                            preco,
                            validade,
                            valido
                        )
                    )
                }
            }

            val totalItens = estoque.size
            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main() {
    AP2Questao3.main()
}