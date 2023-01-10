package edu.ant
package oop

object Case extends App {

  // What is Case class in Scala ?
  // https://docs.scala-lang.org/tour/case-classes.html

  private case class Something(name: String, quantity: Int)

  private val sth = Something("it's damn something", 99) // keyword new is redundant

  // 1) class params are automatically fields:
  println(sth.name)

  // 2) equals & hashCode implicitly implemented
  private val sth2 = Something("it's damn something", 99)
  println(sth == sth2) // shows true - if equals() was not implemented, it would showed false (comparing references in memory)

}
