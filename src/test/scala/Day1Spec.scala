import org.specs2.mutable.Specification

import java.net.URL

class Day1Spec extends Specification {

  "Given a list of numbers it will add them together, and return the product of any that add up to 2020" >> {

    val numbers = List(2019, 1, 1)

    val result = Day1.addTwoNumbers(numbers)

    val expected = Set(2019)

    result === expected

  }

  "Given a list of numbers it will add them together 3 times, and return the product of any that add up to 2020" >> {

    val numbers = List(2018, 1, 1)

    val result = Day1.addThreeNumbers(numbers)

    val expected = Set(2018)

    result === expected

  }

  "Given a url it should read the contents of a textfile into a string" >> {

    val inputUrl: URL = getClass.getResource("input.txt")

    val answer = Day1.answer1(inputUrl)
    
    println(answer)

    success
  }

  "Given a url it should read the contents of a textfile into a string" >> {

    val inputUrl: URL = getClass.getResource("input.txt")

    val answer = Day1.answer2(inputUrl)


    println(answer)

    success
  }

}
