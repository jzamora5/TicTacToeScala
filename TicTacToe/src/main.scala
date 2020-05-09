import logic._
import java.awt._
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing._
import java.lang.Thread

object main{
    val logic = new logicGame()
    val frame = new JFrame("Tic Tac Toe")
    val panel = new JPanel()
    val button = new JButton()
    val button2 = new JButton()
    val button3 = new JButton()
    val button4 = new JButton()
    val button5 = new JButton()
    val button6 = new JButton()
    val button7 = new JButton()
    val button8 = new JButton()
    val button9 = new JButton()
    var turn = 2

    val matrix = Array.ofDim[Int](3,3)
    var cpu_mark = 0
    var number_players = -1
    while (number_players < 1 || number_players >= 3){
        number_players = JOptionPane.showInputDialog(null, "Number of players:\n1\n2\n").toInt
    }
    var user_mark = -1
    if (number_players == 1) {
        while (user_mark < 0 || user_mark >= 2){
            user_mark = JOptionPane.showInputDialog(null, "Choose order you want to play:\n0-First\n1-Second\n").toInt
        }
    }
    else {
        user_mark = 0
    }
    var difficulty = -1
    if (number_players == 1) {
        while (difficulty < 0 || difficulty >= 3){
            difficulty = JOptionPane.showInputDialog(null, "Choose difficulty:\n0-Easy\n1-Medium\n2-Hard\n").toInt
        }
    }
    if (user_mark == 0) {
        cpu_mark = 1
    }
    else {
        turn = 1
    }



  def main(args: Array[String]): Unit = {
    logic.initializeMatrix(matrix, logic.CLEAR)
    panel.setLayout(null)
    button.setBounds(0, 0, 200, 200)
    button.setName("1")
    button.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if ((turn % 2 == 0 && button.getText() == "")) {
                matrix(0)(0) = user_mark
                if (user_mark == 1) {
                    button.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                    }
                }
                else {
                    button.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button.setFont(new Font("Arial", Font.PLAIN, 150))
                button.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button2.setBounds(0, 200, 200, 200)
    button2.setName("4")
    button2.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button2.getText() == "") {
                matrix(1)(0) = user_mark
                if (user_mark == 1) {
                    button2.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button2.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button2.setFont(new Font("Arial", Font.PLAIN, 150))
                button2.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button3.setBounds(0, 400, 200, 200)
    button3.setName("7")
    button3.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button3.getText() == "") {
                matrix(2)(0) = user_mark
                if (user_mark == 1) {
                    button3.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button3.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }

                button3.setFont(new Font("Arial", Font.PLAIN, 150))
                button3.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button4.setBounds(200, 0, 200, 200)
    button4.setName("2")
    button4.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button4.getText() == "") {
                matrix(0)(1) = user_mark
                if (user_mark == 1) {
                    button4.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button4.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button4.setFont(new Font("Arial", Font.PLAIN, 150))
                button4.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button5.setBounds(200, 200, 200, 200)
    button5.setName("5")
    button5.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button5.getText() == "") {
                matrix(1)(1) = user_mark
                if (user_mark == 1) {
                    button5.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button5.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn =  turn + 1
                }
                button5.setFont(new Font("Arial", Font.PLAIN, 150))
                button5.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button6.setBounds(200, 400, 200, 200)
    button6.setName("8")
    button6.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button6.getText() == "") {
                matrix(2)(1) = user_mark
                if (user_mark == 1) {
                    button6.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button6.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button6.setFont(new Font("Arial", Font.PLAIN, 150))
                button6.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button7.setBounds(400, 0, 200, 200)
    button7.setName("3")
    button7.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button7.getText() == "") {
                matrix(0)(2) = user_mark
                if (user_mark == 1) {
                    button7.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button7.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button7.setFont(new Font("Arial", Font.PLAIN, 150))
                button7.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button8.setBounds(400, 200, 200, 200)
    button8.setName("6")
    button8.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if (turn % 2 == 0 && button8.getText() == "") {
                matrix(1)(2) = user_mark
                if (user_mark == 1) {
                    button8.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button8.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button8.setFont(new Font("Arial", Font.PLAIN, 150))
                button8.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    button9.setBounds(400, 400, 200, 200)
    button9.setName("9")
    button9.addActionListener(new ActionListener() {
        def actionPerformed(e:ActionEvent) {
            if ((turn % 2 == 0 && button9.getText() == "")) {
                matrix(2)(2) = user_mark
                if (user_mark == 1) {
                    button9.setText("X")
                    if (number_players == 2) {
                        user_mark = 0
                        cpu_mark = 1
                    }
                }
                else {
                    button9.setText("O")
                    if (number_players == 2) {
                        user_mark = 1
                        cpu_mark = 0
                    }
                }
                if (number_players == 2) {
                    turn = turn + 2
                }
                else {
                    turn = turn + 1
                }
                button9.setFont(new Font("Arial", Font.PLAIN, 150))
                button9.setFocusable(false)
                if (((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1))
                    && number_players == 1) {
                    Thread.sleep(500)
                    logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
                }
                var win = logic.checkWin(matrix, cpu_mark, user_mark)
                winner(win)
                logic.printMatrix(matrix)
            }
        }
    });
    panel.add(button)
    panel.add(button2)
    panel.add(button3)
    panel.add(button4)
    panel.add(button5)
    panel.add(button6)
    panel.add(button7)
    panel.add(button8)
    panel.add(button9)
    frame.add(panel)
    frame.setSize(600, 630)
    frame.setResizable(false)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")))
    frame.setVisible(true)
    if (cpu_mark == 0 && number_players == 1) {
        logic.moveCPU(matrix, cpu_mark, user_mark, difficulty)
        var win = logic.checkWin(matrix, cpu_mark, user_mark)
        winner(win)
        logic.printMatrix(matrix)
    }
  }

  def winner(win: Int) {
      println(win)
      if (win == 0) {
          check()
      }
      else if (win == 1) {
          JOptionPane.showMessageDialog(null, "Player 1 Wins")
          System.exit(1)
      }
      else if (win == 2) {
          check()
          if (number_players > 1 && user_mark == 0) {
            JOptionPane.showMessageDialog(null, "Player 2 wins")
          }
          else if (number_players > 1 && user_mark == 1) {
            JOptionPane.showMessageDialog(null, "Player 1 wins")
          }
          else {
            JOptionPane.showMessageDialog(null, "CPU wins")
          }
          System.exit(1)
      }
      else {
          check()
          JOptionPane.showMessageDialog(null, "Draw")
          System.exit(1)
      }
  }

  def check() {
      var pos = 0
      if ((turn % 2 != 0 && user_mark == 0) || (turn % 2 != 0 && user_mark == 1)) {
        turn = turn + 1
        for( i <- 0 to 2) {
            for (j <- 0 to 2) {
              if (matrix(i)(j) == cpu_mark) {
                  pos = (i * 3 + j) + 1
                  checking(pos)
              }
            }
        }
      }
  }

  def checking(pos: Int) {
        if (button.getName() == pos.toString && button.getText() == "") {
            if (cpu_mark == 0) {
                button.setText("O")
            }
            else {
                button.setText("X")
            }
            button.setFont(new Font("Arial", Font.PLAIN, 150));
            button.setFocusable(false)
        }
        else if (button2.getName() == pos.toString && button2.getText() == "") {
            if (cpu_mark == 0) {
                button2.setText("O")
            }
            else {
                button2.setText("X")
            }
            button2.setFont(new Font("Arial", Font.PLAIN, 150));
            button2.setFocusable(false)
        }
        else if (button3.getName() == pos.toString && button3.getText() == "") {
            if (cpu_mark == 0) {
                button3.setText("O")
            }
            else {
                button3.setText("X")
            }
            button3.setFont(new Font("Arial", Font.PLAIN, 150));
            button3.setFocusable(false)
        }
        else if (button4.getName() == pos.toString && button4.getText() == "") {
            if (cpu_mark == 0) {
                button4.setText("O")
            }
            else {
                button4.setText("X")
            }
            button4.setFont(new Font("Arial", Font.PLAIN, 150));
            button4.setFocusable(false)
        }
        else if (button5.getName() == pos.toString && button5.getText() == "") {
            if (cpu_mark == 0) {
                button5.setText("O")
            }
            else {
                button5.setText("X")
            }
            button5.setFont(new Font("Arial", Font.PLAIN, 150));
            button5.setFocusable(false)
        }
        else if (button6.getName() == pos.toString && button6.getText() == "") {
            if (cpu_mark == 0) {
                button6.setText("O")
            }
            else {
                button6.setText("X")
            }
            button6.setFont(new Font("Arial", Font.PLAIN, 150));
            button6.setFocusable(false)
        }
        else if (button7.getName() == pos.toString && button7.getText() == "") {
            if (cpu_mark == 0) {
                button7.setText("O")
            }
            else {
                button7.setText("X")
            }
            button7.setFont(new Font("Arial", Font.PLAIN, 150));
            button7.setFocusable(false)
        }
        else if (button8.getName() == pos.toString && button8.getText() == "") {
            if (cpu_mark == 0) {
                button8.setText("O")
            }
            else {
                button8.setText("X")
            }
            button8.setFont(new Font("Arial", Font.PLAIN, 150));
            button8.setFocusable(false)
        }
        else {
            if (button9.getName() == pos.toString && button9.getText() == "") {
                if (cpu_mark == 0) {
                    button9.setText("O")
                }
                else {
                    button9.setText("X")
                }
                button9.setFont(new Font("Arial", Font.PLAIN, 150));
                button9.setFocusable(false)
            }
        }
    }

}
