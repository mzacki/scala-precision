package edu.ant
package structures.list.generic

object GenericListImpl extends App{

  class List[A] {}

  // example:
  val intList = new List[Int]
  val stringList = new List[String]

  // generic methods:
  object List {
    def empty[A]: List[A] = ???
  }

  // example:
  val genericIntList = List.empty[Int]

  // variance problem:
  class Insect
  class Ant extends Insect
  class Bee extends Insect

  // case #1 List[Ant] extends List[Insect] (covariance)
  // +A means: covariant list
  class CovariantList[+A]
  val insect: Insect = new Ant
  val insectList: CovariantList[Insect] = new CovariantList[Ant]
  // or simply:
  // val insectList = new CovariantList[Ant]

  // case #2 (invariance)
  class InvariantList[A]
  val invariantInsectList: InvariantList[Insect] = new InvariantList[Insect]
  // or simply:
  // val invariantInsectList = new InvariantList[Insect]

  // case #3 (contravariance)
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Bee] = new ContravariantList[Insect]

}
