import java.net.URL
import scala.util.{Success, Try}

object AdventNumberInputParser {

  def stringToInts(numbers: String): List[Int] = numbers
    .split("\n")
    .toList
    .map(i => Try{i.toInt})
    .collect {
      case Success(i) => i
    }

  def readURLToString(url: URL): String = {
    val source = scala.io.Source.fromURL(url)
    val res = source.mkString
    source.close()
    res
  }

}
