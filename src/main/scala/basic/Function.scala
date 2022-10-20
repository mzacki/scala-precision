package edu.ant
package basic

object Function extends App {


  // without args - parentheses not needed!
  def functionExample: Int = 64
  println(functionExample)
  // empty parentheses allowed
  def functionExampleParenth(): Int = 99
  println(functionExampleParenth())
  // recursive function: use recursion instead of looping
  // overloaded or recursive need return type...
  def printSthXTimesRecursive(word: String, times: Int): String = {
    if (times == 1) word
    else word + " " + printSthXTimesRecursive(word, times - 1)
  }
  println(printSthXTimesRecursive("Suomi", 9))
  // ...but normally we can skip return type:
  def skipReturnType(word: String, times: Int) = {
    (word + " ") * times
  }
  println(skipReturnType("Finland", 3))
  // void function with side-effects (Unit is not needed here but allowed)
  def logger(toLog: String): Unit = println(toLog)
  // nested functions:
  def externalFunc(n: Int) = {
    def internalFunc(p: Int, q: Int) = p + q
    internalFunc(n, n + 1)
  }
  println(externalFunc(4))


}
