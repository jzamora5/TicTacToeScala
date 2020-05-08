import java.awt._

import javax.swing._

object main {
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

  def main(args: Array[String]): Unit = {
    panel.setLayout(null)
    button.setFocusable(false)
    button.addActionListener(pressButton(button, ))
    button.setFont(new Font("Arial", Font.PLAIN, 150));
    button.setBounds(0, 0, 200, 200)
    button2.setBounds(0, 200, 200, 200)
    button3.setBounds(0, 400, 200, 200)
    button4.setBounds(200, 0, 200, 200)
    button5.setBounds(200, 200, 200, 200)
    button6.setBounds(200, 400, 200, 200)
    button7.setBounds(400, 0, 200, 200)
    button8.setBounds(400, 200, 200, 200)
    button9.setBounds(400, 400, 200, 200)
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
    frame.setSize(800, 630)
    frame.setResizable(false)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setVisible(true)
  }

}
