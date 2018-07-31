package Functional

data class Fish(var name: String)

fun main(args: Array<String>) {
  fishExamples()
}

fun fishExamples() {
  val fish = Fish("splashy")

  with(fish.name) {
    println(capitalize())
  }

  myWith(fish.name) {
    println(this.toUpperCase())
  }

  println(fish.run{name}) // returns the result of the block
  println(fish.apply{}) // returns the object

  val fish2: Fish = Fish("splashy2").apply{name = "Sharky"}
  println(fish2)

  println(fish.let{it.name.capitalize()} // returns a copy of the result
      .let{"$it fish"}
      .let{it.length}
      .let{it + 30})
}

/**
 * Making this function inline avoids creating an instance of a lambda everytime this
 * function is invoked, but instead replacing the contents of the function where it is
 * being called.
 *
 * i.e.
 * myWith(fish.name, object: Function1<String, Unit> {
 *    override fun invoke(name: String) {
 *      name.capitalize()
 *    }
 * })
 *
 * Gets replaced as:
 * fish.capitalize()
 *
 */
inline fun myWith(name: String, block: String.() -> Unit) {
  name.block()
}