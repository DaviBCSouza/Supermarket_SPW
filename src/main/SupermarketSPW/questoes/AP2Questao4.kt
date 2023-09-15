package questoes

import SupermercadoWeb

class AP2Questao4 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque().getItens()

            val itensValidos = estoque.filter { it.valido() }.size
            val itensVencidos = estoque.filter { !it.valido() }.size
            val totalItens = estoque.size

            val somaValidosEVencidos = itensValidos + itensVencidos

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

            println("\nItens válidos (não vencidos): $itensValidos")
            println("Itens vencidos: $itensVencidos")
            println("Soma dos itens válidos e vencidos: $somaValidosEVencidos")

            if (somaValidosEVencidos == totalItens) {
                println("A soma dos itens válidos e vencidos é igual ao total de itens no estoque.")
            } else {
                println("A soma dos itens válidos e vencidos é diferente do total de itens no estoque.")
            }

            println("\nTOTAL: $totalItens itens.")
        }
    }
}

fun main() {
    AP2Questao4.main()
}

