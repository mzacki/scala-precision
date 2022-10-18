package edu.ant
package basic

object Variable extends App {


  // constant (val is immutable)
  val x: Int = 64
  // types of val is not compulsory
  val y = 4

  // variables are mutable, types can be inferred
  var z = 4
  z = 88 // side-effects in functional programming, better to use val

  // ternary
  var condition = true
  val evaluated = if condition then "Ais" else "Zan"
  println(evaluated)
  // or
  println(if condition then "Ais" else "Zan")

  // loops are discouraged, especially while loops, as relict of imperative programming, causing side-effects
  // everything in Scala is an expression

  val voidValue = (z = 5)
  println(voidValue) // prints empty parentheses == Unit return type

  val codeBlock = {
    val a = 1
    val b = 2
    // value of the last expression is the value of the code block
    if a + b > a then "OK" else "Mistake!"
  }

}
