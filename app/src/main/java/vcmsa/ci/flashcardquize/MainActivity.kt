package vcmsa.ci.flashcardquize

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
private lateinit var WelcomemessageTextView: TextView
private lateinit var FlashcardquizeTextView: TextView
private lateinit var StartButton: Button
private lateinit var ExitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            WelcomemessageTextView = findViewById(R.id.Welcome)
        FlashcardquizeTextView = findViewById(R.id.Message)
        StartButton = findViewById(R.id.begin)
        ExitButton = findViewById(R.id.exit)

        StartButton.setOnClickListener {
            val intent = Intent (this,QuizeCard::class.java )       //This method was taken from stackoverflow
                                                                    //https://stackoverflow.com/questions/45535272/how-to-link-button-with-website-in-android-studio-using-kotlin
                                                                     //BakaWaii
                                                                     //https://stackoverflow.com/users/8343333/bakawaii
            startActivity(intent)
            ExitButton.setOnClickListener{
                finish()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}