import org.specs2.mutable.Specification

class AdventNumberInputParserSpec extends Specification{
  "Given a list of numbers separated by new lines, I should get back a List()" >> {

    val numbers =
      """|1593
         |1638
         |1396""".stripMargin

    val expected = List(1593, 1638, 1396)

    val result = AdventNumberInputParser.stringToInts(numbers)

    result === expected
  }

  "Given a list of numbers with some empty lines separated by new lines, I should get back a List()" >> {

    val numbers =
      """|1593
         |
         |1638
         |
         |1396""".stripMargin

    val expected = List(1593, 1638, 1396)

    val result = AdventNumberInputParser.stringToInts(numbers)

    result === expected
  }

}
