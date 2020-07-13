fun main() {
    print(CountDiv().solution(10,10,7))
}
class CountDiv {

    fun solution(A: Int, B: Int, K: Int): Int {

        var start = -1
        for (i in A..B) {
            if (i % K == 0) {
                start = i
                break
            }
        }
        return if (start == -1){
            0
        }else{
            ((B-start) / K) +1
        }
    }

}

