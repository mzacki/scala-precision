package edu.ant
package sing

// is final by default
object Sing {
  // sing usage and example parameters from defaults defined in code
  private val ZING_USAGE = "Usage: zing -h | [-4|-6] [-c count] [-op ops] [-p ports] [-t timeout] host"
  private val ZING_EXAMPLE = "zing -4 -c 4 -op 4 -p 80,443 -t 4000 google.com"

  // check what type should be used https://www.baeldung.com/scala/nil-null-nothing-unit-none
  // be sure if Option[Nothing] is correct type
  var inet_addr: Option[Nothing] = None// network address name for hostname
  var tcp4Flag = true // default tcp4 ip-address
  var timeout = 4000 // default socket time 4000 ms = 4-seconds
  var count = 4 // default count of times to perform ops
  var ports: Array[Integer] = Array[Integer](80, 443) // default ports http, https
  var host = "localhost" // default host name is localhost or 127.0.0.1
  var hostName = "" // result host name from DNS query
  var hostAddr = "" // result host address from DNS query
  var hostFlag = true // default is host is present, available
  var limit = 4 // default limit on number of ops


  @main
  def main(args: String*): Unit = {
    if (args.isEmpty) {
      usage()
      System.exit(0)
    }

    host = args(0)
   // processArgs(args)

    println("It works.")
  }

  private def usage(): Unit = {
    System.out.printf("%n%s%n%s%n%n", ZING_USAGE, ZING_EXAMPLE)
  }

  private def processArgs(args: String*): Unit = {
  // TODO implement match on CL args:
  // https://docs.scala-lang.org/scala3/book/methods-main-methods.html
  }

}
