package edu.ant
package intro.oop

object ObjectsExplained extends App{

  // there is no static in Scala, no class-level functionality
  // object is equivalent of a class
  // SINGLETON by definition!
  private object Ant {
    val NUMBER_OF_LEGS = 2 // class-level functionality in Scala - example
    def canFlySometimes: Boolean = true
  }

  println(Ant.NUMBER_OF_LEGS)
  println(Ant.canFlySometimes)

  private val ant = Ant
  private val ant2 = Ant
  println("Identity: " + (ant == ant2)) // identity
  println("Identity (equals() method): " + ant.equals(ant2)) // identity
  println("Reference equality (eq() method): " + ant.eq(ant2)) // reference equality



}
