package aquarium

object MobyDickWhale {
  val author = "Herman Melville"

  fun impl() {
    // ...
  }
}

enum class Color(val rgb: Int) {
  RED(0xFF0000),
  GREEN(0xFF0000),
  BLUE(0xFF0000)
}

sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()

fun matchSeal(seal: Seal): String {
  return when(seal) {
    is Walrus -> "aquarium.Walrus"
    is SeaLion -> "Sea Lion"
  }
}