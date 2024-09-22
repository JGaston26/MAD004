import kotlin.random.Random

fun main() {
    val randomNum = generateRandomNumber(1, 100)
    playGame(randomNum)
}

fun generateRandomNumber(lower: Int, upper: Int): Int {
    return Random.nextInt(lower, upper + 1)
}


fun playGame(randomNum: Int) {
    val incorrectGuessList = mutableListOf<Int>()
    var incorrectGuesses = 0
    var guess: Int = getUserGuess()
    while (guess != randomNum) {
        guess = getUserGuess()
        if (!incorrectGuessList.contains(guess) && guess != randomNum) {
            incorrectGuesses++
            incorrectGuessList.add(guess)
        }
        giveFeedback(guess, randomNum)
    }
    endGame(randomNum, incorrectGuesses, incorrectGuessList)
}
fun getUserGuess(): Int {
    var guess: Int
    while (true) {
        print("Enter a guess number between 1 and 100: ")
        val input = readLine()
        if (input != null && input.toIntOrNull() != null) {
            guess = input.toInt()
            if (guess in 1..100) {
                return guess
            } else {
                println("Please enter a number between 1 and 100.")
            }
        } else {
            println("Invalid input. Please enter a valid number.")
        }
    }
}

fun giveFeedback(guess: Int, randomNum: Int) {
    when {
        guess > randomNum && guess - 5 <= randomNum -> println("Close, but too big")
        guess > randomNum -> println("Too big")
        guess < randomNum && guess + 5 >= randomNum -> println("Close, but too small")
        guess < randomNum -> println("Too small")
    }
}

fun endGame(randomNum: Int, incorrectGuesses: Int, incorrectGuessList: List<Int>) {
    println("Yay, you won! The number was $randomNum")
    println("Number of incorrect guesses: $incorrectGuesses")
    println("Incorrect guesses: $incorrectGuessList")
}