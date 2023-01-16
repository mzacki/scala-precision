package edu.ant
package basic

import scala.annotation.targetName

object NumberMethods extends App{

  // can invoke toString() on a number
  // returns String
  println(1.toString)
  // returns range
  val range = 1.to(10)
  // or
  val range2 = 1 to 10
  // to() belongs to RichInt class; there are others: RichDouble, RichChar
  range.foreach(n => println(n))
  // https://alvinalexander.com/scala/how-to-use-range-class-in-scala-cookbook/

  // no wrapper types
  // numbers are classes converted to primitives by VM

  // BigInt, BigDecimal are backed by java.math.BigInteger / java.math.BigDecimal

  // no casting -> convertion
  println(99.44.toInt)
  println(99.toChar)

  // String convertion
  println("64".toInt)

  // no incremental ++ or --
  // instead: +=1 or -+1
  private var counter = 0
  counter+=1

  // BigInt, BigDecimal can be used with operators, no need for special methods like Java multiply() and so on:
  val x: BigInt = 1234567890
  println(x * x * x)
  // so possible:
  @targetName("mulitply three times")
  private def ***(p: BigInt) = {
    p * p * p
  }

  println(***(999))

  
}
