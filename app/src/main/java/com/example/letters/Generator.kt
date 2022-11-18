package com.example.letters

public class Generator {

    data class Letter(
        var name: String,
        val isVowel: Boolean,
        val isSoftening: Boolean
    ) {

    }

    val letters: List<Letter> = listOf(
        Letter("А", true, false),
        Letter("О", true, false),
        Letter("У", true, false),
        Letter("Ы", true, false),
        Letter("Э", true, false),
        Letter("Е", true, true),
        Letter("Ё", true, true),
        Letter("И", true, true),
        Letter("Ю", true, true),
        Letter("Я", true, true),
        Letter("Б", false, false),
        Letter("В", false, false),
        Letter("Г", false, false),
        Letter("Д", false, false),
        Letter("Ж", false, false),
        Letter("З", false, false),
        Letter("Й", false, false),
        Letter("К", false, false),
        Letter("Л", false, false),
        Letter("М", false, false),
        Letter("Н", false, false),
        Letter("П", false, false),
        Letter("Р", false, false),
        Letter("С", false, false),
        Letter("Т", false, false),
        Letter("Ф", false, false),
        Letter("Х", false, false),
        Letter("Ц", false, false),
        Letter("Ч", false, false),
        Letter("Ш", false, false),
        Letter("Щ", false, false),
        Letter("Ъ", false, false),
        Letter("Ь", false, false),

        )

    fun generateLetter(startLetter:Int,endLetter:Int):Letter {
        return    letters[(startLetter..endLetter).random()]
    }

    fun getABCLetter(index:Int):String {
        return   lettersABC[index]
    }

    val lettersABC: Array<String> = arrayOf(
        "А",
        "Б",
        "В",
        "Г",
        "Д",
        "Е",
        "Ё",
        "Ж",
        "З",
        "И",
        "Й",
        "К",
        "Л",
        "М",
        "Н",
        "О",
        "П",
        "Р",
        "С",
        "Т",
        "У",
        "Ф",
        "Х",
        "Ц",
        "Ч",
        "Ш",
        "Щ",
        "Ъ",
        "Ы",
        "Ь",
        "Э",
        "Ю",
        "Я"
    )
    val vowelLetters: Array<String> = arrayOf("А", "О", "У", "Ы", "Э", "Е", "Ё", "И", "Ю", "Я")
    val consonsntLetters: Array<String> = arrayOf(
        "Б",
        "В",
        "Г",
        "Д",
        "Ж",
        "З",
        "Й",
        "К",
        "Л",
        "М",
        "Н",
        "П",
        "Р",
        "С",
        "Т",
        "Ф",
        "Х",
        "Ц",
        "Ч",
        "Ш",
        "Щ",
        "Ъ",
        "Ь"
    )

}