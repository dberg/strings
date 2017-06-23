package com.cybergstudio.strings

import org.scalatest._

class ZAlgorithmSpec extends FlatSpec with Matchers with Tests {
  "The ZAlgorithm method" should "match substrings" in {
    tests.foreach { case (pattern, text, result) =>
      ZAlgorithm.issubstring(pattern, text) should be (result)
    }
  }
}
