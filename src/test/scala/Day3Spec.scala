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

  "it should traverse the hill using a configurable row step as well as column step" >> {

    val mapTemplate =
      """|......
         |######
         |......
         |######
         |######
         |""".stripMargin

    val map = Day3.buildMap(mapTemplate)
    val result = Day3.descend(map, 0, 3, 2)

    val expected = List('.', '.', '#')

    result === expected
  }

  "given multiple routes, it should descend each of them and return the terrain encountered" >> {

    val mapTemplate =
      """|......
         |######
         |......
         |######
         |######
         |""".stripMargin

    val map = Day3.buildMap(mapTemplate)

    val routes = List(
      (1, 1),
      (3, 2)
    )

    val result = Day3.descendRoutes(map, routes)

    val expected = List(
      List('.', '#', '.', '#', '#'),
      List('.', '.', '#')
    )

    result === expected
  }

  "it should count the trees in the path for the map provided" >> {

    val inputUrl: URL = getClass.getResource("inputDay3.txt")

    val answer = Day3.answer1(inputUrl)

    println(answer)

    success
  }

  "it should count the trees all the routes provided" >> {

    val inputUrl: URL = getClass.getResource("inputDay3.txt")

    val routes = List(
      (1, 1),
      (3, 1),
      (5, 1),
      (7, 1),
      (1, 2),
    )

    val answer = Day3.answer2(inputUrl, routes)

    println(answer)

    success
  }

}
