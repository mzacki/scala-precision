package edu.ant
package intro.oop

import java.time.Year

object BookShelf extends App {

  class Book(title: String, year: Int, author: Author) {
    def authorAge: Int = Year.now.getValue - author.year
    def isWrittenBy: String = author.fullName
    def publish(yearOfRelease: Int) = new Book(this.title, yearOfRelease, this.author)

  }
  class Author(name: String, surname: String, val year: Int) {
    def fullName: String = name + " " + surname
  }

  // keyword val - to have a class' field, not only parameter
  class BookCounter(val value: Int) {
    def count = value
    def increment = new BookCounter(value + 1) // immutability -> returns new BookCounter instead of modifying existing instance
    def decrement = new BookCounter(value - 1)

    def increment(amount: Int) = new BookCounter(value + amount)
    def decrement(amount: Int) = new BookCounter(value - amount)

  }

}
