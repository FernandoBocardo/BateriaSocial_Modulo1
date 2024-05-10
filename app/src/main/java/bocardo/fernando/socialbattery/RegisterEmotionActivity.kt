package bocardo.fernando.socialbattery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RegisterEmotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_emotion)
        val btnNext = findViewById<Button>(R.id.btnNext)
        var tvAge = findViewById<TextView>(R.id.tvAge)
        var etName = findViewById<TextView>(R.id.etName)
        var btnPlus = findViewById<Button>(R.id.btnPlus)
        var btnMinus = findViewById<Button>(R.id.btnMinus)
        var imagenEmocion = findViewById<ImageView>(R.id.imgAvatar)

        val emocionSeleccionada = intent.getStringExtra("emocionSeleccionada")

        val imagenId = when (emocionSeleccionada) {
            "Alegria" -> R.drawable.alegriaa
            "Tristeza" -> R.drawable.tristeza
            "Confianza" -> R.drawable.confianza
            "Desagrado" -> R.drawable.desa
            "Miedo" -> R.drawable.miedo
            "Ira" -> R.drawable.ira
            "Sorpresa" -> R.drawable.sorpresa
            "Anticipación" -> R.drawable.anticipacion
            else -> R.drawable.img_error
        }

        imagenEmocion.setImageResource(imagenId)
        var mAge = 5
        //var indiceImg = 0
        //val imageResources = intArrayOf(bocardo.fernando.socialbattery.R.drawable.img_feliz, bocardo.fernando.socialbattery.R.drawable.img_enojado, bocardo.fernando.socialbattery.R.drawable.img_triste)



        tvAge.text = mAge.toString()
        //btnNext.setOnClickListener {
            //val intent = Intent(this, FavoriteThemesActivity::class.java)
            //startActivity(intent)
        //}

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnPlus.setOnClickListener {
            if (mAge < 10) {
                mAge++
                tvAge.text = mAge.toString()
            }
        }

        btnMinus.setOnClickListener {
            if (mAge > 1) {
                mAge--
                tvAge.text = mAge.toString()
            }
        }

        btnNext.setOnClickListener {
            var mName = etName.text.toString()

            if (mName.isEmpty()){
                etName.error = "Ingrese un mensaje"
                etName.requestFocus()
            }
            else {
                val mAge = tvAge.text.toString()

                val sharedPreferences = getSharedPreferences("infoUsuario", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("age", mAge)
                editor.putString("name", mName)
                editor.apply()

                println(sharedPreferences.getString("user", ""))
                println(sharedPreferences.getString("email", ""))
                println(sharedPreferences.getString("password", ""))
                println(sharedPreferences.getString("age", ""))
                println(sharedPreferences.getString("imageName", ""))
                println(sharedPreferences.getString("name", ""))

                //val intent = Intent(this, FavoriteThemesActivity::class.java)
                //startActivity(intent)
            }
        }
    }
}