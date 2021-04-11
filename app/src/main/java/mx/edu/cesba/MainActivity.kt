package mx.edu.cesba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var viewciudad :TextView? = null
    var viewgrados: TextView? = null
    var viewestatus : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewciudad = findViewById(R.id.txt_ciudad)
        viewgrados = findViewById(R.id.txt_grados)
        viewestatus = findViewById(R.id.txt_status)

        val ciudad = intent.getStringExtra("mx.edu.cesba")

        val cdmx = Ciudad("Ciudad de México", 18, "Poco Sol")
        val qro = Ciudad("Ciudad de Quéretaro", 32, "Nubleado")

        if (ciudad == "Ciudad de Quéretaro"){
            // MOSTRAR INFORMACION DE QRO.
            viewciudad?.text= qro.nombre
            viewgrados?.text = qro.grados.toString() + "º"
            viewestatus?.text = qro.estatus

        }else if (ciudad == "Ciudad de México" ) {
            // MOSTRAR INFORMACION DE cd. mexico.
            viewciudad?.text= cdmx.nombre
            viewgrados?.text = cdmx.grados.toString() + "º"
            viewestatus?.text = cdmx.estatus
        }else{
            Toast.makeText(this, "NO HAY INFORMACION DE ESTA CIUDAD",
            Toast.LENGTH_SHORT).show()
        }

    }
}