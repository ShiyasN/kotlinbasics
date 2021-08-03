import org.junit.jupiter.api.Test

class DemoTest {

    @Test
    fun basics(): Int {
        var a: Int = 5
        a = 10
        println(a)
        return a

    }

    @Test
    fun ifElse() {
        val num1 = 10
        val num2 = 20
        val result = if (num1 > num2) {
            "$num1 is greater than $num2"
        } else {
            "$num1 is smaller than $num2"
        }
        println(result)

    }

    @Test
    fun ifElse1() {
        val marks = 64
        val (grade: String, result: String) =
            if (marks > 70) {
                Pair("B", "Pass")
            } else if (marks > 60) {
                Pair("C", "Red")
            } else {
                Pair("E", "Fail")
            }
        println(grade)
        println(result)
    }

    @Test
    fun namedArg() {
        argument(param2 = 'a')
    }

    fun argument(param1: Int = 10, param2: Char = 'c') {
        println(param1)
        println(param2)
    }

    @Test
    fun whenStatement() {
        var num = 5;
        var result = when (num) {
            1 -> "One"
            2, 3, 4 -> "Two, Three, Four"
            5 -> "Five"
            in 6..8 -> "Range"
            else -> "Others"
        }
        println("Result - $result");
    }

    @Test
    fun when1() {
        val marks = 64
        val (grade: String, result: String) =
            when {
                marks > 70 -> {
                    Pair("B", "Pass")
                }
                marks > 60 -> {
                    Pair("C", "Red")
                }
                else -> {
                    Pair("E", "Fail")
                }
            }
        println(grade)
        println(result)
    }

    @Test
    fun forLoop() {
        val arr = arrayOf(1, 2, 3, 4, 5);
        var g = 1..5
        for (item in arr) {
            println(item);
        }

        val arr1 = Array(5, { i -> i * 2 });
        var arr2 = Array(5) { 3 }
        for (item in g) {
            println(item);
        }

        for (item in arr2.indices) {
            println(arr2[item]);
        }
    }

    @Test
    fun lambdaExpression() {
        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
        val sum1 = { x: Int, y: Int -> x + y }

        val myLambda: (Int) -> Unit = { s: Int -> println(s) } //lambda function
        addNumber(5, 10, myLambda)

    }

    fun addNumber(a: Int, b: Int, mylambda: (Int) -> Unit) {   //high level function lambda as parameter
        val add = a + b
        mylambda(add) // println(add)
    }

    @Test
    fun higherOrderFunction() {
        val fn = { num1: Int, num2: Int ->
            (
                    if (num1 > num2) {
                        "$num1 is greater than $num2"
                    } else {
                        "$num1 is greater than $num2"
                    }
                    )
        }
        greatest(10, 5, fn)
    }

    fun greatest(num1: Int, num2: Int, fn: (Int, Int) -> String) {
        val sum = fn(num1, num2);
        println(sum);
    }

    @Test
    fun check() {
        var str1: String = "str1";
        var str2: String = "str1";
        var str3: String = buildString { "str1" }
        println(str1 == str2);
        println(str1 === str2);
        println(str1 == str3);
        println(str1 === str3);
        println(str1.indices);
    }

    @Test
    fun tryCatch() {
        try {
            val a = IntArray(5)
            // a[5] = 10 / 0
        } catch (e: Exception) {
            println("parent exception catch")
        } catch (e: ArithmeticException) {
            println("arithmetic exception catch")
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("array index outofbounds exception")
        }

        println("code after try catch...")
    }

    @Test
    fun tryCatch1() {
        try {
            val a = IntArray(5)
            //    a[5] = 10 / 0
        } catch (e: ArithmeticException) {
            println("arithmetic exception catch")
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("array index outofbounds exception")
        } catch (e: Exception) {
            println("parent exception class")
        } finally {
            println("finally block")
        }
        println("code after try catch...")
    }

    @Test
    fun throwKeyword() {
        if (true) {
            throw ArithmeticException("Some mesagae")
        }
    }

    @Test
    fun smartCast() {
        var string: String? = "Hello!"
        if (string != null) {
            print(string.length)
        }
    }

    @Test
    fun elvisOperator() {
        var str: String? = "kkk"
        var str2: String? = "May be declare nullable string"

        var len1: Int = str?.length ?: -1
        var len2: Int = str2?.length ?: -1

        println("Length of str is ${len1}")
        println("Length of str2 is ${len2}")
    }

    @Test
    fun immutableCollections() {
        var list = listOf<String>("a", "b", "c", "a")
        var set = setOf("a", "b", "c", "a")
        var map = mapOf<Int, String>(1 to "a", 2 to "b", 3 to "c")


    }

    @Test
    fun mutableList() {
        var mutableList1 = mutableListOf("Ajay", "Vijay")
        mutableList1.add("Prakash")
        mutableList1.add("Vijay")

        var mutableList2 = mutableListOf<String>()
        mutableList2.add("Ajeet")
        mutableList2.add("Amit")
        mutableList2.add("Akash")

        for (element in mutableList1) {
            println(element)
        }
        println()
        for (element in mutableList2) {
            println(element)
        }

    }

    @Test
    fun arrayList() {
        val arrayList: ArrayList<String> = ArrayList<String>(5)
        var list: MutableList<String> = mutableListOf<String>()

        list.add("Ajay")
        list.add("Vijay")
        list.add("Prakash")

        arrayList.addAll(list)
        println("......print ArrayList......")
        val itr = arrayList.iterator()
        while (itr.hasNext()) {
            println(itr.next())
        }
        println("size of arrayList = " + arrayList.size)
    }

    @Test
    fun map() {
        val myMap = mapOf<Int, String>(1 to "Ajay", 4 to "Vijay", 3 to "Prakash")
        //Generic Way
        val myMap1: MutableMap<Int, String> = mutableMapOf<Int, String>(1 to "Ajay", 4 to "Vijay", 3 to "Prakash")
        for (key in myMap.keys) {
            println(myMap[key])
        }

    }

    @Test
    fun mapIterable() {
        val map = mapOf<Int, String>(1 to "A", 2 to "B", 3 to "C")


        for (itr in map.asIterable()) {
            println("${itr.key} ---- ${itr.value}")
        }
        for (m in map.minus(3)) {
            println(map[m.key])
        }
        for (p in map.plus(Pair(5, "Rohan"))) {
            println("Element at key ${p.key} = ${p.value}")
        }
    }

    @Test
    fun hashMap() {
        val hashMap: HashMap<Int, String> = HashMap<Int, String>() //define empty hashmap
        hashMap.put(1, "Ajay")
        hashMap.put(3, "Vijay")
        hashMap.put(4, "Praveen")
        hashMap.put(2, "Ajay")
        println(".....traversing hashmap.......")
        for (key in hashMap.keys) {
            println("Element at key $key = ${hashMap[key]}")
        }
    }

    @Test
    fun classExaample() {
        class Account {
            var acc_no: Int = 0
            var name: String = ""
            var amount: Float = 0.toFloat()
            fun insert(ac: Int, n: String, am: Float) {
                acc_no = ac
                name = n
                amount = am
                println("Account no: ${acc_no} holder :${name} amount :${amount}")
            }

            fun deposit() {
                //deposite code
            }

            fun withdraw() {
                // withdraw code
            }

            fun checkBalance() {
                //balance check code
            }

        }

        var acc = Account()
        acc.insert(832345, "Ankit", 1000f) //accessing member function
        println("${acc.name}") //accessing class property

    }

    @Test
    fun classExample() {
        class myClass(val name: String, var id: Int) {

        }

        val myclass = myClass("Ashu", 101)

        println("Name = ${myclass.name}")
        println("Id = ${myclass.id}")

    }

    @Test
    fun classExample1() {
        class myClass(name: String, id: Int) {
            val e_name: String
            var e_id: Int

            init {
                e_name = name.capitalize()
                e_id = id

                println("Name = ${e_name}")
                println("Id = ${e_id}")
            }
        }

        val myclass = myClass("Ashu", 101)

    }

    @Test
    fun classExample2() {
        class myClass {

            constructor(name: String, id: Int) {
                println("Name = ${name}")
                println("Id = ${id}")
            }
        }

        val myclass = myClass("Ashu", 101)
    }

    @Test
    fun classExample3() {
        class myClass(var password: String) {
            var name: String = ""
            var id: Int = 0
//            var password: String = ""

            init {
                println("password" + password)
                // this.password = password
            }

            constructor(name: String, id: Int, password: String) : this(password) {
                this.name = name
                this.id = id
                println("Name = ${name}")
                println("Id = ${id}")
                println("Password = ${password}")
            }

            fun insert() {
                println("Name = ${name}")
                println("Id = ${id}")
                println("Password = ${password}")
            }
        }

        val myclass = myClass("Ashu", 101, "mypassword")
//        val myclass1 = myClass ("mypassword")\
        myclass.insert()

    }

    @Test
    fun classExample4() {
        class myClass {

            constructor(name: String, id: Int) : this(name, id, "mypassword") {
                println("this executes next")
                println("Name = ${name}")
                println("Id = ${id}")
            }

            constructor(name: String, id: Int, pass: String) {
                println("this executes first")
                println("Name = ${name}")
                println("Id = ${id}")
                println("Password = ${pass}")
            }
        }

        val myclass = myClass("Ashu", 101)

    }

    @Test
    fun inheritance() {

        open class Base(p: Int) {

        }

        class Derived(p: Int) : Base(p) {

        }

        open class Employee(name: String, age: Int, salary: Float) {
            // code of employee
        }

        class Programmer(name: String, age: Int, salary: Float) : Employee(name, age, salary) {
            // code of programmer
        }

        class Salesman(name: String, age: Int, salary: Float) : Employee(name, age, salary) {
            // code of salesman
        }


        open class Bird(var name: String) {
            fun fly() {
                println("flying..." + name)
            }
        }

        class Duck(name: String) : Bird(name) {
            fun swim() {
                println("swimming...")
            }
        }

        val duck = Duck("duck")
        duck.fly()
        duck.swim()

    }

    @Test
    fun dataClass() {
        data class myClass(val name: String, val const: String = "Constant Value")

        var obj = myClass("Shiyas")
        var obj1 = myClass("Shiyas")
        println("obj " + obj)
        println("Name " + obj.name)
        println("Equals " + obj1.equals(obj))

    }

    @Test
    fun extensionFunction() {
        class Student {
            fun isPassed(mark: Int): Boolean {
                return mark > 40
            }
        }

        fun Student.isExcellent(mark: Int): Boolean {
            return mark > 90
        }

        val student = Student()
        val passingStatus = student.isPassed(55)
        println("student passing status is $passingStatus")

        val excellentStatus = student.isExcellent(95)
        println("student excellent status is $excellentStatus")

    }

    @Test
    fun extensionFunction1() {
        fun MutableList<Int>.swap(index1: Int, index2: Int): MutableList<Int> {
            val tmp = this[index1] // 'this' represents to the list
            this[index1] = this[index2]
            this[index2] = tmp
            return this
        }

        val list = mutableListOf(5, 10, 15)
        println("before swapping the list :$list")
        val result = list.swap(0, 2)
        println("after swapping the list :$result")
    }

    @Test
    fun generic() {
        class Person<T>(age: T) {
            var age: T = age

            init {
                this.age = age
                println(age)
            }
        }

        var ageInt: Person<Int> = Person<Int>(30)
        var ageString: Person<String> = Person<String>("40")

    }

    @Test
    fun genericFunction() {
        val stringList: ArrayList<String> = arrayListOf<String>("Ashu", "Ajay")
        val s: String = stringList[0]
        println("printing the string value of stringList: $s")
        printValue(stringList)
        val floatList: ArrayList<Float> = arrayListOf<Float>(10.5f, 5.0f, 25.5f)
        printValue(floatList)

    }

    fun <T> printValue(list: ArrayList<T>) {
        for (element in list) {
            println(element)
        }
    }


    @Test
    fun regex() {
        val regex = Regex(pattern = "ko")
        val matched = regex.containsMatchIn(input = "kotlin")
        println(matched)
    }

    @Test
    fun regex1() {
        val regex = """a([bc]+)d?""".toRegex()
        val matched = regex.containsMatchIn(input = "xabcdy")
        println(matched)
    }

    @Test
    fun regex2() {
        //The matches(input: CharSequence): Booleanfunction of regex checksall input character sequence matches in regular expression.
        val regex = """a([bc]+)d?""".toRegex()
        val matched1 = regex.matches(input = "xabcdy")
        val matched2 = regex.matches(input = "xabcdyabcd")
        val matched3 = regex.matches(input = "abcd")
        println(matched1)
        println(matched2)
        println(matched3)
    }

    @Test
    fun regex3() {
        //The matchEntire() function is used to match complete input character from the pattern.
        val regex = Regex("abcd")
        val matchResult1 = regex.matchEntire("abcd")?.value
        val matchResult2 = regex.matchEntire("abcda")?.value

        val matchResult3 = Regex("""\d+""").matchEntire("100")?.value
        val matchResult4 = Regex("""\d+""").matchEntire("100 dollars")?.value

        println(matchResult1)
        println(matchResult2)
        println(matchResult3)
        println(matchResult4)
    }

    @Test
    fun regex4() {
        //The find function is used to find the input character sequence from regex object.
        val emailParttern = Regex("""\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,6}""")
        val email: String? = emailParttern.find("this is my email mymail@google.com")?.value
        println(email)
        val phoneNumber: String? = Regex(pattern = """\d{3}-\d{3}-\d{4}""")
            .find("phone: 123-456-7890, e..")?.value
        println(phoneNumber)
    }
}