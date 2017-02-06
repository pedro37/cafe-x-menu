package uk.gov.hmrc.cafex

import uk.gov.hmrc.cafex.items.{Item, Cola, Sandwich, Coffee}

/**
  * Created by peterwhitehead on 06/02/2017.
  */
object Menu {
  val menuItems = List(Coffee("Coffee", BigDecimal(1.00), "Hot"),
                      Cola("Cola", BigDecimal(0.50), "Cold"),
                      Sandwich("Cheese Sandwich", BigDecimal(2.00), "Cold"),
                      Sandwich("Steak Sandwich", BigDecimal(4.50), "Hot"))

  def getTotal(menuItemsSold: List[Item]): BigDecimal = {
    menuItemsSold.map(menuItem => menuItem.price).sum
  }
}
