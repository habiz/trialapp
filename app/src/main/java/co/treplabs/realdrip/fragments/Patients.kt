package co.treplabs.realdrip.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import co.treplabs.realdrip.PatientView

import co.treplabs.realdrip.R
import co.treplabs.realdrip.adapters.Patients
import co.treplabs.realdrip.interfaces.FragmentActionListener
import co.treplabs.realdrip.interfaces.PatientClickListener
import co.treplabs.realdrip.models.Patient
import kotlinx.android.synthetic.main.fragment_patients.view.*

class Patients : Fragment(), PatientClickListener {
    override fun onPatientClick(patient: Patient) {
        contactParent(
            "patient",
            Intent(activity, PatientView::class.java).putExtra("patient", patient)
        )
    }




    private var listener: FragmentActionListener? = null
    private var rootView: View? = null
    private var adapter: Patients = Patients(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_patients, container, false)

        //prepare recycler view and adapter for population
        init()

        return rootView
    }

    private fun init() {
        rootView!!.recycler.layoutManager = LinearLayoutManager(context)
        rootView!!.recycler.adapter = adapter
    }

    fun replaceData(patients: ArrayList<Patient>){
        adapter.updateAdapter(patients)
    }

    private fun contactParent(action: String, intent: Intent? = null) {
        listener?.onFragmentAction(action, intent)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentActionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement patient's fragment listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


}
