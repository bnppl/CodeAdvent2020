import org.specs2.mutable.Specification

import java.net.URL

class Day1Spec extends Specification {

  "Given a list of numbers separated by new lines, I should get back a List()" >> {

    val numbers =
      """|1593
         |1638
         |1396""".stripMargin


    val expected = List(1593, 1638, 1396)

    val result = Day1.readToList(numbers)

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

    val result = Day1.readToList(numbers)

    result === expected
  }



  "Given a list of numbers it will add them together, and return the product of any that add up to 2020" >> {

    val numbers = List(2019, 1, 220)

    val result = Day1.addNumbers(numbers)

    val expected = Set(2019)

    result === expected

  }


  "Given a url it should read the contents of a textfile into a string" >> {

    val inputUrl: URL = getClass.getResource("input.txt")

    val answer = Day1.answer(inputUrl)


    println(answer)

    true
  }



}
