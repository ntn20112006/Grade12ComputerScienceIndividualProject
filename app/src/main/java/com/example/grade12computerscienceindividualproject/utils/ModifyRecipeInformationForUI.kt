package com.example.grade12computerscienceindividualproject.utils

class ModifyRecipeInformationForUI {
    fun getAverageCookTimePerRecipeYield(time: List<String>, yield: Int) : List<String> {
        var minutes: Int = time[2].toInt()
        minutes += time[0].toInt() * 24 * 60
        minutes += time[1].toInt() * 60

        minutes /= yield
        val days: Int = minutes / 60 / 24
        val hours: Int = minutes % (60 * 24) / 60
        minutes %= 60

        return listOf(days.toString(), hours.toString(), minutes.toString())
    }

    fun getRecipeCookTime(time: String) : List<String> {
        val tempTimeList = mutableListOf<String>()
        var tempTime = ""
        for (character in time) {
            if (character == 'P' || character == 'T')
                continue
            if (character == 'D' || character == 'H' || character == 'M') {
                tempTimeList.add(tempTime)
                tempTime = ""
                continue
            }
            tempTime += character
        }
        return tempTimeList
    }
}
