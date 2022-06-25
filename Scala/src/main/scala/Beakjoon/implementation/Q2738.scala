package Beakjoon.implementation

import scala.io.StdIn

/**
 * @source: https://www.acmicpc.net/problem/2738 (행렬 덧셈)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.06.25 (O)
 * */
object Q2738 {
  def main(args: Array[String]): Unit = {
    val input = StdIn.readLine().split(" ")
    val N = input(0).toInt
    val M = input(1).toInt

    val A = Array.ofDim[Int](N, M)
    val B = Array.ofDim[Int](N, M)

    for(i<-0 until N) {
      val arr: Array[Int] = StdIn.readLine().split(" ").map(_.toInt)
      for(j<-0 until M) {
        A(i)(j) = arr(j)
      }
    }

    for(i<-0 until N) {
      val arr: Array[Int] = StdIn.readLine().split(" ").map(_.toInt)
      for(j<-0 until M) {
        B(i)(j) = arr(j)
      }
    }

    for(i<-0 until N) {
      for(j<-0 until M) {
        print(A(i)(j) + B(i)(j) + " ")
      }
      println()
    }
  }
}
