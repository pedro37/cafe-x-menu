package uk.gov.hmrc.cafex

import org.specs2.mutable.Specification
import uk.gov.hmrc.cafex.items.Item

/**
  * Created by peterwhitehead on 06/02/2017.
  */
class MenuSpec extends Specification {
  "when adding items to menu must calculate correct bill" should {
    "bill must be 0 when empty" in {
      Menu.getTotal(List[Item]()) mustEqual 0
    }

    "bill must be 3.5 when Cola, Coffee and Cheese Sandwich" in {
      Menu.getTotal(Menu.menuItems.filter(item => item.name == "Cheese Sandwich" || item.name == "Cola" || item.name == "Coffee"))  mustEqual 3.50
    }
  }
}
