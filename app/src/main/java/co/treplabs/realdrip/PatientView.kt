package co.treplabs.realdrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.treplabs.realdrip.models.Patient

class PatientView : AppCompatActivity() {
    private var patient: Patient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_view)

        retrieveData()
    }

    private fun retrieveData() {
        patient = intent.getSerializableExtra("patient") as Patient

        //TODO: bind data
    }

    fun goBack(view: View) {
        onBackPressed()
    }
}
