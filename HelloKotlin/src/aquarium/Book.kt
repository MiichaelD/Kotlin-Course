package aquarium

open class Book(val title:String, val author:String, var pages: Int = 100) {

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

fun Book.getWeight(): Float {
  return pages * 1.5f
}

fun Book.tornPages(pagesTorn: Int) {
  pages -= pagesTorn
  if (pages < 0) pages = 0
}

class Puppy {
  fun playWithBook(book: Book) {
    book.tornPages(Math.ceil(Math.random()*10).toInt())
  }
}

fun staticPuppyTest() {
  val book = Book("Romeo and Juliet", "William Shakespeare")
  val puppy = Puppy()


  while (book.pages > 0) {
    println("Book: ${book.title} has ${book.pages} left, it weights ${book.getWeight()}")
    puppy.playWithBook(book)
  }
  println("Book: ${book.title} has ${book.pages} left")
}

fun main(args: Array<String>) {
  staticPuppyTest()
}