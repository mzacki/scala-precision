package edu.ant
package basic

import scala.annotation.tailrec

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


  def factorial(n: Int) : Int = if (n <= 1) 1 else factorial(n - 1) * n
  println("Factorial: " + factorial(5))

  def fibo(n: Int) : Int = if (n <= 1) 1 else fibo(n - 1) + fibo(n - 2)

  def fibo2(n: Int) : Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case 2 => 1
      case _ => fibo2(n - 1) + fibo2(n - 2)
    }
  }

  println(fibo2(5))

  def primeCheck(n: Int) : Boolean = {
    @tailrec
    def divider(m: Int) : Boolean = {
      if (m <= 1) true
      else n % m != 0 && divider(m - 1)
    }
    divider(n / 2)
  }

  (1 to 10).foreach(a => println(a + " : " + primeCheck(a)))


}
