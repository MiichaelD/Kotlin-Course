package spices

fun main(args: Array<String>) {
  val spiceCabinet = listOf(
      SpiceContainer(Curry("Yellow Curry", "mild")),
      SpiceContainer(Curry("Red Curry", "medium")),
      SpiceContainer(Curry("Green Curry", "spicy")))

  for(element in spiceCabinet) println(element.label)
}

class SpiceContainer(var spice: Spice) {

  val label: String = spice.name
}

