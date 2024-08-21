package ch.makery.address.model

abstract class Operation {
  def execute(operand1: Double, operand2: Double): Double
}

class Addition extends Operation {
  override def execute(operand1: Double, operand2: Double): Double = operand1 + operand2
}

class Subtraction extends Operation {
  override def execute(operand1: Double, operand2: Double): Double = operand1 - operand2
}

class Multiplication extends Operation {
  override def execute(operand1: Double, operand2: Double): Double = operand1 * operand2
}

class Division extends Operation {
  override def execute(operand1: Double, operand2: Double): Double = operand1 / operand2
}
