fun main() {
    println(Flags().solution2(intArrayOf(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)))
}

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

    fun solution2(A: IntArray): Int {
        if (A.size < 3)
            return 0

        val Peaks = ArrayList<Int>()
        for (i in 1 until A.size - 1) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1])
                Peaks.add(i)
        }

        if (Peaks.size < 3)
            return Peaks.size

        var output = 0

        for (K in 2..Peaks.size) {

            var flags = 1
            var peak = 0
            var next_peak = 1
            println()
            while (peak < Peaks.size - 1) {
                if (Math.abs(Peaks[peak] - Peaks[next_peak]) >= K) {
                    flags += 1
                    println("  ${Peaks[peak]} ${Peaks[next_peak]}")
                    peak = next_peak
                    next_peak = peak + 1

                } else
                    next_peak += 1
                if (next_peak == Peaks.size || flags == K)
                    break
            }
            if (output > flags) {
                println("  $K")
                return output
            }

            output = Math.max(flags, output)
        }
        return output
    }
}