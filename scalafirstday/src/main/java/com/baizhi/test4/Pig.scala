package com.baizhi.test4

class Pig(var name:String) {
  def sleep():Unit={
    println(s"${name} 哼哼睡~")
  }
  def eat():Unit={
    println(s"${name} 给啥吃啥~")
  }
}
object Pig{
  def apply(name: String): Pig = new Pig(name)
}
