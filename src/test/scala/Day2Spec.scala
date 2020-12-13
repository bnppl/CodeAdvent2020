import org.specs2.mutable.Specification

import java.net.URL

class Day2Spec extends Specification {

  "Given a list of passwords with their rules I should get a list of rule inputs and passwords" >> {

    val input =
      """|4-5 l: rllllj
         |4-10 s: ssskssphrlpscsxrfsr
         |14-18 p: ppppppppppppppppppp""".stripMargin

    val expected = List(
      (PasswordRuleInput('l', 4, 5), "rllllj"),
      (PasswordRuleInput('s', 4, 10), "ssskssphrlpscsxrfsr"),
      (PasswordRuleInput('p', 14, 18), "ppppppppppppppppppp"),
    )

    val result = Day2.parsePasswordList(input.split("\n").toList)

    result === expected

  }

  "If I apply a valid password to a password rule 1 it should be considered valid" >> {

    val input = PasswordRuleInput('l', 4, 5)

    val result = Rule1(input, "llll5")

    result === true

  }

  "If I apply a password to rule 2 with position 1 correct it should be considered valid" >> {

    val input = PasswordRuleInput('l', 4, 5)

    val result = Rule2(input, "***l*")

    result === true
  }

  "If I apply a password to rule 2 with position 2 correct it should be considered valid" >> {

    val input = PasswordRuleInput('l', 4, 5)

    val result = Rule2(input, "****l*")

    result === true
  }

  "If I apply a password to rule 2 with both position 2 and 1 correct it should be invalid" >> {

    val input = PasswordRuleInput('l', 4, 5)

    val result = Rule2(input, "***ll")

    result === false
  }

  "If I apply a password to rule 2 with both position 2 correct and position 1 out of bounds is should be valid" >> {

    val input = PasswordRuleInput('l', 4, 99)

    val result = Rule2(input, "***ll")

    result === true
  }

  "Given a list of passwords with their rules I should get a list of valid passwords" >> {

    val input =
      """|4-5 l: rllllj
         |1-2 s: ssssss
         |14-18 p: ppppppppppppppppppp""".stripMargin

    val expected = List("rllllj")

    val result = Day2.findValidPasswords(Rule1, input.split("\n").toList)

    result === expected
  }

  "Given a list of passwords and rules from a file I should find all the ones that are valid using rule 1" >> {

    val inputUrl: URL = getClass.getResource("inputDay2.txt")

    val result = Day2.answer1(inputUrl)

    println(result.size)

    success
  }

  "Given a list of passwords and rules from a file I should find all the ones that are valid using rule 2" >> {

    val inputUrl: URL = getClass.getResource("inputDay2.txt")

    val result = Day2.answer2(inputUrl)

    println(result.size)

    success
  }


}
