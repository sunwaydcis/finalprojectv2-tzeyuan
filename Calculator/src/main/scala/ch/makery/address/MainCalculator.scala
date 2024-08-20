package ch.makery.address

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Parent, Scene}
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import javafx.{scene => jfxs}

object MainCalculator extends JFXApp {

  val rootResource = getClass.getResource("view/Calculator.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.Parent]
  val scalaRoot: Parent = new Parent(roots){}

  stage = new PrimaryStage {
    title = "Calculator"
    scene = new Scene{
        root = scalaRoot
    }
  }
}
