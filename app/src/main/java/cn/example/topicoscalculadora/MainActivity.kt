package cn.example.topicoscalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var ht : Int = 0
    private var hp : Int = 0

    private lateinit var tvHorasTeorica : TextView
    private lateinit var buttonHTRemove : FloatingActionButton
    private lateinit var buttonHTAdd : FloatingActionButton

    private lateinit var tvHorasPractica : TextView
    private lateinit var buttonHPRemove : FloatingActionButton
    private lateinit var buttonHPAdd : FloatingActionButton
    private lateinit var buttonCalcular : Button
    private lateinit var etCreditos : EditText
    private lateinit var etMateria: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        initComponent()
        initListener()
        initUI()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        setHT()
        setHP()
    }

    private fun initComponent() {
        tvHorasTeorica = findViewById(R.id.tvHorasTeorica);
        buttonHTAdd = findViewById(R.id.buttonHTAdd);
        buttonHTRemove = findViewById(R.id.buttonHTRemove)

        tvHorasPractica = findViewById(R.id.tvHorasPractica);
        buttonHPAdd = findViewById(R.id.buttonHPAdd)
        buttonHPRemove = findViewById(R.id.buttonHPRemove)

        buttonCalcular = findViewById(R.id.btnCalcular)
        etCreditos = findViewById(R.id.etCreditos)
        etMateria = findViewById(R.id.etMateria)
    }

    private fun initListener() {
        buttonHTAdd.setOnClickListener {
            ht += 1
            setHT()
        }
        buttonHTRemove.setOnClickListener {
            if (ht >= 1){
                ht -= 1
                setHT()
            }
        }
        buttonHPAdd.setOnClickListener {
            hp += 1
            setHP()
        }
        buttonHPRemove.setOnClickListener {
            if (hp >= 1){
                hp -= 1
                setHP()
            }
        }
        buttonCalcular.setOnClickListener {
            if (etMateria.text.isEmpty()) {
                Toast.makeText(this, "DEBE INGRESAR NOMBRE DE LA MATERIA", Toast.LENGTH_SHORT)
                    .show()
            } else if ((etCreditos.text.isEmpty()) || (etCreditos.text.equals("0"))) {
                Toast.makeText(
                    this,
                    "DEBE INGRESAR NUMERO DE CREDITOS, NO PUEDE SER 0",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                calcularTrabajoIndependiente()
            }
        }
    }

    private fun setHT(){
        tvHorasTeorica.text = ht.toString()
    }
    private fun setHP(){
        tvHorasPractica.text = hp.toString()
    }

    private fun calcularTrabajoIndependiente() {
        var creditos = etCreditos.text.toString()
        var horasPorCreditos = (creditos.toInt() * 48)
        var horasPresenciales = ((ht + hp) * 16)
        var trabajoIndependiente = ((horasPorCreditos - horasPresenciales) / 16)
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("trabajoIndependiente", trabajoIndependiente)
        intent.putExtra("materia", etMateria.text.toString())
        intent.putExtra("creditos", creditos)
        intent.putExtra("horasTeoricas", ht)
        intent.putExtra("horasPracticas", hp)
        startActivity(intent)
    }
}