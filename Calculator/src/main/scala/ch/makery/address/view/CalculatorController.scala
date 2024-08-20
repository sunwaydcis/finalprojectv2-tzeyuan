package ch.makery.address.view

import scalafx.event.ActionEvent
import scalafx.scene.control.{Button, TextField}
import scalafxml.core.macros.sfxml
import ch.makery.address.model.CalculatorModel

@sfxml
class CalculatorController(
                            private val display: TextField,
                            private val btn0: Button,
                            private val btn1: Button,
                            private val btn2: Button,
                            private val btn3: Button,
                            private val btn4: Button,
                            private val btn5: Button,
                            private val btn6: Button,
                            private val btn7: Button,
                            private val btn8: Button,
                            private val btn9: Button,
                            private val btnPlus: Button,
                            private val btnMinus: Button,
                            private val btnMultiply: Button,
                            private val btnDivide: Button,
                            private val btnEqual: Button,
                            private val btnClear: Button
                          ) {
  private val model = new CalculatorModel()

  // Function to handle button clicks
  def handleButtonAction(event: ActionEvent): Unit = {
    val buttonText = event.getSource.asInstanceOf[Button].text.value
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
