package edu.ant
package structures.`trait`

object Functional extends App {

  trait Predicate[-T] {
    def test(param: T): Boolean
  }

  trait Transformer[-A, B] {
    def transform(param: A): B
  }

  abstract class GenericList[A] {
    def head: A
    def tail: List[A]
    def isEmpty: Boolean
    def add(item: Int): List[A]
    def map[B] (transformer: Transformer[A, B]): GenericList[B]
    // flat map next
  }

}
