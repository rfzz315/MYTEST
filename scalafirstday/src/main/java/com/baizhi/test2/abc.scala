package com.baizhi.test2

case class CaseUser(name:String)
class User(name:String){}
object User {
  def apply(name: String): User = new User(name)
}



