package Beakjoon.implementation

import scala.io.StdIn.readInt

/**
 * @source: https://www.acmicpc.net/problem/2750 (수 정렬하기)
 * @classfication: implementation
 * @reference: https://www.acmicpc.net/source/38829240 (immutable list)
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.06.27 (O)
 * */
object Q2750 {
  def main(args: Array[String]): Unit = {
    val N = readInt

    var list: List[Int] = List()

    for(i<-0 until N) {
      list = readInt :: list
    }

    list = list.sorted(Ordering.Int)

    list.foreach(println)
  }
}
