package pl.hw05

import org.scalactic.Tolerance._
import org.scalatest.FlatSpec

import hw05._

class hw05Spec extends FlatSpec {
   
   // Tests for Problem 1
   
   "binom" should "compute the binomial coefficient of n and k" in {
     for (n <- 0 to 10; k <- 0 to n) {
       assert (binom_naive(n, k) === binom(n, k))
     }
   }
  
   "trib" should "compute the n-th tribonacci number" in {
     for (n <- 0 to 10) {
       assert (trib_naive(n) === trib(n))
     }     
   }
}