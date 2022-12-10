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
        var registerX = 1
        var cycle = 0
        val screenList = arrayListOf<String>("","","","","","")
        // ########################################

        while (cycle <= 239) {
            val nextInstruction = instructionQueue.first()
            val pixelLoc = cycle % 40
            val spriteLoc = registerX

            val pixelVal = if (spriteLoc - 1 == pixelLoc || spriteLoc == pixelLoc || spriteLoc + 1 == pixelLoc) {
                "#"
            } else {
                "."
            }
            screenList[cycle/40] += pixelVal

            if (nextInstruction.matches("""-?\d+""".toRegex())) {
                registerX += nextInstruction.toInt()
            }
            cycle++
            instructionQueue.removeFirst()
        }

        for (line in screenList) {
            println(line)
        }
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

    // begin part 2
    inputQueue.clear()
    for (instruction in testInput) {
        instruction.split(" ").forEach { inputQueue.add(it) }
    }
    part2(inputQueue)

    inputQueue.clear()
    for (instruction in input) {
        instruction.split(" ").forEach { inputQueue.add(it) }
    }
    part2(inputQueue)
}
