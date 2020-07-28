class ChocolatesByNumbers {
    fun solution(N: Int, M: Int): Int {
        return N/gcd(N,M)
    }

    fun gcd(a:Int, b:Int):Int{
        if (b == 0 ){
            return a
        }
        return gcd(b, a%b)
    }
}