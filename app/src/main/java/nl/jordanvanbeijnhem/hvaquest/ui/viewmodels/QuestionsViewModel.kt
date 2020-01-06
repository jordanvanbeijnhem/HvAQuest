package nl.jordanvanbeijnhem.hvaquest.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nl.jordanvanbeijnhem.hvaquest.models.Question
import nl.jordanvanbeijnhem.hvaquest.repository.QuestRepository

class QuestionsViewModel : ViewModel() {

    private val taskRepository = QuestRepository()
    var questions = MutableLiveData<List<Question>>()
    var index = 0
    var size = 0
    var lastQuestion = false

    fun getQuestions() {
        val list = taskRepository.getHvaQuest()
        questions.postValue(list)
        size = list.size
    }

    fun nextQuestion(): Int {
        val currentIndex = index
        index++
        if (index > size - 1) lastQuestion = true
        return currentIndex
    }

    fun previousQuestion() {
        if (index > 0) index--
    }

    fun reset() {
        index = 0
        lastQuestion = false
    }
}
