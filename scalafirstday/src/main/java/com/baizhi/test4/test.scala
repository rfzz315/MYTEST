package com.baizhi.test4
import java.util.Date
import com.baizhi.test4.Implicts._
object test {
  def main(args: Array[String]): Unit = {


    sayTime(new Date())
    sayTime("2019-8-11 11:52:35")
  }


  def sayTime(time: Date): Unit = {
    println(time.toLocaleString())
  }


  var pig=Pig("猪坚强")
  pig.eat()
  pig.sleep()
  //隐式增强
  pig.fly()
  pig.swimming()

}
