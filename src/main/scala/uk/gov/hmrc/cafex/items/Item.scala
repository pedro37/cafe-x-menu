package uk.gov.hmrc.cafex.items

/**
  * Created by peterwhitehead on 06/02/2017.
  */
trait Item {
  val price: BigDecimal
  val name: String
  val temp: String
}
