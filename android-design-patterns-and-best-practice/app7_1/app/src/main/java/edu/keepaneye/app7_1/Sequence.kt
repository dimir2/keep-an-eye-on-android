package edu.keepaneye.app7_1

abstract class Sequence : Cloneable {
    var result: Long = 0L
    lateinit var id: String

    public override fun clone(): Any {
        return super.clone()
    }


}

class Prime : Sequence() {
    init {
        result = nthPrime(10000)
    }

    companion object {
        fun nthPrime(n: Int): Long {
            var index: Long = 2
            var count: Int = 0
            while (count < n) {
                if (isPrime(index++)) ++count
            }
            return index - 1
        }

        private fun isPrime(n: Long): Boolean {
            for (i in 2 until n) {
                if (n % i == 0L) {
                    return false
                }
            }
            return true
        }
    }
}

class Fibonacci : Sequence() {
    init {
        result = nthFib(100)
    }

    companion object {
        private fun nthFib(n: Int): Long {
            var f: Long = 0L
            var g: Long = 1L
            for (i in 1..n) {
                f = f + g
                g = f - g
            }
            return f
        }
    }
}

public class SequenceCache {
    companion object {
        private val sequenceHash = HashMap<String, Sequence>()
        public fun getSequence(sequenceId:String): Sequence {
            val cachedSequence: Sequence = sequenceHash.get(sequenceId)!!
            return cachedSequence.clone() as Sequence
         }
        public fun loadCache(): Unit {
            val prime = Prime()
            prime.id = "1"
            sequenceHash.put(prime.id, prime)
            val fib = Fibonacci()
            fib.id="2"
            sequenceHash.put(fib.id, fib)
        }
    }
}