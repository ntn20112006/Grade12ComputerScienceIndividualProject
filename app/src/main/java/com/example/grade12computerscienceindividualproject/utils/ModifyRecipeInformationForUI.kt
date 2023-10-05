package com.example.grade12computerscienceindividualproject.utils

class ModifyRecipeInformationForUI {
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
