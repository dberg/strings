package com.cybergstudio.strings

import org.scalatest._

class BCRSpec extends FlatSpec with Matchers  with Tests {
  "The BCR methods" should "match substrings" in {
    tests.foreach { case (pattern, text, result) =>
      BCR.issubstringv1(pattern, text) should be (result)
      BCR.issubstringv2(pattern, text) should be (result)
      BCR.issubstringv3(pattern, text) should be (result)
    }
  }
}
