package com.baizhi.test3
import com.baizhi.test3.Animail
import com.baizhi.test3.Flyable

class Bird(name:String) extends Animail(name:String) with Flyable {
  override def sleep(): Unit = {
    println(s"${name} 正在睡觉")
  }

  override def fly(): Unit = {
    println(s"${name} 没长大，还不会飞")
  }
}
