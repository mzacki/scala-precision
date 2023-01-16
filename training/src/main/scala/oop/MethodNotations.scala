package edu.ant
package oop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotations extends App{

  class Bee(val race: String, val family: String) {
    def belongs(beehive: String): Boolean = beehive == family
    @targetName("compete") // https://docs.scala-lang.org/scala3/reference/other-new-features/targetName.html
    // name under which code from other languages can call the method
    def +(bee: Bee) = s"${this.race} is competing with ${bee.race}" // + is valid method name
    def +(race: String) = new Bee(race, null) // oveloaded + method
    @targetName("not equal")
    def !(bee: Bee): Boolean = this.race != bee.race // ! is valid method name
    @targetName("custom unary")
    def unary_! : Boolean = race != null
    def hasHome: Boolean = family != null
    def apply() = "Do something!"
  }

  val bee = new Bee("Buckfast", "Green beehive")
  val bee2 = new Bee("Augustiana", "Blue beehive")

  println(bee belongs "Green beehive") // infix notation, instead of bee.belongs (works for only one param method)
  println(bee + bee2)
  println(bee ! bee2)

  println(1 + 2)
  // is equal to
  println(1.+(2))
  // because all operators ARE METHODS: + is just a method name!

  // operator is valid method name
  // https://stackoverflow.com/questions/7888944/what-do-all-of-scalas-symbolic-operators-mean
  @targetName("and")
  private def &(bee: Bee, bee2: Bee) = {
    (bee, bee2)
  }
  // example of such method:
  println(&(bee, bee2))
  // here it is returning a tuple
  // see more:
  // https://alvinalexander.com/scala/how-to-define-methods-return-multiple-items-tuples-scala/
  // https://www.baeldung.com/scala/tuples
  

  // prefix notation
  val x = -1 // - is unary operator
  val y = 1.unary_- // same as -1, unary works with -, +, and ~
  println(y)
  // custom unary - defined within the class
  println(bee.unary_!)

  // postfix notation
  println(bee.hasHome)
  // equivalent of
  println(bee hasHome)

  // apply()
  println(bee.apply())
  // equivalent of
  println(bee())
  // no need to apply apply() :)

}
