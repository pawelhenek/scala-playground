package com.github.pawelhenek.scalaplayground

import org.scalatest.{DiagrammedAssertions, FunSuite}

class HelloSpec extends FunSuite with DiagrammedAssertions {

  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }
}
