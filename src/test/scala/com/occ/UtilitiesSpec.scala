package com.occ

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class UtilitiesSpec extends FlatSpec with Matchers {

  behavior of "sortCollectionInAsc"
  it should "sort names in ascending order" in {
    val names = List("MARY", "PATRICIA", "LINDA", "BARBARA", "VINCENZO", "SHON", "LYNWOOD", "JERE", "HAI")
    val actualValue = Utilities.sortCollectionInAsc(names)
    val expectedValue = List("BARBARA", "HAI", "JERE", "LINDA", "LYNWOOD", "MARY", "PATRICIA", "SHON", "VINCENZO")
    expectedValue shouldEqual actualValue
  }

}
