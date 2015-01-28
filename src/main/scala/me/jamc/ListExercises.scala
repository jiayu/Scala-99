package me.jamc

object ListExercises extends App {
 
  //Q1: find the last element of a list
  def last(list : List[Int]) : Int = list match {
    case Nil => throw new java.util.NoSuchElementException
    case x :: xs => if(list.size > 1) last(list.tail) else list.head
  }
  
  //Q2: find the last but one element of a list
  def penultimate(list : List[Int]) : Int = list match {
    case Nil => throw new java.util.NoSuchElementException
    case x :: xs => if(list.size == 2) list.head else penultimate(list.tail)
  }
  
  //Q3: Find the Kth element of a list.
  def nth(n : Int, list : List[Int]) : Int = list match{
    case Nil => throw new java.util.NoSuchElementException
    case x :: xs => if(n == 0) list.head else nth(n - 1, list.tail)
  }
  
  //Q4 : Find the number of elements of a list.
  def length(list : List[Int]) : Int = {
    if(list.nonEmpty) 1 + length(list.tail) else 0
  }
  
  //Q5 : Reverse a list.
  def reverse(list : List[Int]) : List[Int] = {
    if(list.nonEmpty) reverse(list.tail) ++ List(list.head) else List()
  }
 
  //Q6 : Find out whether a list is a palindrome.
  def isPalindrome(list : List[Int]) : Boolean = { 
    def same(list1 : List[Int] , list2 : List[Int]) : Boolean = (list1, list2) match {
      case (x::xs, y::ys) => if(x == y) same(xs , ys) else false
      case (x::xs, Nil) => false
      case (Nil, y::ys) => false
      case (Nil, Nil) => true 
    }
    
    same(list, reverse(list))
  }
   
  //Q7 : Flatten a nested list structure.
  def  flatten(list : List[Any]) : List[Any] = list match {
    case (x : List[Any]) :: (xs : List[Any]) => flatten(x) ++ flatten(xs)
    case (x : Any) :: (xs : List[Any]) => x :: flatten(xs)
    case Nil => Nil
  }
  
  
}