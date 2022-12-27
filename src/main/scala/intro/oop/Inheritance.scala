package edu.ant
package intro.oop

object Inheritance {

  // access modifiers:
  // private
  // protected
  // no modifier (meaning: public) !!!!!!

  class Ancestor(origin: String) {
  // Descendant(String, Int) cannot extend Ancestor(no param), because default constructor has one param: Ancestor(String)
  // class Descendant(destination: String, age: Int) extends Ancestor {} is not allowed!
  // we need to implement auxiliary constructor:
    def this() = this("Central East")
  }

  // and now it is allowed:
  class Descendant(destination: String, age: Int) extends Ancestor {}

}
