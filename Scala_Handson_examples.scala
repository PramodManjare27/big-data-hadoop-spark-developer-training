Recap - 
import scala.collection.mutable.ListBuffer

import scala.collection.mutable.ArrayBuffer
val a = new ArrayBuffer[Int](5)
print(a)
a+=1
a++=List(1,2,3,4)

val b = ListBuffer[Int]()
b+=3
b++=List(1,2,3,4)
val a = Set( 1,2,3,4).union(Set(1,2,3))
println(a)
List( 1 ,2,3.0 , "Hello")
//map

val z = Map ( 1 -> "one", 2 -> "two")
z.+(3 -> "three")
z.getOrElse(3, "not found")
z.get(3)


//set 
Set(1,2,3,4).&(Set(1,2))
val a = Set(1,5,3,4,5)
a.foreach(println)
a(2)
a.+(3)




object testing extends App {

  val aCondtion = true
  val a = if (aCondtion ) 43 else 55
  print (a)
  
  val ab = {
   if (aCondtion) print(54) else print(95)
  }
}

//misc

import scala.collection.mutable.ListBuffer
val a = List( 1,2,3,4)
val b = List ( 3,4,5,6)

val c = Array (1,2,3)

val d = ListBuffer[Int]()
d+=5
d(0) = 1000
a.toSet.&(b.toSet)

val tup = (1, "a", 1.24)
tup._1

val Map1 = Map(1 -> 2  , 2->4)
Map1.getOrElse(1, "else")

val q = Set(1,2,3,4)


import scala.collection.mutable.Set
 val p = Set(1,2,3,4)
p+=(10)
p(1)

// Streams


val x = 1#::2#::3#::Stream.Empty
x.foreach(println)
x.head
x(1)
x.intersect( Stream(1,2,3)).toSet


def fun( x : Int) = x + 1
println(fun(4))


// polymorphism nad inheritance
class animal
class dog extends animal
val aDog = new dog
val bDog:animal = new dog;

// traits 
trait carniver {
  def eats (a :animal): Unit 
}

class crocodile extends animal with carniver
{
override def eats ( a : animal) ={ println("eats animal")}
}

val croc = new crocodile
//croc.eats(aDog)
croc eats aDog 

//anonymos classes
val aCarniver = new carniver {
  override def eats ( a: animal) = {println("override on instantiation")}
}

//case classes and companion objects

abstract class abs [A]
object abs 

//case classes
case class person ( name : String , age : Int )


val a = new person ("Pramod", 30)
val b = new person ("Pramod", 30)
val c = new person ("Prasad", 32)

if ( a == b ) println( "matches")
if ( b == c ) println ( " matches ") else println(" No match")


try {
  throw new RuntimeException // nothing
}
catch {
  case e : Exception => println ("Got an exception")
}
finally {
println("rest of the block")
  
}


functions are instances of classes with override apply method


val a = new Function1[Int , Int] {
  override def apply(x: Int) : Int = x + 1
}

a(1)

val b = (x:Int) => x + 1
b(1)

def b1(x : Int) = x + 1
b1(1)

List(1,2,3,4).map(b)
List(1,2,3,4).map(b1)



for { i <- List(1,2,3); j <- List("a", "b") } yield 
     ( (i + "- " + j))     

	 
val aMap =   Map ( "one" -> 1 , "two"-> 2 , "two" -> 5 )
aMap.contains("two")
aMap("two")

val s = Option(Some(2) , None)
val b = Some(3)


List.range(1,11).foreach ( x => x match {
  case 1 => println ("first")
  case 2 => println ("second")
  case _ => println ("rest of the numbers " + x)
})



case class Person(name : String)
case class anotherPerson(Age : Int)
val aPerson = new Person("Pramod")
val anotherPer = new anotherPerson(35)

 aPerson match {

  case Person(a:String) => println("Obect of person class") 
  case _ => println("Error class")
}


------------------------

#1 syntax sugar  - we can use curly braces to call single argument method and pass logic 

object obj extends App {
  def somedef (x : Int) : String = { s"$x ducks"}
  val b = somedef {
    println("testing syntax sugar") // custom logic
  10
  }
  println(b)
  }
  
#2 Single method abtraction 

trait sometrait{
def amethod (x : Int ) : String
}

val a = new sometrait{
override def amethod (x: Int ): String = "testing" }


val b : sometrait =  (x: Int )  => {"testing 2"}



# 3 :: operator and #: - right association

List(1,2,3,4)::2
1::List(1,2,3,4)

class someclass[T] {
def ->:: (value : T) : someclass[T] = this
}

val a = "string" ->:: new someclass[String]

print(a)


#4 method names can be multiple words

class girl (name: String){
def `said` (Message : String) = {println (s"$name said $Message")}
}
val neha = new girl ("neha")
neha `said` "how are you?

# Infix types in classes

class GenericClass[T,A]
val instance1 = new  GenericClass[Int, String]
val instance2 : String GenericClass Int


#6 update method -

val array1 = Array(1,2,3,4)
array1(1) = 5 
array1.update(1,5) // returns unit

#7 encapsulation and getter setters
class a {
private var a = 10
def methoda = { a }
def methoda_=(x : Int):Unit = { a = x}
}

var f = new a

f.methoda 
f.methoda = 15 // actually calls f.methoda_=(15)


----------------------------------------------
comparing without case class using unapply methods

 class Testing ( val Age : Int , val Name : String)

val a = new Testing (25, "testing1")
val b = new Testing (25, "testing1")

object Testing {
  def unapply ( testing : Testing) : Option[(Int, String)] = { Some(testing.Age , testing.Name) }
  
}

val c = a match {
  case Testing(a: Int,b: String) => println (s"Object of testing class $a and $b" )
  case _ => println ("Nothing matches")
}


--------------
optimized tailrec recursion - 
import scala.annotation.tailrec  
@tailrec def factorial (x : Int, Accum : Int = 1):Int= {
  if (x <= 1) Accum 
  else factorial( x - 1 , x * Accum)
}

println(factorial (3, 1))


def  fact ( x : Int): Int = {
  if (x <= 0) 1
  else x * fact(x -1)
}

fact (10)

------------------
// Inner functions 
   def filter1(x : List[Int], Threshold : Int): List[Int] = {
     def innerfltr (y : List[Int]):List[Int] ={
       if (y.isEmpty) y
       else if (y.head < Threshold) y.head :: innerfltr(y.tail)
       else innerfltr(y.tail)
     }
     innerfltr(x)
   }
  filter1(List(1,2,3,4,5,5,6,7,8,9), 4)


------------------
// List operations imperative apporach vs functional approch  
def func1 ( L : List[Int] ) : Int = {
  if (L == Nil)  0 else L.head + func1(L.tail)
}
func1(List(1,2,3))

List(1,2,3).sum

//Higher Order function - 

def cubeSum (x: Int ) : Int = {
  x*x*x
}

def sqrSum (x: Int ) : Int = {
  x*x
}

def genericSum ( funct : Int => Int , x : Int ) : Int ={
  if (x <= 0 ) 0
  else funct(x) + genericSum( funct, x-1)
} 

genericSum( cubeSum , 2)
genericSum(sqrSum , 2)

// Patterns - 


List.range(1 , 10).filter(x=> x < 9).foreach(x=> println("*" * x))
List.range(1 , 10).reverse.foreach(x=> println("*" * x))

//"*" * 19
