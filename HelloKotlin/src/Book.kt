

class Book(val title:String, val author:String, val year:Int = 2000) {

  fun getTitleAndAuthor(): Pair<String, String> {
    return (title to author)
  }

  fun getTitleAuthorAndYear(): Triple<String, String, Int> {
    return Triple(title, author, year)
  }
}

fun main(args: Array<String>) {
  val book = Book("X", "Y", 1991)
  println("Here is your book '${book.title}' written by '${book.author}' in ${book.year}")
}ex