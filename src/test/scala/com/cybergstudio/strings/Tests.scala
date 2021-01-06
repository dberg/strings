package com.cybergstudio.strings

trait Tests {
  val tests = List(
    ("ello", "hello", true),
    ("BAAAAD", "AACCCBAAAAD", true),
    ("BABCCCAAB", "CCCCCCBABCCCAAB", true)
  )

  val testsIndices = List(
    ("ello", "hello", List(1)),
    ("BAAAAD", "AACCCBAAAAD", List(5)),
    ("BABCCCAAB", "CCCCCCBABCCCAAB", List(6)),
    ("aa", "aaaaaaaaa", List(0, 1, 2, 3, 4, 5, 6, 7))
  )
}
