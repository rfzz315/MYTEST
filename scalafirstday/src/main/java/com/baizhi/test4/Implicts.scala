package com.baizhi.test4
import java.util.Date
import java.text.SimpleDateFormat
object Implicts {
implicit def str2Date(s: String):Date={
  val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  sdf.parse(s)
}
  implicit class PigImplicts(pig:Pig){
    def fly():Unit={
      println(s"${pig.name} 会飞~")
    }
    def swimming():Unit={
      println(s"${pig.name} 会游泳~")
    }
  }

}
