package com.occ

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class CalNamesScoreValueSpec extends FlatSpec with Matchers {

  behavior of "CalNamesScoreValue"
  it should "calculate the score value for given names" in {
    val names = List("MARY", "PATRICIA", "LINDA", "BARBARA", "VINCENZO", "SHON", "LYNWOOD", "JERE", "HAI")
    val calNamesScoreValue = new CalNamesScoreValue(names)

    val actualValue = calNamesScoreValue.getScoreValues
    val expectedValue = 3194
    expectedValue shouldEqual actualValue
  }

}
