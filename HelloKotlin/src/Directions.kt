import kotlin.math.absoluteValue

enum class Direction {
  NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
  var path: MutableList<Direction> = mutableListOf(Direction.START)
  val map = Location()

  val north = {makeMove(Direction.NORTH) }
  val south = { makeMove(Direction.SOUTH) }
  val east = { makeMove(Direction.EAST) }
  val west = { makeMove(Direction.WEST) }
  val end = {
    path.add(Direction.END)
    println("Game Over: $path")
    path.clear()
  }

  fun move(where: () -> Unit) {
    where.invoke()
  }

  fun makeMove(direction: String?) {
    when(direction) {
      "north", "n" -> move(north)
      "south", "s" -> move(south)
      "east", "e" -> makeMove(Direction.EAST)
      "west", "w" -> west()
      else -> end()
    }
  }

  fun makeMove(direction: Direction) {
    map.updateLocation(direction)
    path.add(direction)
  }
}

class Location(val size: Int = 4) {

  val map = Array(size) { arrayOfNulls<String>(size) }
  var currentLocation = Pair (0,0)

  fun updateLocation(direction: Direction) {
    currentLocation = when(direction) {
      Direction.NORTH ->
        Pair(currentLocation.first, (currentLocation.second + 1).rem(size))
      Direction.SOUTH ->
        Pair(currentLocation.first, (currentLocation.second - 1).absoluteValue.rem(size))
      Direction.EAST ->
        Pair((currentLocation.first + 1).rem(size), currentLocation.second)
      Direction.WEST ->
        Pair((currentLocation.first - 1).absoluteValue.rem(size), currentLocation.second)
      else -> currentLocation
    }
  }

  fun getDescription ():String? {
    return map[currentLocation.first.rem(size)][currentLocation.second.rem(size)]
  }

  init {
    map[0][0] = "You are at the start of your journey. [n / e]"
    map[0][1] = "The road stretches before you. It promises beauty and adventure. [ n / s / e]"
    map[0][2] = "The road still stretches before you. It rains and the water forms puddles. [ n / s / e]"
    map[0][3] = "It is getting much colder and you wish you had a wool coat. [ s / e]"

    map[1][0] = "The narrow path stretches before you. You are glad you are on foot. [ n / e /w]"
    map[1][1] = "It is getting warmer. You smell moss, and marmot scat. You are stung by a mosquito. [ n / s / e / w]"
    map[1][2] = "You decide to sit on your backside and slide down a vast snowfield. [ n / s / e /w]"
    map[1][3] = "You have climbed to the top of a snowy mountain and are enjoying the view. [ w / s / e]"

    map[2][0] = "You cross an old stone bridge. Your hear the murmuring of water. And another grumbling sound. [ n / e / w]"
    map[2][1] = "A bridge troll appears. It swings a club and demands gold. You give them all your coins. [ n / s / e  /w]"
    map[2][2] = "It is getting cooler. A dense fog rolls in. You can hear strange voices. [ n / s / e / w]"
    map[2][3] = "The foothills promise a strenuous journey. You thread your way around gigantic boulders. [ s / e / w ]"

    map[3][0] = "Your journey continues. A fox runs across the path with a chicken in its mouth.[ n / e ]"
    map[3][1] = "In the distance, you see a house. You almost bump into a farmer with a large shotgun. They pay you no heed. [ n / s / w ]"
    map[3][2] = "It is getting hot, and dry, and very, very quiet. You think of water and wish you had brought a canteen.[ n / s / w ]"
    map[3][3] = "You have reached the infinite desert. There is nothing here but sand dunes. You are bitten by a sand flea.[ s / w ] "
  }
}

fun main(args: Array<String>) {
  val game = Game()
  var instruction: String?
  println(game.map.getDescription())
  do {
    print("Enter a direction: n/s/e/w: ")
    instruction = readLine()
    game.makeMove(instruction)
    println(game.map.getDescription())
  } while(instruction?.isEmpty()?.not()!!)
  game.end()
  println(game.path)
}

fun testing(game: Game) {
  println(game.path)
  game.north()
  game.south()
  game.east()
  game.west()
  game.end()
  println(game.path)
}
