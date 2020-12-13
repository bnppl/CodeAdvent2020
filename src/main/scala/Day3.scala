
import java.net.URL

object Day3 {

  import AdventInputParser.readFile

  def descend(rows: List[LazyList[Char]], position: Int, colStep: Int, rowStep: Int = 1): List[Char] =
    if (rows == Nil)
      Nil
    else
      rows.head(position) :: descend(rows.tail.drop(rowStep - 1), position + colStep, colStep, rowStep)

  def buildMap(mapTemplate: String): List[LazyList[Char]] = mapTemplate
    .split("\n")
    .map(row => LazyList.continually(row.toCharArray).flatten).toList

  def descendRoutes(rows: List[LazyList[Char]], slopes: List[(Int, Int)]): List[List[Char]] = slopes
    .map {
      case (colStep, rowStep) => descend(rows, 0, colStep, rowStep)
    }

  def answer1(url: URL): Int = descend(buildMap(readFile(url)), 0, 3)
    .count(_ == '#')

  def answer2(url: URL, routes: List[(Int, Int)]) = descendRoutes(buildMap(readFile(url)), routes)
    .map(_.count(_ == '#'))
    .product

}
