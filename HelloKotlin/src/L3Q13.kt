fun main(args: Array<String>) {
  testWhatShouldIDoToday()
}

fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun testWhatShouldIDoToday() {
  println(whatShouldIDoToday("happy", "sunny"))
  println(whatShouldIDoToday("sad"))
  print("How do you feel?")
  println(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temp: Int = 24) : String {
  return when {
    isVeryHot(temp) -> "go swimming"
    isSadRainyCold(mood, weather, temp) -> "stay in bed"
    isHappySunny(mood, weather) -> "go for a walk"
    else -> "Stay home and read."
  }
}
