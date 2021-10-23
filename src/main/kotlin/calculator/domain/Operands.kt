package calculator.domain

class Operands private constructor(private val operands: List<Operand>) {
    fun size() = operands.size

    fun getSum(): Int {
        return operands
            .reduce { sum, operand -> sum + operand }.value
    }

    operator fun get(index: Int): Operand = operands[index]

    companion object {
        fun from(inputs: List<String>): Operands {
            return Operands(inputs.map { Operand.from(it.trim()) })
        }
    }
}