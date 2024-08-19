package ch.makery.address.model

class CalculatorModel {
    private var currentInput = ""
    private var result = ""

    def appendInput(input: String): Unit = {
      currentInput += input
    }

    def clear(): Unit = {
      currentInput = ""
      result = ""
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
      if (result.isEmpty) currentInput else result
    }

    private def eval(expression: String): Double = {
      // Basic expression evaluation using Scala's built-in expression parsing
      import scala.util.parsing.combinator.JavaTokenParsers

      object SimpleCalculator extends JavaTokenParsers {
        def expr: Parser[Double] = term ~ rep(("+" | "-") ~ term) ^^ {
          case t ~ list => list.foldLeft(t) {
            case (x, "+" ~ y) => x + y
            case (x, "-" ~ y) => x - y
          }
        }
        def term: Parser[Double] = factor ~ rep(("*" | "/") ~ factor) ^^ {
          case f ~ list => list.foldLeft(f) {
            case (x, "*" ~ y) => x * y
            case (x, "/" ~ y) => x / y
          }
        }
        def factor: Parser[Double] = floatingPointNumber ^^ (_.toDouble) | "(" ~> expr <~ ")"
        def parseAll[T](p: Parser[T], input: String): ParseResult[T] = parseAll(p, input)
      }

      SimpleCalculator.parseAll(SimpleCalculator.expr, expression) match {
        case SimpleCalculator.Success(result, _) => result
        case _ => throw new IllegalArgumentException("Invalid expression")
      }
    }
  }

