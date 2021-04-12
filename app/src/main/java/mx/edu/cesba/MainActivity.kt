package mx.edu.cesba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception

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

        // 203:
        if(Network.statusRed(this)){
            //EJECUTAR SOLICITUD HTTPP (despues de pegar el metodo volley)
            solicitudHTTPVolley(url = "https://api.openweathermap.org/data/2.5/weather?id=3530597&appid=300893205b07544c7c461e47973d610d")


        }else{
            // MOSTRAR MENSAJE DE ERROR:


        }

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
    //205: metodo volley

    private fun solicitudHTTPVolley(url: String) {
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->

            try {
                Log.d("Solictud a OPENWETHER", response)

            } catch (e: Exception) {

            }
        }, Response.ErrorListener { })

        queue.add(solicitud)
    }
}

// 201:
// https://openweathermap.org/
// https://openweathermap.org/api
// https://openweathermap.org/price
// https://home.openweathermap.org/api_keys
// KEY : 300893205b07544c7c461e47973d610d

// 202:
// CREAR LA CLASE NETWORK.KT
// PEGAR EL CODIGO DE LA APP getHttp
// OTORAGAR LOS PERMSIOS EN EL MANIFIESTO

//203: if

// 204:
//compile 'com.android.volley:volley:1.1.0'

//compile 'com.squareup.okhttp3:okhttp:3.6.0'

//205: metodo volley --COPIAR

// BUSCAR LA DIRECCION EN OPENWEATER PARA MEXICO:
// https://openweathermap.org/city/3530597
// ID = 3530597

//https://openweathermap.org/api
//https://openweathermap.org/price
//https://openweathermap.org/currentç

// By city ID:
//3530597

// https://api.openweathermap.org/data/2.5/weather?id=3530597&appid=300893205b07544c7c461e47973d610d
