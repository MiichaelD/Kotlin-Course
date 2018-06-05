fun main(args: Array<String>) {
  val spices= listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

  var filteredSpices = spices.asSequence().filter { it.contains("curry") }.sortedBy { it.length }
  println("Sorted curry spices: ${filteredSpices.toList()}")

  filteredSpices = spices.asSequence().filter{it.startsWith('c')}
  println("Spices that start with 'c': ${filteredSpices.toList()}")

  filteredSpices = spices.asSequence().filter{it.startsWith('c') && it.endsWith('e')}
  println("Spices that start with 'c' and end with 'e': ${filteredSpices.toList()}")

  filteredSpices = spices.take(3).asSequence().filter{it[0] == 'c' && it[it.length-1] == 'e'}
  println("First 3 spices that start with 'c': ${filteredSpices.toList()}")
}