package com.baizhi.test2

object test2 {
  def main(args: Array[String]): Unit = {
    var u1=User
    var u2=User

    var u3=new User("张三")
    var u4=new User("张三")

    var u5=User("zs")
    var u6=User("zs")

    var u7=CaseUser("张三")
    var u8=CaseUser("张三")

    var u9=CaseUser("张三")
    var u10=CaseUser("张三")

    println(u1==u2)
    println(u3==u4)
    println(u5==u6)
    println(u7==u8)
    println(u9==u10)

  }

}
