package edu.ant
package hello

object OOP extends App {

  class Wood {
    val genre: String = "Birch" // fields are public by default (option: private, protected)
    def dry() = println("Wood is getting dry.") // methods are public by default

  }

  val wood = new Wood
  class Branch(val width: Int) extends Wood
  val branch = new Branch(20)

  abstract class SyntheticWood {
    val containsPvc = true
    def paint(): Unit
  }

  // trait - a Scala interface
  trait Useable {
    def use(wood: Wood): Unit
    def ?!(input: String): Unit // valid method name
  }
  trait Recyclable {
    def recycle(): Unit
  }
  // single-class inheritance is allowed
  // multi-traits inheritance (mixing) is allowed
  // (similar to Java)
  abstract class PineWood extends Wood with Useable with Recyclable {}

  val pineWood = new PineWood:
    override def use(wood: Wood): Unit = println("Using pine wood")
    override def recycle(): Unit = println("Recycling pine wood")
    override def ?!(input: String): Unit = println(s"Just printing $input")


  // method notation
  pineWood.use(wood)
  // or infix notation (object - method - argument)
  // (available only or methods with ONE argument)
  pineWood use wood
  pineWood ?! "anything!"

  // operators are methods!
  val squareRootOfTwo = 2 * 2
  val alternativeSquareRootOfTwo = 2.*(2) // equivalent

  // anonymous class
  val tool = new Useable:
    override def use(wood: Wood): Unit = "Do anything"
    override def ?!(input: String): Unit = "Do anything"

  // singleton example
  object SingletonTool {
    val serialNumber = 789456123
    def useItOrWhatever(): Unit = println("Do something")
    // special in-built Scala method
    def apply(x: Int): Int = x + 1
  }

  SingletonTool.useItOrWhatever()
  println(SingletonTool.serialNumber)
  // way of calling apply():
  SingletonTool.apply(64)
  // or
  SingletonTool(64) // calls this.apply()

}
