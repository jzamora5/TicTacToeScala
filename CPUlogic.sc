import scala.util.Random

var CLEAR = 9

def printMatrix(array: Array[Array[Int]]) : Unit = {
    for( i <- 0 to 2) {
      println(array(i).mkString(" | "))
      if (i != 2) {
        println("----------")
      }
    }
  
    println("----------------------")
    println("----------------------")
}


def initializeMatrix(array: Array[Array[Int]], n :Int) : Unit = {
    for( i <- 0 to 2) {
      for (j <- 0 to 2) {
        array(i)(j) = n
      }
    }
}


def moveCPU (array: Array[Array[Int]], mark: Int) : Unit = {
    var limitLow = 0
    var limitHigh = 3
  
    if (array(0).sum == CLEAR * 3 && array(1).sum == CLEAR * 3 && array(2).sum == CLEAR * 3){
      var randRow =  Random.between(limitLow, limitHigh)
      var randColumn = Random.between(limitLow, limitHigh)
  
      array(randRow)(randColumn) = mark
    }
  
    
}



val matrix = Array.ofDim[Int](3,3)
initializeMatrix(matrix, CLEAR)
printMatrix(matrix)


// Mark = 0 is o - 1 is x

var mark = 0

moveCPU(matrix, mark)
printMatrix(matrix)

moveCPU(matrix, mark)
printMatrix(matrix)

