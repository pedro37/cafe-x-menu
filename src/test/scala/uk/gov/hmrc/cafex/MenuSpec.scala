package uk.gov.hmrc.cafex

import org.specs2.mutable.Specification
import uk.gov.hmrc.cafex.charges.ServiceCharge
import uk.gov.hmrc.cafex.items.Item

import scala.collection.mutable

/**
  * Created by peterwhitehead on 06/02/2017.
  */
class MenuSpec extends Specification {
  "when adding items to menu must calculate correct bill" should {
    "bill must be 0 when empty" in {
      ServiceCharge(Menu()).getTotal mustEqual 0
    }

    "bill must be 3.85 when Cola, Coffee and Cheese Sandwich 2.00+1.00+0.50=3.50 10% = 0.35 = 3.85" in {
      ServiceCharge(Menu(List(MenuItems.cheeseSandwich, MenuItems.cola, MenuItems.coffee))).getTotal  mustEqual 3.85
    }

    "service charge should not be applied when all drinks 1.00+0.50=1.50" in {
      ServiceCharge(Menu(List(MenuItems.cola, MenuItems.coffee))).getTotal  mustEqual 1.50
    }

    "service charge should be 10% when food purchased 2.00 + 10% = 0.2 = 2.20" in {
      ServiceCharge(Menu(List(MenuItems.cheeseSandwich))).getTotal mustEqual 2.20
    }

    "service charge should be 20% when hot food added to maximum £20 - 23*4.50=103.5 20%=20.7 total=123.5" in {
      var menuItemsSold = mutable.ListBuffer[Item]()
      for (i <- 0 until 23){
        menuItemsSold += MenuItems.steakSandwich
      }
      ServiceCharge(Menu(menuItemsSold.toList)).getTotal mustEqual 123.50
    }

    "service charge should be 20% when hot food added to maximum £20 - 23*4.50=103.5+2.00+4.5+1.00+0.5=111.5 Cold food 10%=11.15 total=122.65" in {
      var menuItemsSold = mutable.ListBuffer[Item]()
      for (i <- 0 until 23){
        menuItemsSold += MenuItems.steakSandwich
      }
      menuItemsSold.++= (List(MenuItems.cheeseSandwich, MenuItems.cola, MenuItems.coffee, MenuItems.steakSandwich))
      ServiceCharge(Menu(menuItemsSold.toList)).getTotal mustEqual 122.65
    }
  }
}
