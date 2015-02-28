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
      case Nil => Nil
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
  
  //Q12 
  def decode(list : List[(Int, Symbol)]) : List[Symbol] = {
    //convert (4,'a) to List(a,a,a,a)
    def convert(t : (Int, Symbol)) : List[Symbol] = if(t._1 > 0) List(t._2) ++ convert((t._1 - 1, t._2)) else List()
    
    list map (x => convert(x)) flatten
  }
  
  //Q13 
  def encodeDirect(list : List[Symbol]) : List[(Int, Symbol)] = {
    
    def subEncode(t : (Int, Symbol), rest : List[Symbol]) : List[(Int , Symbol)] = rest match {
      case x :: xs => if(x == t._2) subEncode((t._1 + 1, t._2), xs) else t :: subEncode((1 , x), xs)
      case Nil => List(t)
    }
    
    subEncode((1, list.head), list.tail)
  }
  
  //Q14
  def duplicate(list : List[Symbol]) : List[Symbol] = {
    if(list.nonEmpty) list.head :: list.head :: duplicate(list.tail) else Nil
  }
  
  //Q15
  def duplicateN(n : Int, list : List[Symbol]) : List[Symbol] = list match {
    case x::xs => if(n > 0) x :: duplicateN( n - 1, List(x)) ++ duplicateN(n, xs) else Nil
    case Nil => Nil
  }
  
  //Q16
  def dropNth(n : Int, list : List[Symbol]) : List[Symbol] = list match {
    case Nil => throw new java.util.NoSuchElementException
    case x::xs => if(n > 0) x :: dropNth(n - 1, xs) else xs
  }
  
  //Q17
  def split(n : Int, list : List[Symbol]) : (List[Symbol],List[Symbol]) = {
      
    def move(n : Int, current : (List[Symbol],List[Symbol])) : (List[Symbol],List[Symbol]) = current match {
       case (x::xs, Nil) => throw new java.util.NoSuchElementException
       case (Nil, Nil) => throw new java.util.NoSuchElementException
       case (Nil, y::ys) => if(n > 0) move(n - 1, (List(y), ys)) else current
       case (x::xs, y::ys) => if(n > 0) move(n - 1,((x::xs) :+ y, ys)) else current
    }   
    
    move(n, (List[Symbol](), list))
  }
  
  //Q18
  def slice(start : Int, end : Int, list : List[Symbol]) : List[Symbol] = {
    split(start, split(end, list)._1)._2
  }
  
  //Q19
  def rotate(n : Int, list : List[Symbol]) : List[Symbol] = list match{
    case Nil => throw new java.util.NoSuchElementException
    case x::xs => {
      if(n > 0) rotate( n-1, xs :+ x) 
      else if(n < 0){
        var splitted = split(list.length + n, list)
        splitted._2 ++ splitted._1
      }else list
    }
  }

  //Q20
  def remove[A](n : Int, list:  List[A]): List[A] = list match{
      case Nil => throw new java.util.NoSuchElementException
      case x::xs => {
        if(n > 0) x :: remove(n - 1, xs) else xs
      }
  }
}