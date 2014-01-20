package us.marek.ds

import org.scalatest.fixture
import java.util.EmptyStackException

class MaxStackTestSuite extends fixture.FunSpec {
  
  type FixtureParam = MaxStack[Int]
  
  def withFixture(test: OneArgTest) {
    val stack = new MaxStack[Int](10)
    test(stack)
  }
  
  describe("MaxStack") {
    
    val data = Seq(3, 2, 1, 6, 7, 9, 5, 8, 4, 0)
    
    it("should receive all data using varargs if not full") { stack =>
      stack.push(data :_*)
      val size = stack.size
      assert(size == data.size, s"Did not receive all data, stack size = $size instead of ${data.size}")
      assert(stack.peek == 0, s"the value on top of the stack is incorrect, should be ${data.last}")
    }
    
    it("should receive all data and keep track of max using individual push if not full") { stack =>
      for (i <- 1 to data.size) {
        stack.push(data(i - 1))
        val size = stack.size
        assert(size == i, s"Stack size should be ${i}, but is $size")
        val stackMax = stack.getMax
        val subSeqMax = data.take(i).max
        assert(stackMax == subSeqMax, s"Stack max was $stackMax, but the subsequence max was $subSeqMax")
      }
    }
    
    it("should thow a StackOverflowError when pushing data to a full stack") { stack => 
      stack.push(data :_*)
      intercept[StackOverflowError] {
        stack.push(42)
      }
    }
    
    it("should pop all data correctly") { stack =>
      stack.push(data :_*)
      data.reverse.foreach(datum => {
        val stackDatum = stack.pop()
        assert(datum == stackDatum, s"Popped $stackDatum from stack, but expected $datum")
      })
    }
    
    it("should keep track of maximum while popping") { stack => 
      stack.push(data :_*)
      val revData = data.reverse
      for (i <- 1 to revData.size) {
        /* we should pop all the way without an EmptyStackException,
           but when we pop the last element, there is no max */
        stack.pop() 
        if (i < revData.size) {
          val stackMax = stack.getMax 
          val seqMax = revData.drop(i).max
          assert(stackMax == seqMax, s"Stack max is $stackMax, but sequence max is $seqMax")
        }
        
      }
    }
    
    it("should throw an EmptyStackException when popping from an empty stack") { stack =>
      intercept[EmptyStackException] {
        stack.pop()
      }
    } 
  }  
}