package edu.ant
package hello


object Structures extends App {


  // list
  val list = List(1, 2, 3, 4)
  println(list.head) // first
  println(list.tail) // rest
  val appended = 0 :: list // appending to head
  println(appended)
  val extended = 0 +: list :+ 5 // appending to head or tail
  println(extended)

  // sequence
  val sequence: Seq[Int]  = Seq(1, 2, 3) // Seq is trait
  val elem = sequence(1) // by index

  // vector - fast Seq impl
  val vector = Vector(1,2,3,4)

  // set
  val set = Set(1,2,3,5,1,2,4) // returns without duplicates
  val bool = set.contains(89)
  val added = set + 7
  val removed = set - 4

  // range
  val range = 1 to 99 // does not store values - only abstract rep
  println(range) // prints Range 1 to 99
  val something = range.map(n => n / 2) // returns vector, so one can use e.g. toList
  println(something.toSet)

  // tuples
  val tuple = ("Suomi", "sisu", "sauna")

  // map
  val dict: Map[String, String] = Map(
    ("Finlandia", "Suomi"),
    "Francja" -> "France" // eq. to a tuple (String, String)
  )


}
