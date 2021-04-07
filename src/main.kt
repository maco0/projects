fun main()
{
    println("input first fraction")
    val q = Fraction()
  actions(q)

}


class Fraction
{
    var num :Float = getNum()
    var den : Float = getDen()

  init{

      print("original Fraction: ")
      println("${num}/${den}")
  }

}

fun simplify( a: Fraction):String {
    val gcd = findGCD(a.num,a.den)
    val simplifiednum: Float = a.num/gcd
    val simplifiedden = a.den/gcd
    print("simplified fraction: ")
    return "$simplifiednum/$simplifiedden"
}

//finding the greatest common divisor
private fun findGCD(a: Float, b: Float): Float {

    if(a == 0F) return b

    return findGCD(b % a, a)
}
//sum of two fractions
fun additionOrSubtraction(f: Fraction):String {
    println("working with arithmetic operations ")
   val num1F = getNum()
   val den1F= getDen()
    val basenumer=f.num
    val baseden=f.den
    var finalNum:Float
    var finalden = baseden*den1F
    println("for addition type 1 || for subtraction type 2 ")
    var inputNum = Integer.valueOf(readLine())

    while(inputNum!=1 && inputNum!=2){
        println("invalid input. for addition type 1 || for subtraction type 2 ")
        inputNum = Integer.valueOf(readLine())
        print(inputNum)
    }
    finalNum = if(inputNum==1){
        basenumer*den1F+num1F*baseden
    }
    else{
        basenumer*den1F-num1F*baseden
    }

    //simplifying the fraction
    val gcd = findGCD(finalNum,finalden)
    finalNum/=gcd
    finalden/=gcd
    println("Arithmetic result of Two fractions")
    return "$finalNum/$finalden"

}

fun multOrDivision(f:Fraction):String{
    println("working with multiplying and dividing ")
    val num1F = getNum()
    val den1F= getDen()
    val basenumer=f.num
    val baseden=f.den
    var finalNum:Float
    var finalDen: Float
    println("for multiply type 1 || for Division type 2 ")
    var inputNum = Integer.valueOf(readLine())

    while(inputNum!=1 && inputNum!=2){
        println("invalid input. for multiply type 1 || for Division type 2 ")
        inputNum = Integer.valueOf(readLine())
        print(inputNum)
    }
    if(inputNum==1){
        finalNum =num1F*basenumer
        finalDen = baseden*den1F
    }
   else{
        finalDen =num1F*baseden
        finalNum = den1F*basenumer
    }
    //simplifying the fraction
    val gcd = findGCD(finalNum,finalDen)
    finalNum/=gcd
    finalDen/=gcd
    println("multiply of Two fractions")
    return "$finalNum/$finalDen"
}


//getting the numerator
fun getNum(): Float {
    print("input numerator : ")
    return readLine()!!.toFloat()
}
//getting the denominator
fun getDen():Float{
    print("input denominator : ")
    var den1F = readLine()!!.toFloat()
    while(den1F==0F){
        print("denominator cant be equal to 0, input other number: ")
        den1F = readLine()!!.toFloat()
    }
    return den1F
}

fun actions(fraction: Fraction){
    println("Choose action: [1] simplify " +
            " [2] multiply or divide " +
            "[3] addition or subtraction ")
    var inputNum = Integer.valueOf(readLine())
    while(inputNum!=1&&inputNum!=2&&inputNum!=3){
        println("invalid action. Reminder: [1] simplify " +
                " [2] multiply or divide " +
                "[3] addition or subtraction ")
        inputNum = Integer.valueOf(readLine())
    }
    if(inputNum==1){
        println(simplify(fraction))
    }
    else if(inputNum==2){
        println(multOrDivision(fraction))
    }
    else{
        println(additionOrSubtraction(fraction))
    }
    println("type 1 to end process | type 2 to redo process ")
     inputNum = Integer.valueOf(readLine())
    while(inputNum!=1&&inputNum!=2){
        println("invalid number.type 1 to end process | type 2 to redo process " )
        inputNum = Integer.valueOf(readLine())
    }
    if(inputNum==1){
        return
    }
    else{
        actions(fraction)
    }
}