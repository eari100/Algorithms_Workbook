package Beakjoon.implementation

import scala.io.StdIn

/**
 * @source: https://www.acmicpc.net/problem/23037 (5의 수난)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.06.30 (O)
 * */
object Q23037 {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine

    var result = 0
    n.toCharArray.foreach(x => {
      result += Math.pow(Character.getNumericValue(x), 5).toInt
    })

    print(result)
  }
}
