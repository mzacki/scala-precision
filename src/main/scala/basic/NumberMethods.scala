package edu.ant
package basic

object NumberMethods extends App{

  // can invoke toString() on a number
  // returns String
  println(1.toString)
  // returns range
  val range = 1.to(10)
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


}
