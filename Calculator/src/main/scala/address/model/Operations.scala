package address.model

trait Operation {
  def execute(x: Double, y: Double): Double
}

object OperationFactory {
  def getOperation(operator: String): Operation = operator match {
    case "+" => new Addition
    case "-" => new Subtraction
    case "*" => new Multiplication
    case "/" => new Division
  }
}

class Addition extends Operation {
  override def execute(x: Double, y: Double): Double = x + y
}

class Subtraction extends Operation {
  override def execute(x: Double, y: Double): Double = x - y
}

class Multiplication extends Operation {
  override def execute(x: Double, y: Double): Double = x * y
}

class Division extends Operation {
  override def execute(x: Double, y: Double): Double = x / y
}
