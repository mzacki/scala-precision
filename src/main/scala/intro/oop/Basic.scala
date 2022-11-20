package edu.ant
package intro.oop

object Basic extends App {

  val legoBrick = new LegoBrick
  println(legoBrick)
  val complexLegoBrick = new ComplexLegoBrick("Square", 4)
  println(complexLegoBrick.shape)

  println(complexLegoBrick.anotherField)
  complexLegoBrick.build()
}

// no constructor
class LegoBrick

// with constructor:
// pin is PARAMETER (not accessible)
// shape is a FIELD
class ComplexLegoBrick(val shape: String, pin: Int) { // val is required to access via dot notation like complexLegoBrick.pin
  // body of a class
  // anything like
  val anotherField = 4
  // is accessibly via dot notation

  println("Executed during instantiation") // e.g. when "new ComplexLegoBrick("Square", 4)"

  def build(): Unit = println(s"Attached brick of ${this.shape} shape.")
  // overloading
  def build(colour: String): Unit = println(s"Attached brick of $colour colour.")
}