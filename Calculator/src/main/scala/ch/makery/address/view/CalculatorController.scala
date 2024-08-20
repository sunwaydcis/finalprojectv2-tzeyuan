package ch.makery.address.view

import scalafx.event.ActionEvent
import scalafx.scene.control.TextField
import scalafxml.core.macros.sfxml
import ch.makery.address.model.CalculatorModel
import javafx.scene.control.{Button => jfxButton}

@sfxml
class CalculatorController(
                            private val display: TextField,
                            private val btn0: jfxButton,
                            private val btn1: jfxButton,
                            private val btn2: jfxButton,
                            private val btn3: jfxButton,
                            private val btn4: jfxButton,
                            private val btn5: jfxButton,
                            private val btn6: jfxButton,
                            private val btn7: jfxButton,
                            private val btn8: jfxButton,
                            private val btn9: jfxButton,
                            private val btnPlus: jfxButton,
                            private val btnMinus: jfxButton,
                            private val btnMultiply: jfxButton,
                            private val btnDivide: jfxButton,
                            private val btnEqual: jfxButton,
                            private val btnClear: jfxButton
                          ) {
  private val model = new CalculatorModel()

  // Function to handle button clicks
  def handleButtonAction(event: ActionEvent): Unit = {
    val buttonText = event.getSource.asInstanceOf[jfxButton].getText
    buttonText match {
      case "CL" => model.clear()
      case "="  => model.calculate()
      case _    => model.appendInput(buttonText)
    }
    updateDisplay()
  }

  // Function to update the display field
  private def updateDisplay(): Unit = {
    display.text = model.getCurrentResult
  }
}
