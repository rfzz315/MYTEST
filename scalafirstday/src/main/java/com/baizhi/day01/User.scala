package com.baizhi.day01

import com.baizhi.test2
import com.baizhi.test2.User

class User(var id:Int,var name:String) {
    var salary:Double = _
    def this(id:Int,name: String,salary: Double){
      this(id,name)
      this.salary=salary
    }

  override def toString =s"User($salary,$id,$name,标记)"
}
object User{
  def apply(id:Int,name:String):User=new User(id,name)
  def apply(id:Int,name:String,salary:Double):User={
    val user =new User(id,name)
    user.salary=salary
    user
  }

  def unapply(arg: User): Option[(Int, String,Double)] ={
    Some(arg.id,arg.name,arg.salary)
  }
}
