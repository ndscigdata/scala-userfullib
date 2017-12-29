import scala.pickling._
import scala.pickling.Defaults._
import scala.pickling.json._
import scala.pickling.static._  // Avoid runtime pickler
import json._

case class Person(name: String, age: Int)
case class C(arr: Array[Int]) { override def toString = s"""C(${arr.mkString("[", ",", "]")})""" }

object PickleSample{
  
  def main(args:Array[String]):Unit = {  
     println("封装测试...")
     val originperson = Person("foo", 20)
//     val pkl = Pickler.generate[Person](originperson)
     val pkl = originperson.pickle
//     val pckl = List(1, 2, 3, 4).pickle
     println(pkl.value)
         
     println("还原测试...")
     val person = pkl.unpickle[Person]
     
     println(person.name)
     println(person.age)
  }
}