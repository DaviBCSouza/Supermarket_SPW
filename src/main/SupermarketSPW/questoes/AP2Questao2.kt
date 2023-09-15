package questoes

import SupermercadoWeb

class AP2Questao2 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque().getItens()

            val generos = estoque.groupBy { it.getProduto().getGenero().getNome() }

            println("*-*-*-*-*-*-*-* ESTOQUE POR GÊNERO *-*-*-*-*-*-*-*")

            for ((genero, itens) in generos) {
                println("\n$genero:")
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

                for (item in itens) {
                    val codigo = item.getCodigo()
                    val nome = item.getProduto().getNome()
                    val marca = item.getProduto().getMarca().getNome()
                    val preco = String.format("R$%.2f", item.getProduto().getPreco())
                    val validade = item.getValidade().toString()
                    val valido = if (item.valido()) "sim" else "não"

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

                val totalItens = itens.size
                println("\nTOTAL GENERO: $totalItens itens.")
            }

            val totalGeral = estoque.size
            println("\nTOTAL: $totalGeral itens.")
        }
    }
}

fun main() {
    AP2Questao2.main()
}