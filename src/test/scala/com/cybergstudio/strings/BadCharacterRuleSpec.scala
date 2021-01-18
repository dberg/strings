package com.cybergstudio.strings

import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.jdk.CollectionConverters._

class BadCharacterRuleSpec extends AnyFlatSpec with should.Matchers with Tests {
  "The BCR methods" should "match substrings" in {
    tests.foreach { case (pattern, text, result) =>
      BadCharacterRule.substringV1(pattern, text) should be (result.asJava)
      BadCharacterRule.substringV2(pattern, text) should be (result.asJava)
      BadCharacterRule.substringV3(pattern, text) should be (result.asJava)
    }
  }
}
