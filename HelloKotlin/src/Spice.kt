

class Spice (val name: String, val spiciness: String = "mild") {

  init {
    println("New $this")
  }

  val heat: Int
    get() = when(spiciness) {
      "mild" -> 5
      "medium" -> 6
      "spicy", "hot" -> 7
      "very spicy","very hot" -> 8
      "fire" -> 9
      "death" -> 10
      else -> 0
    }

  override fun toString(): String = "Spice: $name, spiciness: $spiciness (heat level = $heat)"
}

fun makeSalt() = Spice("Salt", "none")

fun main(args: Array<String>) {
  val spices = listOf(
      makeSalt(),
      Spice("Bell pepper", "none"),
      Spice("Sweet pepper", "none"),
      Spice("Jalapeño"),
      Spice("Chipotle"),
      Spice("Tobasco", "medium"),
      Spice("Cayenne", "medium"),
      Spice("Thai", "medium"),
      Spice("Datil", "spicy"),
      Spice("Fatalii", "very spicy"),
      Spice("Orange habanero", "very spicy"),
      Spice("Scotch bonnet", "very spicy"),
      Spice("Red savina", "fire"),
      Spice("Naga jolokia", "death")
  )

  println("All spices: ")
  spices.forEach { spice -> print("$spice, ") }

  val notSoSpicySpices = spices.filter { it.heat < 7 }
  println("\n\nNot so spicy spices: ")
  notSoSpicySpices.forEach { spice -> print("$spice, ") }
}