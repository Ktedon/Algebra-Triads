package geometry

import slinky.core._
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import scala.util.Try

@JSImport("resources/bootstrap.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("resources/logo.svg", JSImport.Default)
@js.native
object ReactLogo extends js.Object

@react class App extends Component {
  type Props = Unit
  case class State(mPG: Int, milesPerYear: Int, maintenancePerYear: Int, milesDriven: Int, ownershipLength: Int, car: String)

  val models: scala.collection.mutable.UnrolledBuffer[String] =
    scala.collection.mutable.UnrolledBuffer(
      "Honda Civic",
      "Honda CRV",
      "Toyota RAV4",
      "Chevy Traverse"
    )

  def initialState = State(0, 0, 0, 0, 0, "Honda Civic")

  private val css = AppCSS

  def getCarCosts(isCost: Boolean, carName: String): (Int, Int) = {
    carName match {
      case "Honda Civic" =>
        isCost match {
          case false => (2508, 2799)
          case true => (0, 21700)
        }
      case "Honda CRV" =>
        isCost match {
          case false => (2988, 2999)
          case true => (0, 25750)
        }
      case "Toyota RAV4" =>
        isCost match {
          case false => (2988, 2999)
          case true => (0, 26350)
        }
      case "Chevy Traverse" =>
        isCost match {
          case false => (3948, 4169)
          case true => (0, 33700)
        }
    }
  }

  def render() = {
    div(className := "App", style := js.Dynamic.literal(padding = "100px"))(
      div(className := "card border-primary mb-3", style := js.Dynamic.literal(width = "80%", marginLeft = "10%", marginTop = "50px"))(
        div(className := "card-header")(),
        div(className := "card-body")(
          h4(className := "card-title")("Lease or Buy Calculator"),
          table(className := "table table-hover")(
            thead()(
              tr()(
                th(scope := "col")("Car Type"),
                th(scope := "col")("Cost to Buy"),
                th(scope := "col")("Cost to Lease")
              )
            ),
            tbody()(
              tr(className := "table-primary")(
                th(scope := "row")("Honda Civic"),
                th()("$21,700"),
                th()("$2,508/year & $2,799 down payment")
              ),
              tr(className := "table-success")(
                th(scope := "row")("Honda CRV"),
                th()("$25,750"),
                th()("$3,468/year & $3,199 down payment")
              ),
              tr(className := "table-info")(
                th(scope := "row")("Toyota RAV4"),
                th()("$26,350"),
                th()("$2,988/year & $2,999 down payment")
              ),
              tr(className := "table-warning")(
                th(scope := "row")("Chevy Traverse"),
                th()("$33,700"),
                th()("$3,948/year & $4,169 down payment")
              )
            )
          ),
          div(className := "form-group")(
            h4(className := "form-label mt-4")("Lease or Buy"),
            select(className := "form-select")(
              option(value := "lease")("Lease"),
              option(value := "buy")("Buy"),
              option(value := "best")("What is cheapest?")
            )
          ),
          div(className := "form-group")(
            h4(className := "form-label mt-4")("Car Model"),
            select(
              className := "form-select",
              onChange := { event =>
                val e = event.target.value
                setState(_.copy(car = e))
              }
            )(
              option(value := "Honda Civic")("Honda Civic"),
              option(value := "Honda CRV")("Honda CRV"),
              option(value := "Toyota RAV4")("Toyota RAV4"),
              option(value := "Chevy Traverse")("Chevy Traverse")
            )
          ),
          div(className := (
            if (state.mPG > 5)
              "form-group has-success"
            else
              "form-group has-danger")
          )(
            h4(className := "form-label mt-4")("Miles Per Gallon"),
            input(
              onChange := { event =>
                val e = event.target.value
                if (e.length == 0 || (e forall Character.isDigit) == false) {
                  setState(_.copy(mPG = 0))
                } else {
                  setState(_.copy(mPG = e.toInt))
                }
              },
              className :=
                (if (state.mPG > 5)
                  "form-control is-valid"
                else
                  "form-control is-invalid"),
              placeholder := "MPG"
            )
          ),
          div(className := (
            if (state.milesPerYear > 500)
              "form-group has-success"
            else
              "form-group has-danger")
          )(
            h4(className := "form-label mt-4")("Miles Driven Per Year"),
            input(
              onChange := { event =>
                val e = event.target.value
                if (e.length == 0 || (e forall Character.isDigit) == false) {
                  setState(_.copy(milesPerYear = 0))
                } else {
                  setState(_.copy(milesPerYear = e.toInt))
                }
              },
              className :=
                (if (state.milesPerYear > 500)
                  "form-control is-valid"
                else
                  "form-control is-invalid"),
              placeholder := "Miles Driven Per Year"
            )
          ),
          div(className := (
            if (state.maintenancePerYear > 50)
              "form-group has-success"
            else
              "form-group has-danger")
          )(
            h4(className := "form-label mt-4")("Maintenance Cost Per Year"),
            input(
              onChange := { event =>
                val e = event.target.value
                if (e.length == 0 || (e forall Character.isDigit) == false) {
                  setState(_.copy(maintenancePerYear = 0))
                } else {
                  setState(_.copy(maintenancePerYear = e.toInt))
                }
              },
              className :=
                (if (state.maintenancePerYear > 50)
                  "form-control is-valid"
                else
                  "form-control is-invalid"),
              placeholder := "Maintenance Cost"
            )
          ),
          div(className := (
            if (state.milesDriven > 50)
              "form-group has-success"
            else
              "form-group has-danger")
          )(
            h4(className := "form-label mt-4")("Total Miles Driven"),
            input(
              onChange := { event =>
                val e = event.target.value
                if (e.length == 0 || (e forall Character.isDigit) == false) {
                  setState(_.copy(milesDriven = 0))
                } else {
                  setState(_.copy(milesDriven = e.toInt))
                }
              },
              className :=
                (if (state.milesDriven > 50)
                  "form-control is-valid"
                else
                  "form-control is-invalid"),
              placeholder := "Miles Driven"
            )
          ),
          div(className := (
            if (state.ownershipLength > 0)
              "form-group has-success"
            else
              "form-group has-danger")
          )(
            h4(className := "form-label mt-4")("Years of Usage"),
            input(
              onChange := { event =>
                val e = event.target.value
                if (e.length == 0 || (e forall Character.isDigit) == false) {
                  setState(_.copy(ownershipLength = 0))
                } else {
                  setState(_.copy(ownershipLength = e.toInt))
                }
              },
              className :=
                (if (state.ownershipLength > 0)
                  "form-control is-valid"
                else
                  "form-control is-invalid"),
              placeholder := "Years of Usage"
            )
          ),
          br(),

          // (
          //   if (
          //     state.mPG > 5 &&
          //     state.milesPerYear > 500 &&
          //     state.maintenancePerYear > 50 &&
          //     state.milesDriven > 50 &&
          //     state.ownershipLength > 0
          //   )
          //     button(`type` := "button", className := "btn btn-outline-success")("Calculate")
          //   else
          //     input(
          //       className := "btn btn-outline-danger",
          //       `type` := "button",
          //       onChange := { event =>
          //
          //       }
          //     )("Form Data Invalid")
          // ),
          div()(
            if (((2.97 * (state.milesPerYear.toDouble / state.mPG.toDouble)) + state.maintenancePerYear.toDouble + (getCarCosts(false, state.car)._1 * state.ownershipLength) + getCarCosts(false, state.car)._2) <
              ((state.milesPerYear.toDouble / state.mPG.toDouble) + (state.maintenancePerYear.toDouble * state.ownershipLength) + getCarCosts(true, state.car)._2)) {
              h1()("IT IS BETTER TO LEASE!")
            } else {
              h1()("IT IS BETTER TO BUY!")
            }
          ),
          br(),
          div("Precise Costs: "),
          br(),
          div()("Cost to Lease: $" + ((2.97 * (state.milesPerYear.toDouble / state.mPG.toDouble)) + state.maintenancePerYear.toDouble + (getCarCosts(false, state.car)._1 * state.ownershipLength) + getCarCosts(false, state.car)._2)),

          br(),
          div()("Cost to Buy: $" + (state.milesPerYear.toDouble / state.mPG.toDouble + state.maintenancePerYear.toDouble * state.ownershipLength + getCarCosts(true, state.car)._2))
        )
      )
    )
  }
}
