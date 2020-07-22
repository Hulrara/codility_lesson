fun main() {
    print(CountFactors().solution(100))
}

class CountFactors {
    fun solution(N: Int): Int {
        var answer = 0

        for (i in 1..Math.sqrt(N.toDouble()).toInt()) {
            if(N%i ==0){
                answer +=1
                if (i*i < N){
                    answer +=1
                }
            }

        }
        return answer
    }
}