package com.cybergstudio.strings

import org.scalatest.flatspec._
import org.scalatest.matchers._

class ZAlgorithmSpec extends AnyFlatSpec with should.Matchers with Tests {
  "The ZAlgorithm method" should "match substrings" in {
    tests.foreach { case (pattern, text, result) =>
      ZAlgorithm.issubstring(pattern, text) should be (result)
    }
  }
}
