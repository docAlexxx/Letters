package com.example.letters

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.letters.databinding.FragmentSyllableBinding
import kotlinx.coroutines.delay

class SyllableFragment :
    BindingFragment<FragmentSyllableBinding>(FragmentSyllableBinding::inflate) {

    private val duration = 1000L

    private val generate: Generator by lazy {
        Generator()
    }

    lateinit var letterFirst: Generator.Letter
    lateinit var letterSecond: Generator.Letter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetters()
        setButton()
        binding.tvLettercounter.text=sellyableCount.toString()
    }

    fun animateViews(
        start: Float,
        rotate: Float,
        startMove: Float,
        endMove: Float,
        midMove:Float,
        midMove2:Float,
    ) {
        ObjectAnimator.ofFloat(binding.dinoImageview, View.ROTATION, start, rotate)
            .setDuration(duration).start()
        ObjectAnimator.ofFloat(binding.dinoImageview, View.TRANSLATION_X, startMove, endMove,startMove)
            .setDuration(duration).start()
        ObjectAnimator.ofFloat(binding.dinoImageview, View.TRANSLATION_Y, startMove, midMove,startMove,midMove2,startMove)
            .setDuration(duration).start()
    }


    fun setButton() {
        binding.btnNewSellyable.setOnClickListener {
            getLetters()
        }
        binding.fab.setOnClickListener {
            animateViews(0f,720f,0f,500f,-100f,100f)
            Handler().postDelayed(Runnable {
                generate.countRiser("sellyable")
                binding.tvLettercounter.text=sellyableCount.toString()
                getLetters()
            }, duration/2)

        }

    }

    fun checkLetters() {

        if (letterFirst.name + letterSecond.name == "ЁБ") {
            letterFirst = generate.generateLetter(0, 2)
        }


        if (letterFirst.name == "Ч" || letterFirst.name == "Щ"|| letterFirst.name == "Ж" || letterFirst.name == "Ш") {
            if (letterSecond.name == "Я") {
                letterSecond = generate.generateLetter(0, 0)
            }
            if (letterSecond.name == "Ю") {
                letterSecond = generate.generateLetter(2, 2)
            }
            if (letterSecond.name == "Ы") {
                letterSecond = generate.generateLetter(7, 7)
            }
            if (letterSecond.name == "Ё") {
                letterSecond = generate.generateLetter(1, 1)
            }
            if (letterSecond.name == "Э") {
                letterSecond = generate.generateLetter(5, 5)
            }

        }

    }

    fun getLetters() {

        val query=(1..5).random()

        if (query > 3) {
            letterFirst = generate.generateLetter(0, 9)
            letterSecond = generate.generateLetter(10, 30)
        } else {
            letterSecond = generate.generateLetter(0, 9)
            letterFirst = generate.generateLetter(10, 29)
        }

        checkLetters()

        with(binding) {
            tvFirstLetter.text = letterFirst.name
            tvSecondLetter.text = letterSecond.name
            if (letterFirst.isVowel) {
                tvFirstLetter.setTextColor(Color.parseColor("#FF0000"))
                tvSecondLetter.setTextColor(Color.parseColor("#0729E6"))
            } else {
                tvSecondLetter.setTextColor(Color.parseColor("#FF0000"))
               if (letterSecond.isSoftening) {
                   tvFirstLetter.setTextColor(Color.parseColor("#01DD5D"))
               } else {
                   tvFirstLetter.setTextColor(Color.parseColor("#0729E6"))
               }
               }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = SyllableFragment()
    }
    override val viewModel: Any
        get() = TODO("Not yet implemented")
}