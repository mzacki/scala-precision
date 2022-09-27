package edu.ant
package hello

object OldApp extends App {

  println("Scala 2 version of Hello World")
  val something: Int = 64
  // Int, Boolean, Char, Double, Float, String
  val booleanValueIsOptional = false // type is optional

  val injection = "INJECTION"
  val injectedString = s"Here is example of injected string: $injection"

  // expressions can be reduced to a value
  val expression = 8 * 8
  // if
  val ifExample = if (expression == 64) 64 else 0
  // code block
  val codeBlockExample = {
    // local declaration
    val localValue = 64
    // last expression is being returned (even without return keyword)
    localValue + 64
  }

  println(codeBlockExample)

  // function definition
  def functionExample(x: Int, y: Int): String = {
    "Result is: " + x * y
  }

  println(functionExample(9, 11))
  
  // iteration is discouraged - better to use recursion
  
  // Unit type == void in Java
}
