import Day1.addTwoNumbers

import java.net.URL
import scala.util.Try
import scala.util.matching.Regex

object Day2 {

  import AdventInputParser._

  val passwordRegEx: Regex = """(\d+)\-(\d+) (.)\: (.+)""".r

  def parsePasswordList(list: List[String]): List[(PasswordRuleInput, String)] = list.map {
    case passwordRegEx(min, max, char, password) => Try((PasswordRuleInput(char.charAt(0), min.toInt, max.toInt), password)).toOption
    case _ => None
  }.collect {
    case Some(s) => s
  }

  def findValidPasswords(list: List[String]): List[String] = parsePasswordList(list).collect {
    case (rule, pw) if rule(pw) => pw
  }

  def answer(url: URL): List[String] = findValidPasswords(readStrings(url))
}

case class PasswordRuleInput(letter: Char, num1: Int, num2: Int) {

  def apply(password: String): Boolean = {
    val count = password.count(_ == letter)

    count <= num2 && count >= num1
  }
}
