import java.net.URL
import scala.util.{Success, Try}

object AdventInputParser {

  def readInts(url: URL) = stringToInts(readFile(url))

  def readStrings(url: URL) = stringToLines(readFile(url))

  def stringToInts(numbers: String): List[Int] = numbers
    .split("\n")
    .toList
    .map(i => Try {
      i.toInt
    })
    .collect {
      case Success(i) => i
    }

  def readFile(url: URL): String = {
    val source = scala.io.Source.fromURL(url)
    val res = source.mkString
    source.close()
    res
  }

  def stringToLines(file: String): List[String] = file.split("\n").toList

}
