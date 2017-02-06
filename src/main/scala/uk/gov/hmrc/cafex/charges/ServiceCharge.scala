package uk.gov.hmrc.cafex.charges

import uk.gov.hmrc.cafex.{MenuItems, Menu}

/**
  * Created by peterwhitehead on 06/02/2017.
  */
case class ServiceCharge(menu: Menu) {

  private def getServiceCharge(total: BigDecimal): BigDecimal = {
    menu.menuItemsSold.contains(MenuItems.cheeseSandwich) match {
      case true => total * 0.1
      case _ => {
        menu.menuItemsSold.contains(MenuItems.steakSandwich) match {
          case true => total * 0.2
          case _ => 0.0
        }
      }
    }
  }

  def getTotal(): BigDecimal = {
    val total = menu.getTotal;
    val serviceCharge = getServiceCharge(total) match {
      case charge if (charge > 20) => BigDecimal(20)
      case charge => charge
    }
    serviceCharge + total
  }
}
