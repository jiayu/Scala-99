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
}