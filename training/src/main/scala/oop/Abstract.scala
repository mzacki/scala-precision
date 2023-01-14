package edu.ant
package oop

object Abstract extends App {

  abstract class Ant {
    def doSomething(): Unit
  }

  class FireAnt extends Ant {
    override def doSomething(): Unit = println("Burn them!")
  }

  trait Insect
  trait Hymenoptera

  class Bee extends Insect with Hymenoptera {}

  /**
   * Traits vs Abstract class:
   * traits don't have contructor params
   * multiple traits can be implemented
   * */

  /**
   * Scala types hierarchy:
   * scala.Any
   * scala.AnyRef (== java.lang.Object)
   * scala.Null
   * scala.AnyVal
   * scala.Nothing
   * */

}
