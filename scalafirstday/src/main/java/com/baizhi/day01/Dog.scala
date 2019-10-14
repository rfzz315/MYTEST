package com.baizhi.day01

class Dog(name:String) extends Animal(name:String) {

  override def eat(): Unit = {
    println(s"${name} 啃骨头")
  }
}
