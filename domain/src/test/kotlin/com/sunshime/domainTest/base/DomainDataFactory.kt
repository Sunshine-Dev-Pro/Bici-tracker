package com.sunshime.domainTest.base

import java.util.*
import java.util.concurrent.ThreadLocalRandom

object DomainDataFactory {

    fun randomUuid() = UUID.randomUUID().toString()

    fun randomString() = randomUuid()

    fun randomInt() = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

    fun randomInt(max: Int) = ThreadLocalRandom.current().nextInt(0, max)

    fun randomLong() = randomInt().toLong()

    fun randomFloat() = randomInt().toFloat()

    fun randomDouble() = randomInt().toDouble()

    fun randomBoolean() = Math.random() < 0.5

    fun makeStringList(count: Int): List<String> {
        val items = mutableListOf<String>()
        repeat(count) {
            items.add(randomUuid())
        }
        return items
    }

    fun makeDoubleList(count : Int) : List<Double> {
        val items = mutableListOf<Double>()
        repeat(count) {
            items.add(randomDouble())
        }
        return items
    }
}