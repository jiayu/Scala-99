package me.jamc

object ListExercises {
 
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
  
  //Q8: Eliminate consecutive duplicates of list elements.
  def compress(list : List[Symbol]) : List[Symbol] = {
    def subCom(c : Symbol , list : List[Symbol]) : List[Symbol] = list match {
      case x :: xs => if(c == x) subCom(x , xs) else x :: subCom(x , xs)
      case Nil => List()
    }
    
    if(list.nonEmpty) list.head :: subCom(list.head, list.tail) else List()
  }
  
  //Q9
  def pack(list : List[Symbol]) : List[List[Symbol]] = {
    
    def subPack(subList : List[Symbol] , rest : List[Symbol]) : List[List[Symbol]] = (subList, rest) match {
      case (Nil, y :: ys) => subPack(List(y), ys)
      case (x :: xs , y :: ys) => if(x == y)  subPack(x :: x :: xs, ys) else List(subList) ++ subPack(List(y), ys)
      case (x :: xs , Nil) => List(subList)
      case (Nil, Nil) => Nil
    }
    
    subPack(Nil, list)
  }
  
  /*********
   * Starting from here, I am gonna use more list APIs from scala
   */
  
  //Q10
  def encode(list : List[Symbol]) : List[(Int, Symbol)] = {
    pack(list) map ( x => (x.length, x.head ) )
  }
  
  //Q11
  def encodeModified(list : List[Symbol]) : List[Any] = {
    encode(list) map (x => if(x._1 == 1) x._2 else x)
  }
  
}