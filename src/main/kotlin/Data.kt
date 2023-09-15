import java.text.SimpleDateFormat
import java.util.Date

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {
    init {
        if (!dataValida(dia, mes, ano)) {
            throw IllegalArgumentException("Data inválida: $dia/$mes/$ano")
        }
    }

    override fun toString(): String {
        return String.format("%02d/%02d/%04d", dia, mes, ano)
    }

    fun setData(dia: Int, mes: Int, ano: Int) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia
            this.mes = mes
            this.ano = ano
        } else {
            throw IllegalArgumentException("Data inválida: $dia/$mes/$ano")
        }
    }

    fun antes(outraData: Data): Boolean {
        return compareTo(outraData) < 0
    }

    fun depois(outraData: Data): Boolean {
        return compareTo(outraData) > 0
    }

    fun igual(outraData: Data): Boolean {
        return compareTo(outraData) == 0
    }

    private fun compareTo(outraData: Data): Int {
        return when {
            ano != outraData.ano -> ano - outraData.ano
            mes != outraData.mes -> mes - outraData.mes
            else -> dia - outraData.dia
        }
    }

    private fun dataValida(dia: Int, mes: Int, ano: Int): Boolean {
        if (ano in 1..9999 && mes in 1..12) {
            val ultimoDiaDoMes = quandoUltimoDiaDoMes(mes, ano)
            return dia in 1..ultimoDiaDoMes
        }
        return false
    }

    private fun quandoUltimoDiaDoMes(mes: Int, ano: Int): Int {
        return when (mes) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> if (anoBissexto(ano)) 29 else 28
            else -> throw IllegalArgumentException("Mês inválido: $mes")
        }
    }

    private fun anoBissexto(ano: Int): Boolean {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)
    }

    companion object {
        fun dataHoje(): Data {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val currentDate = Date()
            val formattedDate = dateFormat.format(currentDate)
            val parts = formattedDate.split('/')
            val dia = parts[0].toInt()
            val mes = parts[1].toInt()
            val ano = parts[2].toInt()
            return Data(dia, mes, ano)
        }
    }
}