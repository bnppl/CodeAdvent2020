import org.specs2.mutable.Specification

import java.net.URL

class Day3Spec extends Specification {

  "The map needs to repeat the pattern of each row" >> {
    val mapTemplate =
      """|.#
         |""".stripMargin

    val result = Day3.buildMap(mapTemplate).head.take(6).toList

    val expected = ".#.#.#".toCharArray.toList

    result === expected
  }

  "it should return a list of all the elements in the pattern 3 across, 1 down" >> {
    val mapTemplate =
      """|......
         |...#..
         |......
         |""".stripMargin

    val map = Day3.buildMap(mapTemplate)
    val result = Day3.descend(map, 0, 3)

    val expected = List('.', '#', '.')

    result === expected
  }

  "it should count the trees in the path for the map provided" >> {

    val inputUrl: URL = getClass.getResource("inputDay3.txt")

    val answer = Day3.answer(inputUrl)

    println(answer)

    success
  }

}
