package aquarium

open class Book(val title:String, val author:String) {

  companion object {
    const val MAX_BOOKS = 3;
  }

  object Constants {
    const val BASE_URL = "http://www.turtlecare.net/"
  }

  private var currentPage = 1

  open fun readPage() {
    ++currentPage
  }

  fun canBorrow(hasBooks: Int): Boolean {
    return hasBooks < MAX_BOOKS
  }

  fun printUrl() {
    println(Constants.BASE_URL + title + ".html")
  }
}

class EBook(title:String, author:String, val format:String = "yrcy")
  : Book(title, author) {

  private var wordCount = 0

  override fun readPage() {
    wordCount += 250
  }
}