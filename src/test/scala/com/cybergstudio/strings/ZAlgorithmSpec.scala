package com.cybergstudio.strings

import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.jdk.CollectionConverters._

class ZAlgorithmSpec extends AnyFlatSpec with should.Matchers with Tests {

  "The ZAlgorithm" should "match substrings" in {
    tests.foreach { case (pattern, text, result) =>
      ZAlgorithm.issubstring(pattern, text) should be (result)
    }
  }

  "The ZAlgorithmV2" should "find indices of substrings" in {
    testsIndices.foreach { case (pattern, text, result) =>
      ZAlgorithmV2.substrings(pattern, text) should be (result.asJava)
    }
  }
}
