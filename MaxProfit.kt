fun main() {
    print(MaxProfit().solution(intArrayOf(23171, 21011, 21123, 21366, 21013, 21367)))
}
class MaxProfit {
    fun solution(A: IntArray): Int {
        var min = 400001
        var answer = 0
        for (i in A){
            if (i<min){
                min = i
            }else{
                answer = Math.max(answer,i-min)
            }
        }
        return answer
    }
}