package edu.ant
package sing

import java.net.{Inet4Address, Inet6Address, InetAddress}

// is final by default
object Sing {
  // sing usage and example parameters from defaults defined in code
  private val USAGE = "Usage: sing -h | [-4|-6] [-c count] [-op ops] [-p ports] [-t timeout] [to host] host"
  private val EXAMPLE = "sing -4 -c 4 -op 4 -p 80,443 -t 4000 google.com"

  // check what type should be used https://www.baeldung.com/scala/nil-null-nothing-unit-none
  // be sure if Option[Nothing] is correct type
  private var inet_addr: Option[Nothing] = None // network address name for hostname
  private var tcp4Flag = true // default tcp4 ip-address
  private var timeout = 4000 // default socket time 4000 ms = 4-seconds
  private var count = 4 // default count of times to perform ops
  private var ports: Array[Int] = Array[Int](80, 443) // default ports http, https
  private var host = "localhost" // default host name is localhost or 127.0.0.1
  private var hostName = "" // result host name from DNS query
  private var hostAddr = "" // result host address from DNS query
  private var hostFlag = true // default is host is present, available
  private var limit = 4 // default limit on number of ops


  @main
  def main(args: String*): Unit = {
    if (args.isEmpty) printHelpAndQuit()
    host = args(0) // check it
    processArgs(args.toList)
    inet_addr = getHostAddrName(host)
    // TODO remove test prints
    println("It works: " + count)
  }

  private def printHelpAndQuit(): Unit = {
    System.out.printf("%n%s%n%s%n%n", USAGE, EXAMPLE)
    System.exit(0)
  }

  private def processArgs(flags: List[String]): Unit = {
    flags.foreach(arg => matchArg(arg, flags))
  }

  private def matchArg(arg: String, flags: List[String]): Unit = {
    arg match {
      case "-4" => tcp4Flag = true
      case "-6" => tcp4Flag = false
      case "-c" => count = mapToValue(arg, flags).toInt
      case "-op" => limit = mapToValue(arg, flags).toInt
      case "-p" => ports = mapToValues(arg, flags)
      case "-t" => timeout = mapToValue(arg, flags).toInt
      case "-h" => printHelpAndQuit()
      // using flag "to" in order to avoid exception when any of the flags is invalid
      // just ignoring them as flags' values
      case "to" => host = mapToValue(arg, flags)
      case _ =>
    }
  }

  private def mapToValue(arg: String, flags: List[String]): String = {
    flags(flags.indexOf(arg) + 1)
  }

  private def mapToValues(arg: String, flags: List[String]): Array[Int] = {
    mapToValue(arg, flags).split(",").map(p => p.toInt)
  }

  //TODO rename this method
  private def getHostAddrName(hostName: String): InetAddress = {
    val iaddr: InetAddress = if (tcp4Flag) getIPv4Addr(hostName) else getIPv6Addr(hostName)
    if (hostFlag) {
      this.hostName = iaddr.getHostName
      hostAddr = iaddr.getHostAddress
      hostFlag = false
    }
    iaddr
  }


  /**
   * Get TCP/IP 4 32-bit address from a given host name.
   *
   * @param hostName - host name of computer system on a network.
   * @return instance of TCP/IP-4 32-bit address for host name.
   * @throws java.net.UnknownHostException
   */
  // TODO should it throw any exc?
  private def getIPv4Addr(hostName: String): Inet4Address =
    InetAddress.getAllByName(hostName)
    .foreach(address => if address.isInstanceOf[Inet4Address]
      return address.asInstanceOf[Inet4Address]
    )

  /**
   * Get TCP/IP 6 128-bit address from a given host name.
   *
   * @param hostName - host name of computer system on a network.
   * @return instance of TCP/IP-6 128-bit address for host name.
   * @throws java.net.UnknownHostException
   */
  // TODO should it throw any exc?
  private def getIPv6Addr(hostName: String): Inet6Address = InetAddress.getAllByName(hostName)
    .foreach(address => if (address.isInstanceOf[Inet6Address]) return address.asInstanceOf[Inet6Address]
    )

}
