package edu.ant
package intro

import scala.util.{Failure, Success, Try}
import scala.concurrent.Future
import concurrent.ExecutionContext.Implicits.global

object Varia extends App {

  // lazy evaluation
  lazy val exemplaryLazyValue = 2
  lazy val lazyEvaluationExample = {
    println("This is a lazy block")
    63
  }
  // running the class prints nothing
  // but running this prints line but no 63:
  val eagerEvaluationExample = {
    println("This is an eager block")
    63
  }

  // lazy val initiates after first use, e.g.:
  val firstUse = lazyEvaluationExample + 1
  // now running the app prints the line

  // printing this returns 64
  println(firstUse)


  // pseudo-collections: Option, Try
  def methodThatMayReturnNull(): String = null

  val scalaOptional = Option(methodThatMayReturnNull())
  // if null -> returns None (like Optional.empty()) comparing to Java
  // if not null -> returns Some(value). Some is subtype of Option

  def methodThatMayThrow(): String = throw new RuntimeException()

  val tryThisMethod = Try(methodThatMayThrow()) // swallows an exception if thrown

  val tryProcessingFlow = tryThisMethod match
    case Success(validValue) => s"Try clause returned $validValue"
    case Failure(ex) => s"Method returned exception $ex"


  val futureExample = Future {
    println("Working...")
    Thread.sleep(1000)
    println("Work completed.")
    1200
  }

  // implicits
  // #1 implicit arguments - not working this way in Scala 3
  // type of implicit definition needs to be given explicitly
  def implicitMethod(implicit arg: Int) = arg + 1
  //implicit val implicitValueExample = 500
  // println(implicitMethod)


  // #2 implicit conversions - this one works under Scala 3
  implicit class CustomInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven())
}