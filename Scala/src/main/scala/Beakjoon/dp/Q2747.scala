package Beakjoon.dp

import scala.io.StdIn.readInt

/**
 * @source: https://www.acmicpc.net/problem/2747 (피보나치 수)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.06.26 (O)
 * */
object Q2747 {
  def main(args: Array[String]): Unit = {
    val n = readInt
    val arr = new Array[Int](n+1)

    for(i<-1 until(n+1)) {
      if(i == 1) arr(i) = 1
      else arr(i) = arr(i-2) + arr(i-1)
    }

    print(arr(n))
  }
}

