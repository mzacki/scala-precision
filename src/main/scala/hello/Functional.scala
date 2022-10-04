package edu.ant
package hello

object Functional extends App {

  class FunctionObject(text: String) {
    // apply is in-built template
    def apply(number: Int) =  println(s"Printing $number as a placeholder for apply() logic")
  }

  // val is constant, used more often than var - variable
  val myFunction = new FunctionObject("This is my custom function")
  myFunction.apply(64)
  // or:
  myFunction(64)

  /*Scala is compiled into Java bytecode.
  * What is fuctional programming in short:
  - functions are first-class citizens (like objects in Java)
  - one can compose functions
  - one can pass functions as arguments into high-order function*
  - one can return functions

  *(przyp. aut.) higher-order function takes or returns another function
  * */

  // FunctionX = Function1, Function2, Function3, ...Function22 (maximum) - traits to define custom functions
  // all Scala functions are instances of these traits

  // syntactic sugar form
  val incrementer = new ((Int) => Int) {
    override def apply(v1: Int): Int = v1 + 1
  }

  // classical form, first arg is passed, second is returned
  val incrementer2 = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  // usage example
  incrementer.apply(1)
  incrementer(1)

  // syntactic sugar form, three args, the last one is what is returned, first two are passed into the function
  val concatenator = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatenator("The ", "Moomins"))

  // shorter form of Function2
  val concatenator2: Function2[String, String, String] = (x: String, y: String) => x + y

  // even shortest form of Function3
  val incrementer3: Int => Int = x => x + 1

  // minimalistic version
  val incrementer4 = (x: Int) => x + 1

  // higher-order function
  val listMapping = List(1, 2, 3).map(a => incrementer(a))
  val listMapping2 = List(4, 5, 6).map(x => 2 * x)
  println(listMapping.concat(listMapping2))

  val flatMapping = List(6, 7, 8).flatMap(x => List(x, 3 * x))
  println(flatMapping)

  val filteringExample = List(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(x => x <= 4)
  // alt syntax - underscore
  val filteringExample1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(_ <= 4)
  val filteringExample2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(x => x % 2 == 0)


}
