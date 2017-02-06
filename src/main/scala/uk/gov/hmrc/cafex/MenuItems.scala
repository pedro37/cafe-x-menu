package uk.gov.hmrc.cafex

import uk.gov.hmrc.cafex.items.{Cola, Coffee, Sandwich}

/**
  * Created by peterwhitehead on 06/02/2017.
  */
object MenuItems {
  val coffee = Coffee("Coffee", BigDecimal(1.00), "Hot")
  val cola = Cola("Cola", BigDecimal(0.50), "Cold")
  val cheeseSandwich = Sandwich("Cheese Sandwich", BigDecimal(2.00), "Cold")
  val steakSandwich = Sandwich("Steak Sandwich", BigDecimal(4.50), "Hot")
}
