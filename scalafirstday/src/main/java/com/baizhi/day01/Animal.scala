package com.baizhi.day01

abstract class Animal(name:String) {
    def sleep() : Unit={
      println(s"${name}    shuile")

    }
  def eat():Unit
}
