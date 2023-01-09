package edu.ant
package oop

object Anonymous extends App {

  private abstract class Anonymous() {
    def hack(): Unit
  }

  private val anonymous = new Anonymous:
    override def hack(): Unit = println("You've been hacked!")

  anonymous.hack()

  println(anonymous.getClass) // class edu.ant.oop.Anonymous$$anon$1

}
