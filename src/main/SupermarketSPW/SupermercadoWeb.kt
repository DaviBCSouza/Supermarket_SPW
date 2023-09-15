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
    private val carrinhoA = Carrinho()
    private val carrinhoB = Carrinho()

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

    fun getCarrinhoA(): Carrinho {
        return carrinhoA
    }

    fun getCarrinhoB(): Carrinho {
        return carrinhoB
    }

    private fun iniciaSupermercado() {
        val marcaNestle = Marca("Nestlé")
        val marcaItambe = Marca("Itambé")
        val marcaDuleite = Marca("Duleite")

        val marcaABF = Marca("ABF")
        val marcaPepsico = Marca("Pepsico")
        val marcaBretzke = Marca("Bretzke")

        val marcaSadia = Marca("Sadia")
        val marcaPerdigao = Marca("Perdigao")
        val marcaFriboi = Marca("Friboi")

        marcas.addAll(
            listOf(
                marcaNestle,
                marcaItambe,
                marcaDuleite,
                marcaABF,
                marcaPepsico,
                marcaBretzke,
                marcaSadia,
                marcaPerdigao,
                marcaFriboi
            )
        )

        val leite = Leite("Leite")
        val achocolatado = Achocolatado("Achocolatado")
        val presunto = Presunto("Presunto")

        generos.addAll(listOf(leite, achocolatado, presunto))

        val nomesLeite = listOf(
            "Ninho",
            "Molico",
            "Neslac",
            "Itambé",
            "Comfor",
            "Fit",
            "Kids",
            "Integral",
            "Light",
            "Composto Lácteo"
        )
        val nomesAchocolatado = listOf(
            "Ovolmaltine",
            "Chocante",
            "Chocoki",
            "Toddy",
            "Toddynho",
            "Toddynho Nutri",
            "Chocolate Quente",
            "Baunilha",
            "Morango",
            "Achocolatado em Pó"
        )
        val nomesPresunto = listOf(
            "Royal",
            "Light",
            "Extra Fino",
            "Peru",
            "Defumado",
            "Ervas Finas",
            "Cozido",
            "Chester",
            "Frango",
            "Apresuntado"
        )

        for (i in 0..<10) {
            val nomeLeite = nomesLeite[i]
            val nomeAchocolatado = nomesAchocolatado[i]
            val nomePresunto = nomesPresunto[i]

            val marcaLeite = when (i) {
                in 0..3 -> marcaNestle
                in 4..6 -> marcaItambe
                else -> marcaDuleite
            }

            val marcaAchocolatado = when (i) {
                in 0..3 -> marcaABF
                in 4..6 -> marcaPepsico
                else -> marcaBretzke
            }

            val marcaPresunto = when (i) {
                in 0..3 -> marcaSadia
                in 4..6 -> marcaPerdigao
                else -> marcaFriboi
            }

            val produtoLeite = Produto(i + 1, nomeLeite, Random.nextDouble(1.0, 5.0), marcaLeite, leite)
            val produtoAchocolatado =
                Produto(i + 11, nomeAchocolatado, Random.nextDouble(2.0, 6.0), marcaAchocolatado, achocolatado)
            val produtoPresunto = Produto(i + 21, nomePresunto, Random.nextDouble(3.0, 7.0), marcaPresunto, presunto)

            produtos.addAll(listOf(produtoLeite, produtoAchocolatado, produtoPresunto))

            val dataValidade = Data(Random.nextInt(1, 29), Random.nextInt(1, 13), 2023)
            estoque.entraItem(
                ItemProduto(
                    Random.nextInt(1, 99),
                    produtoLeite.getNome(),
                    dataValidade,
                    produtoLeite
                )
            )
            estoque.entraItem(
                ItemProduto(
                    Random.nextInt(1, 99),
                    produtoAchocolatado.getNome(),
                    dataValidade,
                    produtoAchocolatado
                )
            )
            estoque.entraItem(
                ItemProduto(
                    Random.nextInt(1, 99),
                    produtoPresunto.getNome(),
                    dataValidade,
                    produtoPresunto
                )
            )
        }
    }
}
