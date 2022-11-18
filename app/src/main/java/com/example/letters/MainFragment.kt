package com.example.letters

import android.os.Bundle
import android.view.View
import com.example.letters.databinding.FragmentMainBinding

class MainFragment :
    BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setButtons()

    }


    fun setButtons() {
        binding.btnLetter.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(R.id.fragment_container, LetterFragment.newInstance())
                .commit()
        }

        binding.btnSellyable.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SyllableFragment.newInstance()).addToBackStack("")
                .commit()
        }

        binding.btnSellyable3.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Syllable3Fragment.newInstance())
                .addToBackStack("")
                .commit()
        }

    }


    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override val viewModel: Any
        get() = TODO("Not yet implemented")

}