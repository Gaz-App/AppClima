package mx.edu.cesba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val TAG = "mx.edu.cesba"


        val btnqro = findViewById<Button>(R.id.btn_qro)
        val btncdmx = findViewById<Button>(R.id.btn_cdmx)

        btnqro.setOnClickListener(View.OnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "Ciudad de Quéretaro")
            startActivity(intent)
        })


        btncdmx.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "Ciudad de México")
            startActivity(intent)
        })

    }
}