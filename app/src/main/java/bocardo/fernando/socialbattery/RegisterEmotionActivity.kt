package bocardo.fernando.socialbattery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterEmotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_emotion)
        val btnNext = findViewById<Button>(R.id.btnNext)
        var tvAge = findViewById<TextView>(R.id.tvAge)
        var etName = findViewById<TextView>(R.id.etName)
        var btnPlus = findViewById<Button>(R.id.btnPlus)
        var btnMinus = findViewById<Button>(R.id.btnMinus)
        var mAge = 5
        var indiceImg = 0
        val imageResources = intArrayOf(bocardo.fernando.socialbattery.R.drawable.img_feliz, bocardo.fernando.socialbattery.R.drawable.img_enojado, bocardo.fernando.socialbattery.R.drawable.img_triste)



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
                val imageName = resources.getResourceEntryName(imageResources[indiceImg])

                val sharedPreferences = getSharedPreferences("infoUsuario", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("age", mAge)
                editor.putString("imageName", imageName)
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