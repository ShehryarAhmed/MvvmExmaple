package com.dotinfiny.mvvmexample.Pairs

fun main() {

    val book = Book("Abc", "xyz", 2020)
    println("Here is your Book ${book.returnBothTitleAndAuthor.first} written by ${book.returnBothTitleAndAuthor.second} in ${book.returnTripleTitleAuthorYear.third}")
    println("Here is your Second Book ${book.getTitleAuthor().first} written by ${book.getTitleAuthor().second} in ${book.getTitleAuthorYear().third}")
}

class Book(var title: String, var author: String, var year: Int) {

    val returnBothTitleAndAuthor = title to author

    val returnTripleTitleAuthorYear = Triple(title, author, year)

    //another way
    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

