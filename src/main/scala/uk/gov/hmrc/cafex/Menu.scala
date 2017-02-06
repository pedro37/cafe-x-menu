package uk.gov.hmrc.cafex

import uk.gov.hmrc.cafex.items.{Item, Cola, Sandwich, Coffee}

/**
  * Created by peterwhitehead on 06/02/2017.
  */
case class Menu(menuItemsSold: List[Item] = List.empty) {
  def getTotal(): BigDecimal = {
    menuItemsSold.map(menuItem => menuItem.price).sum
  }
}
