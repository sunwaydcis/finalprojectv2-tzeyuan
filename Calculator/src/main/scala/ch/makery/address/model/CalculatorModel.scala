package ch.makery.address.model

class CalculatorModel {
    private var currentInput: String = ""
    private var result: String = "0"

    def appendInput(input: String): Unit = {
      currentInput += input
    }

    def clear(): Unit = {
      currentInput = ""
      result = "0"
    }

    def calculate(): Unit = {
      try {
        result = eval(currentInput).toString
        currentInput = result
      } catch {
        case _: Exception => result = "Error"
      }
    }

    def getCurrentResult: String = {
      if (currentInput.isEmpty) result else currentInput
    }

    private def eval(expression: String): Double = {
      val parser = new scala.util.parsing.combinator.JavaTokenParsers {
        def expr: Parser[Double] = term ~ rep(("+" | "-") ~ term) ^^ {
          case t ~ list => list.foldLeft(t) {
            case (x, "+" ~ y) => applyOperation(new Addition, x, y)
            case (x, "-" ~ y) => applyOperation(new Subtraction, x, y)
          }
        }
        def term: Parser[Double] = factor ~ rep(("*" | "x") ~ factor | ("/" | "÷") ~ factor) ^^ {
          case f ~ list => list.foldLeft(f) {
            case (x, ("*" | "x") ~ y) => applyOperation(new Multiplication, x, y)
            case (x, ("/" | "÷") ~ y) => applyOperation(new Division, x, y)
          }
        }
        def factor: Parser[Double] = floatingPointNumber ^^ (_.toDouble) | "(" ~> expr <~ ")"

      }

      val result = parser.parseAll(parser.expr, expression)
      result match {
        case parser.Success(res, _) => res
        case _ => 0.0
      }
    }

    private def applyOperation(operation: Operation, operand1: Double, operand2: Double): Double = {
      operation.execute(operand1, operand2)
    }
  }

