import generos.Achocolatado
import generos.Leite
import generos.Presunto
import kotlin.random.Random

class SupermercadoWeb {
    private val estoque = Estoque()
    private val generos = mutableListOf<Genero>()
    private val marcas = mutableListOf<Marca>()
    private val produtos = mutableListOf<Produto>()
    private val carrinho = Carrinho()

    init {
        iniciaSupermercado()
    }

    fun getEstoque(): Estoque {
        return estoque
    }

    fun getGeneros(): List<Genero> {
        return generos.toList()
    }

    fun getMarcas(): List<Marca> {
        return marcas.toList()
    }

    fun getProdutos(): List<Produto> {
        return produtos.toList()
    }

    fun getCarrinho(): Carrinho {
        return carrinho
    }

    private fun iniciaSupermercado() {
        // Criação das marcas
        val marca1 = Marca("Nestlé")
        val marca2 = Marca("Itambé")
        val marca3 = Marca("Duleite")
        val marca4 = Marca("Parmalat")
        val marca5 = Marca("ABF")
        val marca6 = Marca("Pepsico do Brasil")

        // Adição das marcas à lista de marcas
        marcas.addAll(listOf(marca1, marca2, marca3, marca4, marca5, marca6))

        // Criação dos gêneros
        val leite = Leite("Leite")
        val achocolatado = Achocolatado("Achocolatado")
        val presunto = Presunto("Presunto")

        // Adição dos gêneros à lista de gêneros
        generos.addAll(listOf(leite, achocolatado, presunto))

        // Criação e adição dos produtos à lista de produtos
        for (i in 1..10) {
            val nomeLeite = when (i) {
                1 -> "Ninho"
                2 -> "Molico"
                3 -> "Farinha Láctea"
                4 -> "Leite em Pó"
                5 -> "Leite em Caixa"
                else -> "Leite -"
            }

            val nomeAchocolatado = when (i) {
                1 -> "Nescau"
                2 -> "Ovomaltine"
                3 -> "Toddy"
                4 -> "Muky"
                else -> "Achocolatado -"
            }

            val nomePresunto = "Presunto -"

            val produtoLeite = Produto(i, nomeLeite, Random.nextDouble(1.0, 5.0), marca1, leite)
            val produtoAchocolatado = Produto(i + 10, nomeAchocolatado, Random.nextDouble(2.0, 6.0), marca2, achocolatado)
            val produtoPresunto = Produto(i + 20, nomePresunto, Random.nextDouble(3.0, 7.0), marca3, presunto)

            produtos.addAll(listOf(produtoLeite, produtoAchocolatado, produtoPresunto))

            // Criação e adição dos itens ao estoque
            for (marca in marcas) {
                val dataValidade = Data(Random.nextInt(1, 31), Random.nextInt(1, 13), 2024)
                estoque.entraItem(ItemProduto(Random.nextInt(1000, 9999), produtoLeite.getNome(), dataValidade, produtoLeite))
                estoque.entraItem(ItemProduto(Random.nextInt(1000, 9999), produtoAchocolatado.getNome(), dataValidade, produtoAchocolatado))
                estoque.entraItem(ItemProduto(Random.nextInt(1000, 9999), produtoPresunto.getNome(), dataValidade, produtoPresunto))
            }
        }
    }
}
