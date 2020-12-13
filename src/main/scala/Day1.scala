import java.net.URL
import scala.util.{Success, Try}

object Day1 {


  def addNumbers(numbers: List[Int]) = {
    val lowToHigh = numbers.sorted
    val highToLow = lowToHigh.reverse

    (for {
      low <- lowToHigh
      high <- highToLow
    } yield {
      (low, high, low + high)
    }).collect {
      case (a, b, total) if total == 2020 => a * b
    }.toSet

  }

  def readToList(numbers: String): List[Int] = numbers
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

  def answer(url: URL) = addNumbers(readToList(readURLToString(url)))

}
