package questoes

import SupermercadoWeb
import java.util.*

class AFQuestao1 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()

            val scanner = Scanner(System.`in`)
            println("Digite o nome do gênero:")
            val nomeGenero = scanner.nextLine()

            val generoDesejado = supermercado.getGeneros().find { it.getNome().equals(nomeGenero, ignoreCase = true) }

            if (generoDesejado != null) {
                val itensEncontrados = estoque.getItens(generoDesejado)

                if (itensEncontrados.isNotEmpty()) {
                    println("*-*-*-*-*-*-*-* ESTOQUE DO GÊNERO '$nomeGenero' *-*-*-*-*-*-*-*")
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

                    for (item in itensEncontrados) {
                        val codigo = item.getCodigo()
                        val nome = item.getProduto().getNome()
                        val genero = item.getProduto().getGenero().getNome()
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

                    val totalItens = itensEncontrados.size
                    println("\nTOTAL: $totalItens itens.")
                } else {
                    println("Nenhum item do gênero '$nomeGenero' foi encontrado.")
                }
            } else {
                println("Gênero '$nomeGenero' não encontrado.")
            }
        }
    }
}

fun main() {
    AFQuestao1.main()
}