package pl.hw05

import scala.annotation.tailrec

object hw05 extends App {

  // Problem 1: Tail Recursion

  // Naive inefficient implementation of binom used for testing
  def binomNaive(n: Int, k: Int): Int = {
    require (0 <= k && k <= n)
    if (n == k || k == 0) 1 
    else binomNaive(n - 1, k - 1) + binomNaive(n - 1, k)
  }
  
  // Your implementation of Part 1
  def binom(n: Int, k: Int): Int = {
    require (0 <= k && k <= n)
    ???
  }
  
  // Naive inefficient implementation of trib used for testing
  def tribNaive(n: Int): Int = {
    require (0 <= n)
    n match {
      case 0 | 1 => 0
      case 2 => 1
      case _ => tribNaive(n - 1) + tribNaive(n - 2) + tribNaive(n - 3)
    }
  }
  
  // Your implementation of Part 2
  def trib(n: Int): Int = {
    require (0 <= n)
    ???
  }
  
}
