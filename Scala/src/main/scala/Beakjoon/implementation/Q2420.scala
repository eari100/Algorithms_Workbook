package Beakjoon.implementation

import scala.io.StdIn

/**
 * @source: https://www.acmicpc.net/problem/2420 (사파리월드)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.06.24 (O)
 * */
object Q2420 {
  def main(args: Array[String]): Unit = {
    val input = StdIn.readLine().split(" ")
    val N:Long = input(0).toLong
    val M:Long = input(1).toLong
    print((N-M).abs)
  }
}
