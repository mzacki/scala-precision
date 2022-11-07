package edu.ant
package basic

import scala.annotation.tailrec

object Recursion extends App {

  // stack overflow for greater values
  // @tailrec - complains because recursive call is not the last expression
  def factorial(n: Int): Int = if (n <= 1) 1 else factorial(n - 1) * n

  println("Factorial: " + correctFactorial(10))

  // wrapper function preserves same stack for execution - tail recursion
  // instead of loops, use tail recursion
  def correctFactorial(n: Int): BigInt = {
    @tailrec // uses recursion as last expression
    def helper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else helper(x - 1, x * accumulator)

    helper(n, 1)
  }

  // concatenate String n times
  @tailrec
  def concatenate(word: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenate(word, n - 1, word + accumulator)
  }

  println(concatenate("Oz", 2, ""))

  // prime checker recursive

  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeRecursive(m: Int, isStillPrime: Boolean): Boolean =

      if (!isStillPrime) false
      else if (m <= 1) true
      else isPrimeRecursive(m - 1, n % m != 0 && isStillPrime)

    isPrimeRecursive(n / 2, true)

  }

  // fibonacci recursive
  def fibo(n: Int): Int = {
    @tailrec
    def fiboRecursive(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboRecursive(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboRecursive(2, 1, 1)
  }

}
