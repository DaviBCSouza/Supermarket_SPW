package questoes

import SupermercadoWeb
import java.text.SimpleDateFormat
import java.util.*

class AFQuestao2 {
    companion object {
        fun main() {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()

            val scanner = Scanner(System.`in`)
            println("Digite a data de referência (dia/mês/ano):")
            val dataBusca = scanner.nextLine()

            val dataReferencia = try {
                val formato = SimpleDateFormat("dd/MM/yyyy")
                formato.parse(dataBusca)
            } catch (e: Exception) {
                println("Data de referência inválida.")
                return
            }

            val itensEncontrados = estoque.getItens(dataBusca)

            if (itensEncontrados.isNotEmpty()) {
                println("*-*-*-*-*-*-*-* ITENS COM DATA DE VALIDADE ANTIGA *-*-*-*-*-*-*-*")
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
                println("Nenhum item com data de validade antiga foi encontrado.")
            }
        }
    }
}

fun main() {
    AFQuestao2.main()
}