package com.occ

class CalNamesScoreValue(names: List[String]) {

  // ASCII value for A = 65 , Z = 90. The value is set to 64 because 'A'=1 , 'B'=2
  val alphaAsciiValue = 64

  def getScoreValues: Int = {
    val sortedNames = Utilities.sortCollectionInAsc(names)
    findScoreValue(sortedNames)
  }

  /**
   * finds score value for sorted data. For example,
   * LINDA, which is worth 12 +
   * 9 + 14 + 4 + 1 = 40, is the 4th name in the list. So, LINDA would obtain a score of 40 x 4 = 160.
   *
   * @param sortedData - Sorted collection of String for which we have to find correct score
   * @return scoreValue - Calculated Value for the sorted collection of string
   */
  def findScoreValue(sortedData: List[String]): Int = {
    sortedData.zipWithIndex.map { case (name, index) =>
      val numericValues = name.map {
        case char if ((char.toInt >= 65 && char.toInt <= 90) || (char.toInt >= 97 && char.toInt <= 122)) =>
          (char.toUpper.toInt - alphaAsciiValue)
        case ' ' => 0 //Ignore if there is space in between name like for a space between first name and last name
        case other => throw new RuntimeException(s"Expected 'A - Z' or 'a - z'  but found ${other}")
      }
      numericValues.sum * (index + 1)
    }.sum
  }

}
