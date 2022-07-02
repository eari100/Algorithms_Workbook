package Beakjoon.implementation

import scala.io.StdIn

/**
 * @source: https://www.acmicpc.net/problem/11365 (!밀비 급일)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.07.02 (O)
 * */
object Q11365 {
  val sb = new StringBuilder
  def main(args: Array[String]): Unit = {
    decoding
    print(sb)
  }

  def decoding: Unit = {
    val str = StdIn.readLine
    if(str == "END") return
    sb.append(str.reverse).append('\n')
    decoding
  }
}
