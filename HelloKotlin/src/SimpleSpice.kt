

class SimpleSpice(val name: String, val spiciness: String) {

  val heat :Int = when(spiciness) {
    "mild" -> 5
    else -> 0
  }
}

class SimpleSpice2(){
  val name = "curry"
  val spiciness = "mild"
  val heat: Int
    get() {return 5 }
}

fun main(args: Array<String>) {
  val curry = SimpleSpice("curry", "mild")
  println("Spice: ${curry.name}, spiciness: ${curry.spiciness} (heat level = ${curry.heat}).")
}