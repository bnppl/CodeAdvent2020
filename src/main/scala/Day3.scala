
import java.net.URL

object Day3 {

  import AdventInputParser.readFile

  def descend(rows: List[LazyList[Char]], position: Int, step: Int): List[Char] =
    if (rows == Nil)
      Nil
    else
      rows.head(position) :: descend(rows.tail, position + step, step)


  def buildMap(mapTemplate: String): List[LazyList[Char]] = mapTemplate
    .split("\n")
    .map(row => LazyList.continually(row.toCharArray).flatten).toList

  def answer(url: URL): Int = descend(buildMap(readFile(url)), 0, 3).count(_ == '#')

}
