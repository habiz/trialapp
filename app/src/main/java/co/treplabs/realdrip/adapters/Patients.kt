package co.treplabs.realdrip.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.treplabs.realdrip.R
import co.treplabs.realdrip.interfaces.PatientClickListener
import co.treplabs.realdrip.models.Patient
import kotlinx.android.synthetic.main.patient_layout.view.*

class Patients(var patientClickCallback: PatientClickListener, var patientsData: ArrayList<Patient> = arrayListOf()): RecyclerView.Adapter<Patients.ViewHost>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHost {
        return ViewHost(LayoutInflater.from(parent.context).inflate(R.layout.patient_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return 4 //patientsData.size
    }

    fun updateAdapter(patientsData: ArrayList<Patient>){
        this@Patients.patientsData = patientsData

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHost, index: Int) {
        holder.bind(index)
    }

    inner class ViewHost(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(index: Int){
            val data = patientsData[0]
            //TODO: bind indexed patient data

            view.clicker.setOnClickListener {
                patientClickCallback.onPatientClick(data)
            }
        }
    }
}