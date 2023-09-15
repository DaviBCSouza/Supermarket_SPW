package questoes

import SupermercadoWeb

class AP2Questao1 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque().getItens()

            println("*-*-*-*-*-*-*-*-*-*-*-*- ESTOQUE *-*-*-*-*-*-*-*-*-*-*-*-")
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

            for (item in estoque) {
                val codigo = item.getCodigo()
                val nome = item.getProduto().getNome()
                val genero = item.getProduto().getGenero().getNome()
                val marca = item.getProduto().getMarca().toString()
                val preco = String.format("R$%.2f", item.getProduto().getPreco())
                val validade = item.getValidade().toString()
                val valido = if (item.valido()) "Sim" else "Não"

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

            val totalItens = estoque.size
            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main() {
    AP2Questao1.main()
}
