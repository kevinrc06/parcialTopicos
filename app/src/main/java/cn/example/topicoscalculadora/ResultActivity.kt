package cn.example.topicoscalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var tvTrabajoIndependiente : TextView = findViewById(R.id.trabajoIndependiente)
        var tvMateria : TextView = findViewById(R.id.materia)
        var tvHorasTeoricas : TextView = findViewById(R.id.tvHorasTeorica2)
        var tvHorasPracticas : TextView = findViewById(R.id.tvHorasPracticas2)
        var tvCreditos : TextView = findViewById(R.id.tvnumeroCreditos)
        var regresar : Button = findViewById(R.id.regresar)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }

        var trabajoIndependiente : Int? = intent.extras?.getInt("trabajoIndependiente")
        var horasTeoricas : Int? = intent.extras?.getInt("horasTeoricas")
        var horasPracticas : Int? = intent.extras?.getInt("horasPracticas")
        var materia = intent.extras?.getString("materia")
        var creditos = intent.extras?.getString("creditos")


        tvTrabajoIndependiente.text = trabajoIndependiente.toString()
        tvMateria.text = materia
        tvHorasTeoricas.text = horasTeoricas.toString()
        tvHorasPracticas.text = horasPracticas.toString()
        tvCreditos.text = creditos


        regresar.setOnClickListener {
            finish()
        }

    }
}