package me.jamc

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestListExerciese extends FunSuite {
  
  test("Q1: find last element"){
    assert(ListExercises.last(List(1,1,2,3,5,8)) == 8)
    intercept[java.util.NoSuchElementException]{ListExercises.last(List())}
  }
  
  test("Q2: find the last but one element of a list"){
    //more than 2 elements
    assert(ListExercises.penultimate(List(1,1,2,3,5,8)) == 5)
    //only 1 elements
    intercept[java.util.NoSuchElementException]{ListExercises.penultimate(List(1))}
    //empty list
    intercept[java.util.NoSuchElementException]{ListExercises.penultimate(List())}
  }
  
  test("Q3: Find the Kth element of a list."){
    //element exist
    assert(ListExercises.nth(5, List(1,2,3,4,5,6,7)) == 6)
    
    //element does not exist
    intercept[java.util.NoSuchElementException]{ListExercises.nth(2, List(1))}
  }
  
  test("Q4: Find the number of elements of a list."){
    //empty list
    assert(ListExercises.length(List()) == 0)
    
    //non empty list
    assert(ListExercises.length(List(1,2,3,4,5)) == 5)
  }
  
  test("Q5: Reverse a list"){
    //non empty list
    assert(ListExercises.reverse(List(1, 1, 2, 3, 5, 8)) == List(8,5,3,2,1,1))
    
    //empty list
    assert(ListExercises.reverse(List()) == List())
  }
  
  test("Q6: Find out whether a list is a palindrome."){
    assert(ListExercises.isPalindrome(List(1, 2, 3, 2, 1)))
    assert(ListExercises.isPalindrome(List(1, 2, 3, 4, 1)) == false)
    assert(ListExercises.isPalindrome(List(1, 2, 3, 3, 2, 1)))
  }
  
  test("Q7: Flatten a nested list structure."){
    assert(ListExercises.flatten(List(List(1, 1, List()), 2, List(3, List(5, 8)), List())) == List(1,1,2,3,5,8))
    assert(ListExercises.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1,1,2,3,5,8))
  }
  
  test("Q8: Eliminate consecutive duplicates of list elements."){
    //non empty list
    assert(ListExercises.compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) 
        == List('a, 'b, 'c, 'a, 'd, 'e))
    //empty list
    assert(ListExercises.compress(List()) == List())
  }
  
  test("Q9: Pack consecutive duplicates of list elements into sublists."){
    //non empty list
    assert(ListExercises.pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) 
        == List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  
    //empty list
    assert(ListExercises.pack(List()) == List())
  }
  
  test("Q10: Run-length encoding of a list."){
    assert(ListExercises.encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }
  
  test("Q11: Modified run-length encoding."){
    assert(ListExercises.encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) 
        == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    )
  }
  
  test("Q12: Decode a run-length encoded list."){
    assert(ListExercises.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
        == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )
  }
  
   test("Q13: Run-length encoding of a list (direct solution)."){
    assert(ListExercises.encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
        == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }
  
  test("Q14: Duplicate the elements of a list."){
    //Normal case
    assert(ListExercises.duplicate(List('a, 'b, 'c, 'c, 'd))
      == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    )
    
    //duplicate a empty list
     assert(ListExercises.duplicate(List()) == List())
  }
  
  test("Q15: Duplicate the elements of a list a given number of times."){
    //Normal case
    assert(ListExercises.duplicateN(3, List('a, 'b, 'c, 'c, 'd))
        == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
        
    //Copy 0 times makes an empty list
    assert(ListExercises.duplicateN(0, List('a, 'b, 'c, 'c, 'd))
        == List())
        
    //Copy an empty list 10 times
    assert(ListExercises.duplicateN(10, List()) == List())
  }
}