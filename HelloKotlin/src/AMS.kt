import java.util.*

fun main(args: Array<String>) {
    println("${if (args.isEmpty()) "Hello" else
        if (args[0].toInt() < 12) "Good morning" else "Good night"}," +
        " ${if (args.size < 2) "Kotlin" else args[1]}!")
    dayOfWeek()
    feedTheFish()
//    testFitMoreFish()
}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun feedFish(dirty: Int) = dirty + 10

fun dirtyProcessor() {
    var dirty = 20

    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, {dirty -> dirty + 50})
}

fun testFitMoreFish() {
    println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecoration = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
}

fun canAddFish(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecoration: Boolean = true) : Boolean {
    return (currentFish.sum() + fishSize) <= (if (hasDecoration) (tankSize * .8) else tankSize)
}

fun isTooHot(temp: Int) = temp > 30

fun isTooDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater(day: String, temp: Int = 22, dirty: Int = 20) : Boolean {
    return when {
        isTooHot(temp) -> true
        isTooDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun randomDay() : String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(7)]
}

fun fishFood(day: String) : String {
    return when(day) {
        "Sunday" -> "Flakes"
        "Monday" -> "Pellets"
        "Tuesday" -> "Red worms"
        "Wednesday" -> "Granules"
        "Thursday" -> "Mosquitoes"
        "Friday" -> "Lettuce"
        "Saturday" -> "Plankton"
        else -> "Fasting"
    }
}

fun feedTheFish() {
    val day : String = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eats $food")

    if (shouldChangeWater(day)) {
        println("Change the fish water today!")
    }

    dirtyProcessor()
}

fun dayOfWeek() {
    print("What day is it today? ")
    val dayOfWeek : Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when(dayOfWeek) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "IMPOSSIBLE"
    })
}