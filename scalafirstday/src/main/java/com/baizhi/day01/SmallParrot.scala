package com.baizhi.day01

class SmallParrot(name:String )extends Animal(name:String) with Flyable {
  def eat(): Unit = {
    println(s"${name} 嗑瓜子！")
  }

  override def fly(): Unit = {
    println(s"${name} 没长大，还不会飞")
  }
}
