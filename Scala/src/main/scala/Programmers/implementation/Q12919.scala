package Programmers.implementation

/**
 * @source: https://programmers.co.kr/learn/courses/30/lessons/12919 (서울에서 김서방 찾기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 *     1. 22.06.25 (O)
 * */
class Q12919 {
  object Solution {
    def solution(seoul: Vector[String]): String = {
      val x: Int = seoul.indexOf("Kim")
      return s"김서방은 ${x}에 있다"
    }
  }
}
