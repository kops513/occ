package com.occ

import scala.annotation.tailrec

object Utilities {

  /** Sort by Ascending order.
   * For example input is List("PARAS", "KARTIK", "KARAN"), then it should return List("KARAN", "KARTIK", "PARAS")
   * */
  def sortCollectionInAsc[T](names: List[T])(implicit ordered: T => Ordered[T]): List[T] = {

    @tailrec
    def divideNamesGreaterAndSmallerThanPivot(pivot: T, list: List[T], lessThanPivot: List[T], greaterThanPivot: List[T]):
    (List[T], List[T]) = {
      list match {
        case Nil => (lessThanPivot, greaterThanPivot)
        case head :: tail =>
          if (head > pivot) {
            divideNamesGreaterAndSmallerThanPivot(pivot, tail, lessThanPivot, head :: greaterThanPivot)
          } else {
            divideNamesGreaterAndSmallerThanPivot(pivot, tail, head :: lessThanPivot, greaterThanPivot)
          }
      }
    }

    names match {
      case Nil => Nil
      case head :: Nil => List(head)
      case head :: tail =>
        val (lessThanHeadNames, greaterThanHeadNames) = divideNamesGreaterAndSmallerThanPivot(head, tail, Nil, Nil)
        val sortedLessThanHeadNames = sortCollectionInAsc(lessThanHeadNames)
        val sortedGreaterThanHeadNames = sortCollectionInAsc(greaterThanHeadNames)
        sortedLessThanHeadNames ::: (head :: sortedGreaterThanHeadNames)
    }

  }
}
