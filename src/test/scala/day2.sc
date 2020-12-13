
val regex = """(\d+)\-(\d+) (.)\: (.+)""".r


"4-5 l: rllllj" match {
  case regex(min, max, letter, pw) => (min, letter, max, pw)
}

val pw = "abcdefg"




