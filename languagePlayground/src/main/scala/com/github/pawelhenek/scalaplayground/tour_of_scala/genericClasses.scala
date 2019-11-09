package com.github.pawelhenek.scalaplayground.tour_of_scala

object genericClasses extends App {

  class Stack[A] {
    private var elements: List[A] = Nil

    def push(x: A): Unit = {
      elements = x :: elements
    }

    def peek: A = elements.head

    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }

    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop)
    println(stack.pop)

    class Fruit
    class Apple extends Fruit
    class Banana extends Fruit

    val anotherStack = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana

    anotherStack.push(apple)
    anotherStack.push(banana)

  }

}
