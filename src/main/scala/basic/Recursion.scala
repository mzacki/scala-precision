package edu.ant
package basic

import scala.annotation.tailrec

object Recursion extends App {

  // stack overflow for greater values
  // @tailrec - complains because recursive call is not the last expression
  def factorial(n: Int): Int = if (n <= 1) 1 else factorial(n - 1) * n

  println("Factorial: " + correctFactorial(10 ))

  // wrapper function preserves same stack for execution - tail recursion
  // instead of loops, use tail recursion
  def correctFactorial(n: Int): BigInt = {
    @tailrec // uses recursion as last expression
    def helper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else helper(x - 1, x * accumulator)

    helper(n, 1)
  }


}
