package com.occ

import java.io.File
import com.typesafe.scalalogging.LazyLogging
import scala.io.Source

/** This App calculate the score value of names collection by sorting it alphabetically
 * and sum the individual scores for all the names. */
object ScoreValueCalculatorApp extends App with LazyLogging {

  if (args.length == 0) {
    throw new RuntimeException("File path not provided")
  }
  val filename = args(0)

  val file = new File(filename)
  val names = Source.fromFile(file).getLines().flatMap(_.split(',').map(_.replaceAll("\"", ""))).toList

  val calculateNamesScoreValue = new CalNamesScoreValue(names)
  val scoreValue = calculateNamesScoreValue.getScoreValues
  logger.info(s"The Score Value for given names is $scoreValue")

}
