import scala.util.Random

// CLEAR must be at least 3
var CLEAR = 9

// No Danger is -1
// Rows are 0 1 2
// Columns are 3 4 5
// Diagonals left-right are 6 7

var DANGER = -1

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


def addDiagonal(array: Array[Array[Int]], start_i: Int) : Int = {
    var sum = 0
    var j = 0
    var i = start_i
    var move_i = 0

    if (start_i == 0) {
      move_i= 1

    }
    else {
      move_i = -1
    }

    while (i != (start_i + (move_i * 3))){
      sum += array(i)(j)
      i += move_i
      j += 1
    }


    return sum
}


def checkDanger(array: Array[Array[Int]], cpu_mark: Int, user_mark: Int) : Int = {
    /*
       [_][_][_]
       [_][_][_]
       [_][_][_]
    */

    /* Same row
       [_][_][_]
       [x][x][_]
       [_][_][_]
    */
    if (array(0).sum == CLEAR + (user_mark * 2)) {
      DANGER = 0
    }

    if (array(1).sum == CLEAR + (user_mark * 2)) {
      DANGER = 1
    }

    if (array(2).sum == CLEAR + (user_mark * 2)) {
      DANGER = 2
    }


    if (DANGER == 0 || DANGER == 1 || DANGER == 2){
      var i = DANGER
      for (j <- 0 to 2){
        if (array(i)(j) == CLEAR){
          array(i)(j) = cpu_mark
          return 1
        }
      }
    }

    /* Same column
       [x][_][_]
       [x][_][_]
       [_][_][_]
    */


    if ((array(0)(0) + array(1)(0) + array(2)(0)) == CLEAR + (user_mark * 2)){
      DANGER = 3
    }

    if ((array(0)(1) + array(1)(1) + array(2)(1)) == CLEAR + (user_mark * 2)){
      DANGER = 4
    }

    if ((array(0)(2) + array(1)(2) + array(2)(2)) == CLEAR + (user_mark * 2)){
      DANGER = 5
    }

    if (DANGER == 3 || DANGER == 4 || DANGER == 5){
      var j = DANGER - 3
      for (i <- 0 to 2){
        if (array(i)(j) == CLEAR){
          array(i)(j) = cpu_mark
          return 1
        }

      }
    }

    /* Diagonal
       [x][_][_]
       [_][x][_]
       [_][_][_]
    */

    if (addDiagonal(array, 0) == CLEAR + (user_mark * 2)) {
      DANGER = 6
    }

    if (addDiagonal(array, 2) == CLEAR + (user_mark * 2)) {
      DANGER = 7
    }


    if (DANGER == 6 || DANGER == 7){
      var i = 0
      var move_i = 1
      if (DANGER == 7){
        i = 2
        move_i = -1
      }

      for (j <- 0 to 2){
        if (array(i)(j) == CLEAR){
          array(i)(j) = cpu_mark
          return 1
        }
        i += move_i
      }

    }


    return 0

}

def moveCPU (array: Array[Array[Int]], cpu_mark: Int, user_mark: Int) : Unit = {
    var limitLow = 0
    var limitHigh = 3

    if (array(0).sum == CLEAR * 3 && array(1).sum == CLEAR * 3 && array(2).sum == CLEAR * 3){
      var randRow =  Random.between(limitLow, limitHigh)
      var randColumn = Random.between(limitLow, limitHigh)

      array(randRow)(randColumn) = cpu_mark
    }
    else {
      var dang = checkDanger(array, cpu_mark, user_mark)
      if (dang == 1){
        return
      }

      println("No Danger")
    }


}



val matrix = Array.ofDim[Int](3,3)
initializeMatrix(matrix, CLEAR)
printMatrix(matrix)


// Mark = 0 is o - 1 is x

var cpu_mark = 0
var user_mark = 1

matrix(2)(0) = 1
matrix(0)(2) = 1
moveCPU(matrix, cpu_mark, user_mark)
printMatrix(matrix)
