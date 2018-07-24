
fun labels() {
  loop@ for (i in 1..100) {
    println("Hello Kotlin: $i")
    for (j in 1..5) {
      println("Hello world: $j")
      if (i > 10)
        break@loop
    }
  }
  println("Finished running labels() loops")
}