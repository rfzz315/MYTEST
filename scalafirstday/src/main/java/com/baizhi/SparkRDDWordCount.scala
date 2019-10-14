import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkRDDWordCount {
  def main(args: Array[String]): Unit = {
    //1.创建SparkContext
    val sparkConf = new SparkConf()
      .setMaster("spark://spark:7077")
      .setAppName("wordcount")
    val sc=new SparkContext(sparkConf)
    //2.创建并行集合 数据集 抽象成 Spark 并行集合 RDD （理解Scala集合升级版）
    val linesRDD:RDD[String] = sc.textFile("hdfs:///demo/words/t_words.txt")

    linesRDD.flatMap(line=>line.split(" "))
      .map((_,1))
      .groupBy(item=>item._1)
      .map(item=>(item._1,item._2.map(item=>item._2).reduce(_+_)))
      .sortBy(t=>t._2,false,1)
      .saveAsTextFile("hdfs:///demo/results01")

    //4.关闭SparkContext
    sc.stop();
  }
}
