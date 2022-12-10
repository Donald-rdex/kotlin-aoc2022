fun main() {
    fun part1(instructionQueue: ArrayDeque<String>): Int {
        var registerX = 1
        var cycle = 1
        val interestingCyles = listOf<Int>(20, 60, 100, 140, 180, 220)
        var signalStrength: Int
        var totalSignalStr = 0

        while (instructionQueue.isNotEmpty()) {
            val nextInstruction = instructionQueue.first()
            if (nextInstruction.matches("""-?\d+""".toRegex())) {
                registerX += nextInstruction.toInt()
            }
            // println("Instru: $cycle\t$nextInstruction\t$registerX\t $signalStrength\t$totalSignalStr")
            cycle++
            if (cycle in interestingCyles) {
                signalStrength = cycle * registerX
                totalSignalStr += signalStrength
                println("Interesting: $cycle\t$registerX\t $signalStrength\t$totalSignalStr")
                if (cycle == interestingCyles.last()) {
                    return totalSignalStr
                }
            }
            instructionQueue.removeFirst()
        }

        return totalSignalStr
    }

    fun part2(instructionQueue: ArrayDeque<String>) {

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day10_test")
    val inputQueue: ArrayDeque<String> = ArrayDeque()

    for (instruction in testInput) {
        instruction.split(" ").forEach { inputQueue.add(it) }
    }

    // part1(inputQueue)
    check(part1(inputQueue) == 13140)

    val input = readInput("day10_input")
    inputQueue.clear()
    for (instruction in input) {
        instruction.split(" ").forEach { inputQueue.add(it) }
    }
    part1(inputQueue)
    inputQueue.clear()
    for (instruction in input) {
        instruction.split(" ").forEach { inputQueue.add(it) }
    }
    part2(inputQueue)
}
