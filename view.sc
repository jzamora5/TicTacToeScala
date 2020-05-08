import java.awt._

import javax.swing._

object main {
  def main(args: Array[String]): Unit = {
    val frame = new JFrame("Tic Tac Toe")
    val panel = new JPanel()
    panel.setLayout(new FlowLayout())
    val label = new JLabel("Example")
    val button = new JButton()
    button.setText("Button")
    panel.add(label)
    panel.add(button)
    frame.add(panel)
    frame.setSize(500, 500)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setVisible(true)
  }

}
