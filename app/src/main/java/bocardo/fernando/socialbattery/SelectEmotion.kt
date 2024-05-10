package bocardo.fernando.socialbattery

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SelectEmotion : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_emotion)

        val btnBack = findViewById<Button>(R.id.btnBack)
        auth = Firebase.auth



        configurarBotones();

    }

    private fun emocionNoSeleccionada() {
        Toast.makeText(
            baseContext, "Debe seleccionar una emoción para continuar",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun configurarBotones() {
        val btnAlegria = findViewById<Button>(R.id.btnAlegria)
        val btnTristeza = findViewById<Button>(R.id.btnTristeza)
        val btnConfianza = findViewById<Button>(R.id.btnConfianza)
        val btnDesagrado = findViewById<Button>(R.id.btnDesagrado)
        val btnMiedo = findViewById<Button>(R.id.btnMiedo)
        val btnIra = findViewById<Button>(R.id.btnIra)
        val btnSorpresa = findViewById<Button>(R.id.btnSorpresa)
        val btnAnticipacion = findViewById<Button>(R.id.btnAnticipacion)
        val btnNext = findViewById<Button>(R.id.btnNext)

        var btnAlegriaSeleccionado = false
        var btnTristezaSeleccionado = false
        var btnConfianzaSeleccionado = false
        var btnDesagradoSeleccionado = false
        var btnMiedoSeleccionado = false
        var btnIraSeleccionado = false
        var btnSorpresaSeleccionado = false
        var btnAnticipacionSeleccionado = false

        fun eliminarSeleccion() {
            btnAlegriaSeleccionado = false
            btnTristezaSeleccionado = false
            btnConfianzaSeleccionado = false
            btnDesagradoSeleccionado = false
            btnMiedoSeleccionado = false
            btnIraSeleccionado = false
            btnSorpresaSeleccionado = false
            btnAnticipacionSeleccionado = false
            btnAlegria.setBackgroundResource(R.drawable.ic_age)
            btnAlegria.setTextColor(Color.parseColor("#66607E"))
            btnTristeza.setBackgroundResource(R.drawable.ic_age)
            btnTristeza.setTextColor(Color.parseColor("#66607E"))
            btnConfianza.setBackgroundResource(R.drawable.ic_age)
            btnConfianza.setTextColor(Color.parseColor("#66607E"))
            btnDesagrado.setBackgroundResource(R.drawable.ic_age)
            btnDesagrado.setTextColor(Color.parseColor("#66607E"))
            btnMiedo.setBackgroundResource(R.drawable.ic_age)
            btnMiedo.setTextColor(Color.parseColor("#66607E"))
            btnIra.setBackgroundResource(R.drawable.ic_age)
            btnIra.setTextColor(Color.parseColor("#66607E"))
            btnSorpresa.setBackgroundResource(R.drawable.ic_age)
            btnSorpresa.setTextColor(Color.parseColor("#66607E"))
            btnAnticipacion.setBackgroundResource(R.drawable.ic_age)
            btnAnticipacion.setTextColor(Color.parseColor("#66607E"))
        }

        fun obtenerEmocionSeleccionada(): String? {
            return when {
                btnAlegriaSeleccionado -> btnAlegria.text.toString()
                btnTristezaSeleccionado -> btnTristeza.text.toString()
                btnConfianzaSeleccionado -> btnConfianza.text.toString()
                btnDesagradoSeleccionado -> btnDesagrado.text.toString()
                btnMiedoSeleccionado -> btnMiedo.text.toString()
                btnIraSeleccionado -> btnIra.text.toString()
                btnSorpresaSeleccionado -> btnSorpresa.text.toString()
                btnAnticipacionSeleccionado -> btnAnticipacion.text.toString()
                else -> null
            }
        }

        btnAlegria.setOnClickListener {
            if (btnAlegriaSeleccionado) {
                btnAlegria.setBackgroundResource(R.drawable.ic_age)

                btnAlegria.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnAlegriaSeleccionado = false
            } else {
                if(btnTristezaSeleccionado || btnConfianzaSeleccionado || btnDesagradoSeleccionado || btnMiedoSeleccionado || btnIraSeleccionado || btnSorpresaSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnAlegria.setBackgroundResource(R.drawable.gradient_gold_button)

                btnAlegria.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnAlegriaSeleccionado = true
            }
        }

        btnTristeza.setOnClickListener {
            if (btnTristezaSeleccionado) {
                btnTristeza.setBackgroundResource(R.drawable.ic_age)

                btnTristeza.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnTristezaSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnConfianzaSeleccionado || btnDesagradoSeleccionado || btnMiedoSeleccionado || btnIraSeleccionado || btnSorpresaSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnTristeza.setBackgroundResource(R.drawable.gradient_gold_button)

                btnTristeza.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnTristezaSeleccionado = true
            }
        }

        btnConfianza.setOnClickListener {
            if (btnConfianzaSeleccionado) {
                btnConfianza.setBackgroundResource(R.drawable.ic_age)

                btnConfianza.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnConfianzaSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnTristezaSeleccionado || btnDesagradoSeleccionado || btnMiedoSeleccionado || btnIraSeleccionado || btnSorpresaSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnConfianza.setBackgroundResource(R.drawable.gradient_gold_button)

                btnConfianza.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnConfianzaSeleccionado = true
            }
        }

        btnDesagrado.setOnClickListener {
            if (btnDesagradoSeleccionado) {
                btnDesagrado.setBackgroundResource(R.drawable.ic_age)

                btnDesagrado.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnDesagradoSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnTristezaSeleccionado || btnConfianzaSeleccionado || btnMiedoSeleccionado || btnIraSeleccionado || btnSorpresaSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnDesagrado.setBackgroundResource(R.drawable.gradient_gold_button)

                btnDesagrado.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnDesagradoSeleccionado = true
            }
        }

        btnMiedo.setOnClickListener {
            if (btnMiedoSeleccionado) {
                btnMiedo.setBackgroundResource(R.drawable.ic_age)

                btnMiedo.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnMiedoSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnTristezaSeleccionado || btnConfianzaSeleccionado || btnDesagradoSeleccionado || btnIraSeleccionado || btnSorpresaSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnMiedo.setBackgroundResource(R.drawable.gradient_gold_button)

                btnMiedo.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnMiedoSeleccionado = true
            }
        }

        btnIra.setOnClickListener {
            if (btnIraSeleccionado) {
                btnIra.setBackgroundResource(R.drawable.ic_age)

                btnIra.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnIraSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnTristezaSeleccionado || btnConfianzaSeleccionado || btnDesagradoSeleccionado || btnMiedoSeleccionado || btnSorpresaSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnIra.setBackgroundResource(R.drawable.gradient_gold_button)

                btnIra.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnIraSeleccionado = true
            }
        }

        btnSorpresa.setOnClickListener {
            if (btnSorpresaSeleccionado) {
                btnSorpresa.setBackgroundResource(R.drawable.ic_age)

                btnSorpresa.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnSorpresaSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnTristezaSeleccionado || btnConfianzaSeleccionado || btnDesagradoSeleccionado || btnMiedoSeleccionado || btnIraSeleccionado || btnAnticipacionSeleccionado) {
                    eliminarSeleccion()
                }
                btnSorpresa.setBackgroundResource(R.drawable.gradient_gold_button)

                btnSorpresa.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnSorpresaSeleccionado = true
            }
        }

        btnAnticipacion.setOnClickListener {
            if (btnAnticipacionSeleccionado) {
                btnAnticipacion.setBackgroundResource(R.drawable.ic_age)

                btnAnticipacion.setTextColor(Color.parseColor("#66607E")) //Color texto
                btnAnticipacionSeleccionado = false
            } else {
                if(btnAlegriaSeleccionado || btnTristezaSeleccionado || btnConfianzaSeleccionado || btnDesagradoSeleccionado || btnMiedoSeleccionado || btnIraSeleccionado || btnSorpresaSeleccionado) {
                    eliminarSeleccion()
                }
                btnAnticipacion.setBackgroundResource(R.drawable.gradient_gold_button)

                btnAnticipacion.setTextColor(Color.parseColor("#715F20")) //Color texto
                btnAnticipacionSeleccionado = true
            }
        }
        btnNext.setOnClickListener {
            val intent = Intent(this, RegisterEmotionActivity::class.java)
            intent.putExtra("emocionSeleccionada", obtenerEmocionSeleccionada())
            startActivity(intent)
        }

    }

}