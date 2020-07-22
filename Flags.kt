class Flags {
    fun solution(A: IntArray): Int {
        var answer = 0

        val peaks = ArrayList<Int>()

        for (i in 1 until A.size - 1) {
            if ((A[i] > A[i - 1] && A[i] > A[i + 1])) {
                peaks.add(i)
            }
        }

        if (peaks.size<=2){
            return peaks.size
        }

        for (k in 2 .. peaks.size) {
            var flags = 1
            var current = 0
            var next = 1

            while (current < peaks.size - 1 && next < peaks.size && flags < k) {
                if (peaks[next] - peaks[current] >= k) {
                    flags += 1
                    current = next
                    next = current + 1
                } else {
                    next += 1
                }
            }
            if (answer > flags){
                return answer
            }else{
                answer = flags
            }
        }
        return answer
    }
}