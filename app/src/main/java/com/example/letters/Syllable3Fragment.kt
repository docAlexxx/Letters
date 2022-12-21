package com.example.letters

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.letters.databinding.FragmentSyllable3Binding

class Syllable3Fragment :
    BindingFragment<FragmentSyllable3Binding>(FragmentSyllable3Binding::inflate) {

    val duration = 1000L

    private val generate: Generator by lazy {
        Generator()
    }

    lateinit var letterFirst: Generator.Letter
    lateinit var letterSecond: Generator.Letter
    lateinit var letterThird: Generator.Letter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLetters()
        setButton()
        binding.tvLettercounter.text = sellyableCount3.toString()
    }

    fun animateViews(
        start: Float,
        rotate: Float,
        startMove: Float,
        endMove: Float,
        midMove: Float,
        midMove2: Float,
    ) {
        ObjectAnimator.ofFloat(binding.dinoImageview, View.ROTATION, start, rotate)
            .setDuration(duration).start()
        ObjectAnimator.ofFloat(
            binding.dinoImageview,
            View.TRANSLATION_X,
            startMove,
            endMove,
            startMove
        )
            .setDuration(duration).start()
        ObjectAnimator.ofFloat(
            binding.dinoImageview,
            View.TRANSLATION_Y,
            startMove,
            midMove,
            startMove,
            midMove2,
            startMove
        )
            .setDuration(duration).start()
    }

    fun setButton() {
        binding.btnNewLetter3.setOnClickListener {
            getLetters()
        }
        binding.fab.setOnClickListener {
            animateViews(0f, 720f, 0f, 500f, -100f, 100f)

            Handler().postDelayed(Runnable {
                generate.countRiser("sellyable3")
                binding.tvLettercounter.text = sellyableCount3.toString()
                getLetters()
            }, duration / 2)
        }

    }

    fun checkLetters() {
        if (letterSecond.name + letterThird.name == "УЙ") {
            letterSecond = generate.generateLetter(0, 1)
        }

        if (letterFirst.name + letterSecond.name + letterThird.name == "ХЕР") {
            letterSecond = generate.generateLetter(0, 1)
        }

        if (letterSecond.name + letterThird.name == "ЁБ") {
            letterSecond = generate.generateLetter(0, 2)
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
         letterFirst = generate.generateLetter(10, 29)
         letterSecond = generate.generateLetter(0, 9)
         letterThird = generate.generateLetter(10, 30)

        checkLetters()


        val result = concat(letterFirst.name, letterSecond.name, letterThird.name)

        with(binding) {
            tvFirstLetter3.text = letterFirst.name
            tvSecondLetter3.text = letterSecond.name
            tvThirdLetter3.text = letterThird.name

            tvSecondLetter3.setTextColor(Color.parseColor("#FF0000"))
            tvThirdLetter3.setTextColor(Color.parseColor("#0729E6"))

            if (letterSecond.isSoftening) {
                tvFirstLetter3.setTextColor(Color.parseColor("#01DD5D"))
            } else {
                tvFirstLetter3.setTextColor(Color.parseColor("#0729E6"))
            }
        }
    }

    fun concat(vararg string: String): String {
        val sb = StringBuilder()
        for (s in string) {
            sb.append(s)
        }

        return sb.toString()
    }


    companion object {
        @JvmStatic
        fun newInstance() = Syllable3Fragment()
    }

    override val viewModel: Any
        get() = TODO("Not yet implemented")
}