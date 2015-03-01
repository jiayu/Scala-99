package me.jamc

import org.scalatest.junit.JUnitRunner
import org.scalatest.{ FlatSpec, Matchers, BeforeAndAfter }
import me.jamc.ListExercises._

class TestListExerciese extends FlatSpec  with Matchers
  with BeforeAndAfter {
  


  "List#last " should " find last element in a list" in {
    val input = List(1,1,2,3,5,8)

    ListExercises.last(input) shouldBe 8
  }

  it should " throw exception when it is given an empty list" in {
    intercept[java.util.NoSuchElementException]{last(List())}
  }
  
  "List#penultimate " should " find the last but one element of a list" in { 
    
    ListExercises.penultimate(List(1,1,2,3,5,8)) shouldBe 5
  }
  
  it should " throw exception when it is given a list with one element " in {

    intercept[java.util.NoSuchElementException]{penultimate(List(1))}
  }

  it should " throw exception when it is given an empty list" in {
     //empty list
    intercept[java.util.NoSuchElementException]{ListExercises.penultimate(List())}
  }

  "List#nth" should " Find the Kth element of a list." in {
    //element exist
    assert(ListExercises.nth(5, List(1,2,3,4,5,6,7)) == 6)
  }

  it should " throw exception when n > size of the list" in {
     //element does not exist
    intercept[java.util.NoSuchElementException]{ListExercises.nth(2, List(1))}
  }
  
  "List#length " should " find the number of elements of a list." in {
    //non empty list
    assert(ListExercises.length(List(1,2,3,4,5)) == 5)
  }

  it should " return 0 when it is an empty list" in {
    //empty list
    assert(ListExercises.length(List()) == 0)
    
  }
  
  "List#reverse " should " Reverse a list" in {
    //non empty list
    assert(ListExercises.reverse(List(1, 1, 2, 3, 5, 8)) == List(8,5,3,2,1,1))
    
   
  }

  it should " return itself if it is an empty list" in {
     //empty list
    assert(ListExercises.reverse(List()) == List())
  }
  
  "List#isPalindrome " should " Find out whether a list is a palindrome." in {
    assert(ListExercises.isPalindrome(List(1, 2, 3, 2, 1)))
    assert(ListExercises.isPalindrome(List(1, 2, 3, 4, 1)) == false)
    assert(ListExercises.isPalindrome(List(1, 2, 3, 3, 2, 1)))
  }
  
  "List#flatten" should " Flatten a nested list structure." in {
    assert(ListExercises.flatten(List(List(1, 1, List()), 2, List(3, List(5, 8)), List())) == List(1,1,2,3,5,8))
    assert(ListExercises.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1,1,2,3,5,8))
  }
  
  "List#compress " should " Eliminate consecutive duplicates of list elements." in {
    //non empty list
    assert(ListExercises.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) 
        == List('a, 'b, 'c, 'a, 'd, 'e))
    //empty list
    assert(ListExercises.compress(List()) == List())
  }
  
  "List#pack " should " Pack consecutive duplicates of list elements into sublists." in {
    //non empty list
    assert(ListExercises.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) 
        == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  
    //empty list
    assert(ListExercises.pack(List()) == List())
  }
  
  "List#encode " should " Run-length encoding of a list." in {
    assert(ListExercises.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }
  
  "List#encodeModified " should " Modified run-length encoding." in {
    assert(ListExercises.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) 
        == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    )
  }
  
  "List#decode" should " Decode a run-length encoded list." in {
    assert(ListExercises.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
        == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )
  }
  
   "List#encodeDirect " should " Run-length encoding of a list (direct solution)." in {
    assert(ListExercises.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }
  
  "List#duplicate " should " Duplicate the elements of a list." in {
    //Normal case
    assert(ListExercises.duplicate(List('a, 'b, 'c, 'c, 'd))
      == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    )
    
    //duplicate a empty list
     assert(ListExercises.duplicate(List()) == List())
  }
  
  "List#duplicateN" should " Duplicate the elements of a list a given number of times." in {
    //Normal case
    assert(ListExercises.duplicateN(3, List('a, 'b, 'c, 'c, 'd))
        == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
        
    //Copy 0 times makes an empty list
    assert(ListExercises.duplicateN(0, List('a, 'b, 'c, 'c, 'd))
        == List())
        
    //Copy an empty list 10 times
    assert(ListExercises.duplicateN(10, List()) == List())
  }
  
  "List#dropNth " should " Drop every Nth element from a list." in {
    //Normal 
    assert(ListExercises.dropNth(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      == List('a, 'b, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)    
    )
     
    //drop 0 element
    assert(ListExercises.dropNth(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      == List('b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)    
    )
    
    //drop empty list
     intercept[java.util.NoSuchElementException]{ListExercises.dropNth(5, List())}
    
  }
  
  "List#split " should " Split a list into two parts." in {
    assert(ListExercises.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
        == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
        
    assert(ListExercises.split(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
        == (List('a),List('b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
     
    intercept[java.util.NoSuchElementException]{ListExercises.split(5, List())}
  }
  
  "List#slice "should " Extract a slice from a list." in {
    assert(ListExercises.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      == List('d, 'e, 'f, 'g))
  }
  
  "List#rotate " should " Rotate a list N places to the left." in {
    assert(ListExercises.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
      
    assert(ListExercises.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }

  "List#remove " should " remove the nth number element from the list " in {
    val input = List('a, 'b, 'c)
    val expected = List('a, 'c)

    ListExercises.remove(1, input) shouldBe expected
  }

  it should " throw exception if the n > size of the list" in {
   
    intercept[java.util.NoSuchElementException]{remove(2, List())}
  }

  "List#insertAt" should " return a list with the element at the correct position " in {
    val input = List('a, 'b, 'c)
    val expected = List('a, 'b, 'c, 'd)

    insertAt('d, 3, input) shouldBe expected
  }

  it should " throw exception if n - size > 1 " in {
    val input = List('a, 'b, 'c)

    intercept[java.util.NoSuchElementException]{insertAt('d, 5, input)}
  }

  "List#range " should " return a list with the given range " in {
    val expected = List(1, 2, 3, 4, 5)

    range(1, 5) shouldBe expected
  }

  it should " return a list with single element if start = end" in {
    range(0, 0) shouldBe List(0)
  }

  it should " throw exception if start > end " in {
    intercept[java.lang.Exception]{range(9, 0)}
  }

  "List#randomSelect " should " return a list of element within the given list when n < list.size " in {
    val input = List('a, 'b, 'c, 'd, 'e, 'f)
    val result = randomSelect(3, input)

    result should have size 3
    result.map { e => input should contain(e) } 
  }

  it should " return a list of elements from the given list when n > list.size " in {
    val input = List('a, 'b, 'c, 'd, 'e, 'f)
    intercept[java.lang.Exception]{randomSelect(10, input)}
  }

  "List#lotto " should " return a list of random numbers within the given boundary " in {
    val result = lotto(5, 90)

    result should have size 5
    result.map( _ should (be >= (1) and be <= 90))
  }

  it should " return an empty list if given number is 0 " in {
    lotto(0, 100) should have size 0
  }

  "List#combinations" should "return all possible combinations of a list " in {
    val input = List('a, 'b, 'c, 'd)
    val expected = List(List('a, 'b, 'c), List('a, 'c, 'd),List('a, 'b, 'd), List('b, 'c, 'd))
    val result = combinations(3, input)

    result should have size expected.size
    result.map{ l => expected.exists { _.toSet == l.toSet } shouldBe true}
    
  }

  it should "return a list with only one element when n = list.size " in {
    val input = List('a, 'b, 'c, 'd)
    combinations(4, input) shouldBe List(input)
  }

  it should "throw exception when n > list.size " in {
    val input = List('a, 'b, 'c, 'd)
    intercept[java.lang.Exception]{combinations(10,input)}
  }

  it should "return a list with only one element which is a empty list if n = 0 " in {
    combinations(0, List('a, 'b)) shouldBe List(Nil)
    combinations(0, List()) shouldBe List(Nil)
  }
}