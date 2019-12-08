package co.treplabs.realdrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.treplabs.realdrip.fragments.Patients
import co.treplabs.realdrip.interfaces.FragmentActionListener
import co.treplabs.realdrip.models.Patient
import co.treplabs.realdrip.networking.PatientNetOps
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentActionListener {
    override fun onFragmentAction(action: String, intent: Intent?) {
        when(action){
            "patient" -> {
                startActivity(intent)
                overridePendingTransition(R.anim.enter, R.anim.exit)
            }
        }
    }

    private val fragmentContainer = R.id.container
    private var patientsFragment = Patients()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up UI environment
        setupUIEnvironment()

        //fetch Patient data from API
        fetchDataFromNetwork()
    }

    private fun fetchDataFromNetwork() {
        PatientNetOps().fetchPatients(this@MainActivity, object: PatientNetOps.PatientsFetchListener {
            override fun fetchingPatients() {
                showProgress(true)
            }

            override fun patientsFetched(status: Boolean, patients: ArrayList<Patient>) {
                showProgress(false)

                //TODO: handle API network failures using status above
                if(!status){
                    //network request failed
                    return
                }

                patientsFragment.replaceData(patients)
            }
        })
    }

    private fun setupUIEnvironment() {
        val transaction = supportFragmentManager.beginTransaction()

        //render fragment in container
        transaction.replace(fragmentContainer, patientsFragment).commit()
    }

    private fun showProgress(show: Boolean) {
        if(show){
            progress.visibility = View.VISIBLE
            container.visibility = View.GONE
        }else{
            progress.visibility = View.GONE
            container.visibility = View.VISIBLE
        }
    }
}
