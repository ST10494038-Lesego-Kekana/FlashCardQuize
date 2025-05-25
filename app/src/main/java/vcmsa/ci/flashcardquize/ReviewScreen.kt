package vcmsa.ci.flashcardquize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewScreen : AppCompatActivity() {
    private lateinit var reviewTextView: TextView
    private lateinit var resetButton: Button
    private lateinit var ExitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_screen)
        reviewTextView = findViewById(R.id.Review)
        resetButton = findViewById(R.id.Review)
        ExitButton = findViewById(R.id.terminate)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")
val reviewText = StringBuilder()
if (questions != null && answers != null && questions.size ==answers.size) {
    for (i in questions.indices) {
        reviewText.append("${i + 1}. ${questions[i]}\n")
        reviewText.append("  Answer: ${if (answers[i]) "True" else "False"}\n\n")
    }
    reviewTextView.text = reviewText.toString()
}else {
    reviewTextView.text = "Error loading check data."
}
        resetButton.setOnClickListener {
            val intent =Intent(this,QuizeCard::class.java)      //This method was taken from stackoverflow
                                                                //https://stackoverflow.com/questions/45535272/how-to-link-button-with-website-in-android-studio-using-kotlin
                                                                //BakaWaii
                                                                 //https://stackoverflow.com/users/8343333/bakawaii
            startActivity(intent)
        }
        ExitButton.setOnClickListener{
            finishAffinity()
        }
        }
    }
