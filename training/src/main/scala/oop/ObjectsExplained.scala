package edu.ant
package oop

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
  println("Identity: " + (ant == ant2)) // identity: true
  println("Identity (equals() method): " + ant.equals(ant2)) // identity: true
  println("Reference equality (eq() method): " + ant.eq(ant2)) // reference equality: true - same instance (singleton)

  private class Ant {
    // instance-level functionality
  }

  // Both Ants are COMPANIONS

  private val ant3 = new Ant
  private val ant4 = new Ant
  println("Identity: " + (ant3 == ant4)) // identity: false
  println("Identity (equals() method): " + ant3.equals(ant4)) // identity: false
  println("Reference equality (eq() method): " + ant3.eq(ant4)) // reference equality - not the same instance! false
  // note: == and equals() default behaviour is eq (reference comparison): https://stackoverflow.com/questions/9853645/scala-does-default-to-equals

  object Bee {
    // factory method
    def from(breed1: Bee, breed2: Bee): Bee = new Bee("Carnica")
    // in practice, the method's name could be apply(...)
  }

  class Bee(val breed: String) {

  }

  val bee1 = new Bee("Sklenar")
  val bee2 = new Bee("Carnica")
  val newBee = Bee.from(bee1, bee2)

  // possible applications Scala object with
  // def main(args: Array[String]): Unit

}
