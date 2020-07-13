import java.util.*

class Brackets {
    fun solution(S: String): Int {
        val stack = Stack<Char>()
        val start = charArrayOf('{', '[', '(')
        val end = charArrayOf('}', ']', ')')
        S.forEach {
            if (start.contains(it)) {
                stack.push(it)
            } else if (end.contains(it)) {
                if (stack.isEmpty()) {
                    return 0
                }
                val pop = stack.pop()
                if (it == '}' && pop != '{') {
                    return 0
                }
                if (it == ']' && pop != '[') {
                    return 0
                }
                if (it == ')' && pop != '(') {
                    return 0
                }
            }
        }
        return if (stack.isEmpty()) {
            1
        } else {
            0
        }
    }
}