package co.treplabs.realdrip.interfaces

import co.treplabs.realdrip.models.Patient

interface PatientClickListener {
    fun onPatientClick(patient: Patient)
}