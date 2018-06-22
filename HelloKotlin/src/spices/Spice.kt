package spices

enum class Color(val rgb: Int) {
  RED(0xFF0000),
  GREEN(0x00FF00),
  BLUE(0x0000FF),
  YELLOW(0xFFFF00);
}

abstract class Spice (val name: String, val spiciness: String = "mild", color: SpiceColor):
    SpiceColor by color{

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

  abstract fun prepareSpice()

  override fun toString(): String = "spices.Spice: $name, spiciness: $spiciness (heat level = $heat)"
}

class SimpleSpice(name: String, spiciness: String = "mild", color: SpiceColor = RedSpiceColor):
    Spice(name, spiciness, color) {

  override fun prepareSpice() {
    println("Preparing spice... Done")
  }
}

interface Grinder {
  fun grind() {
    println("Grinding... Done")
  }
}

object defaultCurryGrinder: Grinder {
  override fun grind() {
    println("Grinding curry")
  }
}

interface SpiceColor {
  val color: Color
}

object  RedSpiceColor: SpiceColor {
  override val color = Color.RED
}

object  YellowSpiceColor: SpiceColor {
  override val color = Color.YELLOW
}

class Curry(name: String = "Curry",
            spiciness: String,
            val grinder: Grinder = defaultCurryGrinder,
            color: SpiceColor = YellowSpiceColor):
    Spice(name, spiciness, color) {

  override fun prepareSpice() {
    grind()
  }

  fun grind() {
    grinder.grind()
  }
}

fun makeSalt() = SimpleSpice("Salt", "none")

fun main(args: Array<String>) {

  val spices = listOf(
      makeSalt(),
      SimpleSpice("Bell pepper", "none"),
      SimpleSpice("Sweet pepper", "none"),
      Curry(spiciness = "mild"),
      SimpleSpice("Jalapeño"),
      SimpleSpice("Chipotle"),
      SimpleSpice("Tobasco", "medium"),
      SimpleSpice("Cayenne", "medium"),
      SimpleSpice("Thai", "medium"),
      SimpleSpice("Datil", "spicy"),
      SimpleSpice("Fatalii", "very spicy"),
      SimpleSpice("Orange habanero", "very spicy"),
      SimpleSpice("Scotch bonnet", "very spicy"),
      SimpleSpice("Red savina", "fire"),
      SimpleSpice("Naga jolokia", "death")
  )

  println("All spices: ")
  spices.forEach { spice -> print("$spice, ") }

  val notSoSpicySpices = spices.filter { it.heat < 7 }
  println("\n\nNot so spicy spices: ")
  notSoSpicySpices.forEach { spice -> print("$spice, ") }
}