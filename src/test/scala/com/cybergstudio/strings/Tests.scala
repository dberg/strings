package com.cybergstudio.strings

trait Tests {
  val tests = List(
    ("ello", "hello", true),
    ("BAAAAD", "AACCCBAAAAD", true),
    ("BABCCCAAB", "CCCCCCBABCCCAAB", true)
  )
}
