package com.github.pawelhenek.scalaplayground.scalatest.myunits

import org.scalatest.{FlatSpec, Inside, Inspectors, Matchers, OptionValues}

abstract class UnitSpec extends FlatSpec
  with Matchers
  with OptionValues
  with Inside
  with Inspectors
