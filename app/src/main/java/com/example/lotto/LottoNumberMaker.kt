package com.example.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {

    fun getRamdomLottoNumbers(): MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()
        for(i in 1..6) {
            var number = 0
            do {
                number = getRandomLottoNumber()
            } while(lottoNumbers.contains(number))
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    fun getRandomLottoNumber():Int {
        return Random().nextInt(45)+1
    }

    fun getShuffleLottoNumbers(): MutableList<Int> {
        val list = mutableListOf<Int>()
        for(number in 1..45) {
            list.add(number)
        }
        list.shuffle()
        return list.subList(0,6)
    }

    fun getLottoNumbersFromHash(name:String) : MutableList<Int> {
        val list = mutableListOf<Int>()
        for(number in 1..45) {
            list.add(number)
        }
        val targetString = SimpleDateFormat("yyyy-mm-dd", Locale.KOREA).format(Date()) + name
        list.shuffle(Random(targetString.hashCode().toLong()))
        return list.subList(0,6)
    }
}