package ch.makery.address

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import javafx.{scene => jfxs}

object MainCalculator extends JFXApp {

  val resource = getClass.getResource("/ch/makery/address/view/Calculator.fxml")
  val root = FXMLView(resource, NoDependencyResolver)

  stage = new PrimaryStage {
    title = "Calculator"
    scene = new Scene(root)
  }
}
