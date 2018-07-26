package org.tanuneko.undou.utils

import java.time.Instant

import org.scalatest.GivenWhenThen
import org.scalatestplus.play.PlaySpec

class TimeUtilSpec extends PlaySpec with GivenWhenThen {

  "TimeUtil" should {

    "Specified Time is after" in {

      Given("Instant as before 10 pm")
      val before10pm = Instant.parse("2018-05-10T21:59:59.00Z")

      When("TimeUtil::isAfter used")
      val rez = TimeUtil.isAfter(22, before10pm)

      Then("Should be false")
      rez === false
    }

    "Specified Time is not after" in {

      Given("Instant as after 10 pm")
      val before10pm = Instant.parse("2018-05-10T22:01:00.00Z")

      When("TimeUtil::isAfter used")
      val rez = TimeUtil.isAfter(22, before10pm)

      Then("Should be true")
      rez === true
    }
  }

}
