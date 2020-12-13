import java.net.URL
import scala.util.Try
import scala.util.matching.Regex

object Day2 {

  import AdventInputParser._

  val passwordRegEx: Regex = """(\d+)\-(\d+) (.)\: (.+)""".r

  def answer1(url: URL): List[String] = findValidPasswords(Rule1, readStrings(url))

  def answer2(url: URL): List[String] = findValidPasswords(Rule2, readStrings(url))

  def findValidPasswords(rule: PasswordRule, list: List[String]): List[String] = parsePasswordList(list).collect {
    case (ruleInput, pw) if rule(ruleInput, pw) => pw
  }

  def parsePasswordList(list: List[String]): List[(PasswordRuleInput, String)] = list.map {
    case passwordRegEx(min, max, char, password) =>
      Try((PasswordRuleInput(char.charAt(0), min.toInt, max.toInt), password)).toOption
    case _ => None
  }.collect {
    case Some(s) => s
  }
}

trait PasswordRule {
  def apply(input: PasswordRuleInput, password: String): Boolean
}

case class PasswordRuleInput(letter: Char, num1: Int, num2: Int)

object Rule1 extends PasswordRule {
  def apply(input: PasswordRuleInput, password: String): Boolean = {
    val count = password.count(_ == input.letter)

    count <= input.num2 && count >= input.num1
  }
}

object Rule2 extends PasswordRule {
  def apply(input: PasswordRuleInput, password: String): Boolean = {
    val charMap = password.toCharArray.zipWithIndex.map(_.swap).toMap
    (charMap.get(input.num1 - 1), charMap.get(input.num2 - 1)) match {
      case (Some(input.letter), Some(input.letter)) => false
      case (Some(input.letter), _) => true
      case (_, Some(input.letter)) => true
      case _ => false
    }
  }
}
