package vcmsa.ci.flashcardquize

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class QuizeCard : AppCompatActivity() {
    private lateinit var QuestionsTextView: TextView
    private lateinit var FeedbackTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    private val questions = arrayOf(
        "Jupiter is the largest planet in our solar system",
        "Isaac Newton discovered the law of gravity",
        "The chemical symbol of water is CO₂",
        "Mercury is the planet closest to the sun",
        "Pablo Picasso painted Mona Lisa"
    )

    private val answers = booleanArrayOf(true, true, false, true, false)    //This method was taken from geeksfongeeks
                                                                            //https://www.geeksforgeeks.org/kotlin=array
                                                                            //Jacobantony
                                                                            //https://www.geeksforgeeks.org/user/jacobantony1/
    private var score = 0
    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quize_card)

        QuestionsTextView = findViewById(R.id.Questions)
        FeedbackTextView = findViewById(R.id.feedback)
        trueButton = findViewById(R.id.accurate)
        falseButton = findViewById(R.id.fake)
        nextButton = findViewById(R.id.following)

        loadQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            nextQuestion()
        }
    }

    private fun loadQuestion() {
        if (currentQuestionIndex < questions.size) {                        //Code attribution
                                                                            //This method was taken from W^3 schools
                                                                            //https://www.w3schools.com/kotlin/kotlin_conditions.php
            QuestionsTextView.text = questions[currentQuestionIndex]
            trueButton.isEnabled = true
            falseButton.isEnabled = true
            nextButton.isEnabled = false
            FeedbackTextView.text = ""
        } else {
            val intent =Intent(this, Score::class.java) //This method was taken from stackoverflow
                                                        //https://stackoverflow.com/questions/45535272/how-to-link-button-with-website-in-android-studio-using-kotlin
                                                            //BakaWaii
                                                              //https://stackoverflow.com/users/8343333/bakawaii
            intent.putExtra("score",score)
            startActivity(intent)
            endQuiz()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestionIndex]) {
            FeedbackTextView.text = "Correct!"
            score++
        } else {
            FeedbackTextView.text = "Incorrect!"
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }

    private fun nextQuestion() {
        currentQuestionIndex++
        loadQuestion()
    }

    private fun endQuiz() {
        QuestionsTextView.text = "Quiz Finished! Your score: $score"
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = false
    }
}


