package edu.ant
package oop

object Inheritance extends App {

  // access modifiers:
  // private
  // protected
  // no modifier (meaning: public) !!!!!!


  /**
   * CONSTRUCTORS
   * */
  class Ancestor(origin: String) {
  // Descendant(String, Int) cannot extend Ancestor(no param), because default constructor has one param: Ancestor(String)
  // class Descendant(destination: String, age: Int) extends Ancestor {} is not allowed!
  // we need to implement auxiliary constructor:
    def this() = this("Central East")
  }

  // and now it is allowed:
  class Descendant(destination: String, age: Int) extends Ancestor {}

  /**
   * OVERRIDING
   * */
  class Insect {
    val movingType = "Flying"
    def move(): Unit = println(movingType)
    protected def hiddenSkill(): Unit = println("Do nothing")
  }

  // sealed is more limited than final: you can extend in the same file, cannot extend from outside the file
  sealed class Ant extends Insect {
    override val movingType: String = "Running"
    override def move(): Unit = println("Running fast!")
    override def hiddenSkill(): Unit = println("Do something")
  }

  class FireAnt extends Ant {}

  // overriding directly in constructor
  // final cannot be extended
  final class Bee(override val movingType: String) extends Insect

  val ant = new Ant
  ant.move()
  val ant2 = new Insect
  ant2.move()
  //ant2.hiddenSkill() forbidden, method is protected

  /**
   * POLYMORPHIZM
   * */

  val unknownInsect: Insect = new Bee("Dancing")

}
