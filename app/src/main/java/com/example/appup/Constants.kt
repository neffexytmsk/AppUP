package com.example.appup


object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(1,"К какой стране относится флаг?",R.drawable.ic_flag_of_argentina,
        "Аргентина","Австрия", "Россия",1)

        questionList.add(que1)

        val que2 = Question(2,"На каком материке находится Бельгия?",R.drawable.ic_flag_of_belgium,
            "Евразия","Европа", "Северная Америка",1)

        questionList.add(que2)

        val que3 = Question(3,"Сколько населения в Австралии?",R.drawable.ic_flag_of_australia,
            "~ 25 млн.","~ 27 млн.", "~ 193 млн.",1)

        questionList.add(que3)

        val que4 = Question(4,"К какой Америке относится страна?",R.drawable.ic_flag_of_brazil,
            "Крутой","Северной", "Южной",3)

        questionList.add(que4)

        val que5 = Question(5,"С каким населением проживает Дания?",R.drawable.ic_flag_of_denmark,
            "~ 6 млн.","~ 10 млн.", "~ 1 млн.",1)

        questionList.add(que5)

        val que6 = Question(6,"Какой часовой пояс у Франции?",R.drawable.ic_flag_of_france,
            "UTC +3","UTC +5", "UTC +1",3)

        questionList.add(que6)

        val que7 = Question(7,"Какой язык у данной страны?",R.drawable.ic_flag_of_germany,
            "Немецкий","Английский", "Русский",1)

        questionList.add(que7)

        val que8 = Question(8,"Из каких цветов состоит страна?",R.drawable.ic_flag_of_italy,
            "Красный, белый, синий","Зеленый, белый, красный", "Оранжевый, черный, синий",2)

        questionList.add(que8)

        val que9 = Question(8,"Сколько населения в России?",R.drawable.ic_flag_of_russia,
            "~ 144 млн.","~ 150 млн.", "~ 200 млн.",1)

        questionList.add(que9)
        val que10 = Question(8,"К какому региону относится?",R.drawable.ic_flag_of_spain,
            "Африка","Центральная Америка", "Европа",3)

        questionList.add(que10)
        return questionList
    }
}