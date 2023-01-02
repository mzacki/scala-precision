package edu.ant
package structures.list.linked

object LinkedListImpl {

  abstract class List {
    def head: Int
    def tail: List
    def isEmpty: Boolean
    def add(item: Int): List
  }

  object EmptyIndex extends List {
    def head: Int = throw new NoSuchElementException()
    def tail: List = throw new NoSuchElementException()
    def isEmpty: Boolean = true
    def add(item: Int): List = new Link(item, EmptyIndex)
  }

  class Link(firstItem: Int, lastItem: List) extends List {
    def head: Int = firstItem
    def tail: List = lastItem
    def isEmpty: Boolean = false
    override def add(item: Int): List = new Link(item, this)
  }

  object Example extends App {
    val list = new Link(1, new Link(2, new Link(3, new Link(4, EmptyIndex))))
  }

}
