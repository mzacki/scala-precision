package edu.ant
package sing

// is final by default
object Sing {
  // sing usage and example parameters from defaults defined in code
  private val USAGE = "Usage: sing -h | [-4|-6] [-c count] [-op ops] [-p ports] [-t timeout] host"
  private val EXAMPLE = "sing -4 -c 4 -op 4 -p 80,443 -t 4000 google.com"

  // check what type should be used https://www.baeldung.com/scala/nil-null-nothing-unit-none
  // be sure if Option[Nothing] is correct type
  var inet_addr: Option[Nothing] = None // network address name for hostname
  private var tcp4Flag = true // default tcp4 ip-address
  var timeout = 4000 // default socket time 4000 ms = 4-seconds
  private var count = 4 // default count of times to perform ops
  var ports: Array[Integer] = Array[Integer](80, 443) // default ports http, https
  private var host = "localhost" // default host name is localhost or 127.0.0.1
  var hostName = "" // result host name from DNS query
  var hostAddr = "" // result host address from DNS query
  var hostFlag = true // default is host is present, available
  private var limit = 4 // default limit on number of ops


  @main
  def main(args: String*): Unit = {
    if (args.isEmpty) {
      usage()
      System.exit(0)
    }

    host = args(0) // check it
    val flags = args.toList
    processArgs(flags)
    // TODO remove test prints
    println("It works: " + count)
  }

  private def usage(): Unit = {
    System.out.printf("%n%s%n%s%n%n", USAGE, EXAMPLE)
  }

  private def processArgs(flags: List[String]): Unit = {
    flags.foreach(arg => matchArg(arg, flags))
  }

  private def matchArg(arg: String, flags: List[String]): Unit = {
    arg match {
      case "-4" => tcp4Flag = true
      case "-6" => tcp4Flag = false
      case "-c" => count = mapToValue(arg, flags)
      case "-op" => limit = mapToValue(arg, flags)
   //   case "-p" => ports = mapToValues(arg, flags)
      case _ =>
    }
  }

  private def getFlagValue(arg: String, flags: List[String]): String = {
    flags(flags.indexOf(arg) + 1)
  }

  private def mapToValue(arg: String, flags: List[String]): Int = {
    getFlagValue(arg, flags).toInt
  }

  private def mapToValues(arg: String, flags: List[String]): List[Int] = {
    val tmpPorts = getFlagValue(arg, flags).split(",")
    // use array or seq?
    return null
  }

}
