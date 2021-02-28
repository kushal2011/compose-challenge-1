package com.example.androiddevchallenge

object Constants {
    val PUPPY_DETAILS_INTENT = "puppy"
}

object Utilities {
    fun getPuppysAge(age: Double): String {
        when {
            age < 1 && age > 0.1 -> {
                return "Age: ${age * 10} months"
            }
            age == 0.1 -> {
                return "Age: ${age * 10} month"
            }
            age > 1 -> {
                return "Age: $age years"
            }
            age == 1.0 -> {
                return "Age: $age year"
            }
            else -> {
                return ""
            }
        }
    }

}