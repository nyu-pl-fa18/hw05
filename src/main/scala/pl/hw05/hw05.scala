package pl.hw05

import scala.annotation.tailrec

object hw05 extends App {

  // Problem 1: Tail Recursion

  // Naive inefficient implementation of binom used for testing
  def binom_naive(n: Int, k: Int): Int = {
    require (0 <= k && k <= n)
    if (n == k || k == 0) 1 else binom_naive(n - 1, k - 1) + binom_naive(n - 1, k)
  }
  
  // Your implementation of Part 1
  def binom(n: Int, k: Int): Int = {
    require (0 <= k && k <= n)
    ???
  }
  
  // Naive inefficient implementation of trib used for testing
  def trib_naive(n: Int): Int = {
    require (0 <= n)
    n match {
      case 0 | 1 => 0
      case 2 => 1
      case _ => trib_naive(n - 1) + trib_naive(n - 2) + trib_naive(n - 3)
    }
  }
  
  // Your implementation of Part 2
  def trib(n: Int): Int = {
    require (0 <= n)
    ???
  }
  
  
  // Add testing code here, or better yet, add them as additional unit tests to test/scala/pl/hw05/hw05Spec.scala
  
}
