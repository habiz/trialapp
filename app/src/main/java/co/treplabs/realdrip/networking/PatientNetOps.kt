package co.treplabs.realdrip.networking

import android.content.Context
import android.os.Handler
import co.treplabs.realdrip.R
import co.treplabs.realdrip.models.Patient
import co.treplabs.realdrip.utils.Network
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class PatientNetOps {

    fun fetchPatients(context: Context, listener: PatientsFetchListener){
        listener.fetchingPatients()

        //NOTE: Handler below is setup with context's UI thread. Update UI data with this handler to prevent Exceptions
        val handler = Handler(context.mainLooper)

        Network.makeGetRequest(context.getString(R.string.base_url)).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {

                //TODO: below is dummy response. Replace with response's data using created models
                handler.post {
                    listener.patientsFetched(true, arrayListOf(Patient(), Patient()))
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                //TODO: Below just assumes that no network failure. handle network failures here with proper responses.
                handler.post {
                    listener.patientsFetched(true, arrayListOf(Patient(), Patient()))
                }
            }
        })

    }

    interface PatientsFetchListener {
        fun fetchingPatients()
        fun patientsFetched(status: Boolean, patients: ArrayList<Patient>)
    }
}