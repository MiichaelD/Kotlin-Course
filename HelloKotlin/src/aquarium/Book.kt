package aquarium

open class Book(val title:String, val author:String) {

  private var currentPage = 1

  open fun readPage() {
    ++currentPage
  }
}

class EBook(title:String, author:String, val format:String = "yrcy")
  : Book(title, author) {

  private var wordCount = 0

  override fun readPage() {
    wordCount += 250
  }
}