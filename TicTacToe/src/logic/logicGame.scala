package logic

class logicGame {

  import scala.util.Random

  // CLEAR must be at least 3
  var CLEAR = 9

  // No Danger is -1
  // Rows are 0 1 2
  // Columns are 3 4 5
  // Diagonals left-right are 6 7

  var MOVE = -1

  def printMatrix(array: Array[Array[Int]]): Unit = {
    for (i <- 0 to 2) {
      println(array(i).mkString(" | "))
      if (i != 2) {
        println("----------")
      }
    }

    println("----------------------")
    println("----------------------")
  }


  def initializeMatrix(array: Array[Array[Int]], n: Int): Unit = {
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        array(i)(j) = n
      }
    }
  }


  def addDiagonal(array: Array[Array[Int]], start_i: Int): Int = {
    var sum = 0
    var j = 0
    var i = start_i
    var move_i = 0

    if (start_i == 0) {
      move_i = 1

    }
    else {
      move_i = -1
    }

    while (i != (start_i + (move_i * 3))) {
      sum += array(i)(j)
      i += move_i
      j += 1
    }

    return sum
  }


  // Mode 0 Checks for Possible win, Mode 1 checks for a possible move leading to win

  def checkMove(array: Array[Array[Int]], cpu_mark: Int, user_mark: Int, mode: Int): Int = {
    /*
       [_][_][_]
       [_][_][_]
       [_][_][_]
    */
    var sumCheck = CLEAR + (user_mark * 2)
    var checkRand = 0
    var randMove = 0

    if (mode == 1) {
      sumCheck = (CLEAR * 2) + cpu_mark
      randMove = Random.between(0, 2)
    }


    /* Same row
       [_][_][_]
       [x][x][_]
       [_][_][_]
    */
    if (array(0).sum == sumCheck) {
      MOVE = 0
    }

    if (array(1).sum == sumCheck) {
      MOVE = 1
    }

    if (array(2).sum == sumCheck) {
      MOVE = 2
    }

    if (MOVE == 0 || MOVE == 1 || MOVE == 2) {
      var i = MOVE
      for (j <- 0 to 2) {
        if (array(i)(j) == CLEAR && checkRand == randMove) {
          array(i)(j) = cpu_mark
          return 1
        }
        if (array(i)(j) == CLEAR) {
          checkRand += 1
        }
      }
    }

    /* Same column
       [x][_][_]
       [x][_][_]
       [_][_][_]
    */


    if ((array(0)(0) + array(1)(0) + array(2)(0)) == sumCheck) {
      MOVE = 3
    }

    if ((array(0)(1) + array(1)(1) + array(2)(1)) == sumCheck) {
      MOVE = 4
    }

    if ((array(0)(2) + array(1)(2) + array(2)(2)) == sumCheck) {
      MOVE = 5
    }

    if (MOVE == 3 || MOVE == 4 || MOVE == 5) {
      var j = MOVE - 3
      for (i <- 0 to 2) {
        if (array(i)(j) == CLEAR && checkRand == randMove) {
          array(i)(j) = cpu_mark
          return 1
        }
        if (array(i)(j) == CLEAR) {
          checkRand += 1
        }
      }
    }
    /* Diagonal
       [x][_][_]
       [_][x][_]
       [_][_][_]
    */

    if (addDiagonal(array, 0) == sumCheck) {
      MOVE = 6
    }

    if (addDiagonal(array, 2) == sumCheck) {
      MOVE = 7
    }


    if (MOVE == 6 || MOVE == 7) {
      var i = 0
      var move_i = 1
      if (MOVE == 7) {
        i = 2
        move_i = -1
      }

      for (j <- 0 to 2) {
        if (array(i)(j) == CLEAR && checkRand == randMove) {
          array(i)(j) = cpu_mark
          return 1
        }

        if (array(i)(j) == CLEAR) {
          checkRand += 1
        }
        i += move_i
      }
    }

    return 0

  }

  def randomMove(array: Array[Array[Int]], cpu_mark: Int): Int = {
    var limitLow = 0
    var limitHigh = 3

    for (i <- 0 to 5) {
      var randRow = Random.between(limitLow, limitHigh)
      var randColumn = Random.between(limitLow, limitHigh)

      if (array(randRow)(randColumn) == CLEAR) {
        array(randRow)(randColumn) = cpu_mark
        return 1
      }

    }

    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        if (array(i)(j) == CLEAR) {
          array(i)(j) = cpu_mark
          return 1
        }
      }
    }

    return 0

  }

  def logicMove(array: Array[Array[Int]], cpu_mark: Int, user_mark: Int): Int = {

    var moved = 0
    var rand_moved = 0

    // Mode 0 to check for win of CPU
    moved = checkMove(array, cpu_mark, cpu_mark, 0)
    if (moved == 1) {
      return 1
    }

    // Mode 0 to check for win of user
    moved = checkMove(array, cpu_mark, user_mark, 0)
    if (moved == 1) {
      return 1
    }

    // Mode 0 to check for win of cpu (both marks cpu)
    moved = checkMove(array, cpu_mark, cpu_mark, 0)
    if (moved == 1) {
      return 1
    }

    // Mode 1 to check for good move of cpu (both marks cpu)
    moved = checkMove(array, cpu_mark, cpu_mark, 1)
    if (moved == 1) {
      return 1
    }

    rand_moved = randomMove(array, cpu_mark)
    if (rand_moved == 1) {
      return 1
    }

    return 0

  }

  def moveCPU(array: Array[Array[Int]], cpu_mark: Int, user_mark: Int, difficulty: Int): Unit = {

    var mediumRand = 0
    var moved = 0
    var rand_moved = 0

    // EMPTY BOARD -------------------------------------------
    if (array(0).sum == CLEAR * 3 && array(1).sum == CLEAR * 3 && array(2).sum == CLEAR * 3) {
      moved = randomMove(array, cpu_mark)
      if (moved == 0) {
        println("Error: Did not position CPU")
      }
      MOVE = -1
      return
    }

    if (difficulty == 0) {
      // EASY ALL RANDOM
      moved = randomMove(array, cpu_mark)
    } else if (difficulty == 1) {
      // MEDIUM SEMI-RANDOM
      mediumRand = Random.between(0, 2)
      if (mediumRand == 0) {
        moved = randomMove(array, cpu_mark)
      } else {
        moved = logicMove(array, cpu_mark, user_mark)
      }
    } else {
      // HARD ALL LOGIC
      moved = logicMove(array, cpu_mark, user_mark)
    }

    MOVE = -1

    if (moved == 0) {
      println("Error: Did not position CPU")
    }

  }

  def checkWin(array: Array[Array[Int]], cpu_mark: Int, user_mark: Int): Int = {
    // 0 No Win ---- 1 if User wins ---- 2 if CPU / User 2 Wins -- 3 Draw

    var sumUser = user_mark * 3
    var sumCPU = cpu_mark * 3

    // CHECK FOR ROWS ----------------------------------

    if (array(0).sum == sumUser) {
      return 1
    } else if (array(0).sum == sumCPU) {
      return 2
    }

    if (array(1).sum == sumUser) {
      return 1
    } else if (array(1).sum == sumCPU) {
      return 2
    }

    if (array(2).sum == sumUser) {
      return 1
    } else if (array(2).sum == sumCPU) {
      return 2
    }

    // CHECK FOR COLUMNS ----------------------------------

    if ((array(0)(0) + array(1)(0) + array(2)(0)) == sumUser) {
      return 1
    } else if ((array(0)(0) + array(1)(0) + array(2)(0)) == sumCPU) {
      return 2
    }

    if ((array(0)(1) + array(1)(1) + array(2)(1)) == sumUser) {
      return 1
    } else if ((array(0)(1) + array(1)(1) + array(2)(1)) == sumCPU) {
      return 2
    }

    if ((array(0)(2) + array(1)(2) + array(2)(2)) == sumUser) {
      return 1
    } else if ((array(0)(2) + array(1)(2) + array(2)(2)) == sumCPU) {
      return 2
    }

    // CHECK FOR DIAGONALS ----------------------------------

    if (addDiagonal(array, 0) == sumUser) {
      return 1
    }
    else if (addDiagonal(array, 0) == sumCPU) {
      return 2
    }

    if (addDiagonal(array, 2) == sumUser) {
      return 1
    } else if (addDiagonal(array, 2) == sumCPU) {
      return 2
    }


    // CHECK DRAW

    if (array(0).sum < CLEAR && array(1).sum < CLEAR && array(2).sum < CLEAR) {
      return 3
    }

    return 0
  }
}