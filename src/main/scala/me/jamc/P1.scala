package me.jamc

object P1 extends App {
 
  //Q1: find the last element of a list
  def last(list : List[Int]) : Int = {
    if(list.size > 1) last(list.tail) else list.head
  }
  
  println(last(List(1,1,2,3,5,8)))
  
  
  //Q2: find the last but one element of a list
  def penultimate(list : List[Int]) : Int = {
    if(list.size == 2) list.head else penultimate(list.tail)
  }
  println(penultimate(List(1,1,2,3,5,8)))
  
  
  //Q3: Find the Kth element of a list.
  def nth(n : Int, list : List[Int]) : Int = {
    if(n == 0) list.head else nth(n - 1, list.tail)
  }
  
  println(nth(4, List(1, 1, 2, 3, 5, 8)))
  
  //Q4 : Find the number of elements of a list.
  def length(list : List[Int]) : Int = {
    if(list.nonEmpty) 1 + length(list.tail) else 0
  }
  
  println(length(List()))
  
  //Q5 : Reverse a list.
  def reverse(list : List[Int]) : List[Int] = {
    if(list.nonEmpty) reverse(list.tail) ++ List(list.head) else List()
  }
  
  println(reverse(List(1, 1, 2, 3, 5, 8)))
  
  //Q6 : Find out whether a list is a palindrome.
  def isPalindrome(list : List[Int]) : Boolean = {
   true 
  }
    
  println(isPalindrome(List(1, 2, 3, 2, 1)))
  
}