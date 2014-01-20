package us.marek.ds

import org.scalatest.FlatSpec

// Here I'm using FlatSpec, in MaxStackTestSuite I'll use FunSpec
class FindMedianTestSuite extends FlatSpec {
  
  import FindMedian._
  
  trait FindMedianFixture {
    val oddArray = Array(1, 5, 4, 3, 2)
    val evenArray = oddArray :+6
  }
  
  "Finding median of an odd-length array" should "give the correct value" in new FindMedianFixture {
    val actual = median(oddArray)
    val expected = List(3)
    assert(actual == expected, s"Expected $expected, got $actual")
  }
  
  "Finding median of an even-length array" should "give the correct value" in new FindMedianFixture {
    val actual = median(evenArray)
    val expected = List(3, 4)
    assert(actual == expected, s"Expected $expected, got $actual")
  }
   
}
  /*
  def fixture = new {
    val builder = new StringBuilder("ScalaTest is ")
    val buffer = new ListBuffer[String]
  }
  */
 

/*
object FindMedianTestSuite {

  /**
   * main method for demo
   */
  def main(args: Array[String]): Unit = {

    // print array contents
    def prettyPrint[T](a: Array[T]) = s"Array(${a.mkString(",")})"

    val arr1 = Array(1, 5, 4, 3, 2)
    val arr2 = arr1 :+ 6
    println(s"Array 1 (odd length): ${prettyPrint(arr1)}, median = ${median(arr1)}")
    println(s"Array 2 (even length): ${prettyPrint(arr2)}, median = ${median(arr2)}")
  }
*/