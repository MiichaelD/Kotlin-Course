import java.util.*

fun main(args: Array<String>) {
  testFortune()
}

fun testFortune() {
  var fortune = ""
  while (!fortune.contains("Take it easy")) {
    fortune = getFortuneCookie(getBirthday())
    println("Your fortune is: $fortune")
  }
}

fun getBirthday() : Int {
  print("Enter your birthday: ")
  return readLine()?.toIntOrNull() ?: 0
}

fun getFortuneCookie(bday : Int = 1) : String {
  val fortune = listOf(
      "You will have a great day!",
      "Things will go well for you today.",
      "Enjoy a wonderful day of success.",
      "Be humble and all will turn out well.",
      "Today is a good day for exercising restraint.",
      "Take it easy and enjoy life!",
      "Treasure your friends because they are your greatest fortune.",
      "Don't worry, be happy!")

  return fortune[bday.rem(fortune.size)]
}

