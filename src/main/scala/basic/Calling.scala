package edu.ant
package basic

object Calling extends App{

  def byValue(n: Long): Unit = {
    println("call by value: " + n)
    println("another call by value: " + n)
  }

  // lazy init / like in lambda - deferred evaluation
  def byName(n: => Long): Unit = {
    println("call by name - deferred eval: " + n)
    println("another call by name - deferred eval: " + n)
  }

  // example:
  byValue(System.nanoTime())
  byName(System.nanoTime())

  // applied to recursive example
  def increaseInfinite(): Int = 1 + increaseInfinite()
  def callByValueThenByName(n: Int, m: => Int) = println(n)

  callByValueThenByName(1, increaseInfinite()) // works: second lazy param (m) is never used, therefore never evaluated
  // callByValueThenByName(increaseInfinite(), 1) // stack overflow: first param is immediately evaluated so infinity excess Int range


}
