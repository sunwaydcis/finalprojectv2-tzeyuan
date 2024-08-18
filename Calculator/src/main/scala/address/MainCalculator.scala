package address

object MainCalculator extends JFXApp {
  def start(): Unit = {
    val controller = new CalculatorController()
    stage = new PrimaryStage {
      title = "Calculator"
      scene = new Scene {
        root = controller.layout
        stylesheets.add(getClass.getResource("/ch/makery/address/view/calculator.css").toExternalForm)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    launch(args)
  }
}
