import org.specs2.mutable.Specification

import java.net.URL

class Day2Spec extends Specification {

  "Given a list of passwords with their rules I should get a list of rules and passwords" >> {

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

  "If I apply a valid password to a password rule it should return true" >> {

    val rule = PasswordRuleInput('l', 4, 5)

    val result = rule("llll5")

    result === true

  }

  "Given a list of passwords with their rules I should get a list of valid passwords" >> {

    val input =
      """|4-5 l: rllllj
         |1-2 s: ssssss
         |14-18 p: ppppppppppppppppppp""".stripMargin

    val expected = List("rllllj")

    val result = Day2.findValidPasswords(input.split("\n").toList)

    result === expected
  }

  "Given a list of passwords and rules from a file I should find all the ones that are valid" >> {

    val inputUrl: URL = getClass.getResource("inputDay2.txt")

    val result = Day2.answer(inputUrl)

    println(result.size)

    success
  }

}
