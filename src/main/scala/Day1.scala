import java.net.URL

object Day1 {

  import AdventInputParser._

  def answer1(url: URL) = addTwoNumbers(stringToInts(readFile(url)))

  def answer2(url: URL) = addThreeNumbers(stringToInts(readFile(url)))

  def addTwoNumbers(numbers: List[Int]) =

    (for {
      one <- numbers
      two <- numbers
    } yield {
      (one, two, one + two)
    }).collect {
      case (a, b, total) if total == 2020 => a * b
    }.toSet

  def addThreeNumbers(numbers: List[Int]) = {

    (for {
      one <- numbers
      two <- numbers
      three <- numbers
    } yield {
      (one, two, three, one + two + three)
    }).collect {
      case (a, b, c, total) if total == 2020 => a * b * c
    }.toSet

  }

}
