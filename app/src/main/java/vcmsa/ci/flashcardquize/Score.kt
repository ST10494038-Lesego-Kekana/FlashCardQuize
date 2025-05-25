package vcmsa.ci.flashcardquize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class Score : AppCompatActivity() {
    private lateinit var feedbackTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var ViewerButton: Button
    private lateinit var exitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        feedbackTextView = findViewById(R.id.Feedback)
        scoreTextView =findViewById(R.id.score)
        ViewerButton = findViewById(R.id.review)
        exitButton = findViewById(R.id.Exit)

        val score = intent.getIntExtra("score", 0)
        scoreTextView.text = "your score: $score/5"

        val feedback = if (score>= 3){
            "Good job!"
        }else {
            "Keep practicing!"
        }
        feedbackTextView.text = feedback
        ViewerButton.setOnClickListener {
            val intent = Intent(this,ReviewScreen::class.java) //This method was taken from stackoverflow
                                                                 //https://stackoverflow.com/questions/45535272/how-to-link-button-with-website-in-android-studio-using-kotlin
                                                                //BakaWaii
                                                                //https://stackoverflow.com/users/8343333/bakawaii
            startActivity(intent)
        }
        exitButton.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }
        }
    }
