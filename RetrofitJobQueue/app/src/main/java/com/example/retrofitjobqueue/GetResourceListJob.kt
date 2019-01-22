package com.example.retrofitjobqueue

import android.os.Looper
import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import java.util.logging.Handler

class GetResourceListJob(params: Params?, val view: MainView) : Job(params) {
    override fun onRun() {
        val resourceService = AppiUtils.generarInstanciaRetrofit().create(ServicioDeRecursos::class.java)

        val call = resourceService.solicitarListaRecursos("Fruit", "Peaches")

        val result = call.execute().body()
        val items = MapeadoItem().transform(result!!)

        val uiHandler = android.os.Handler(Looper.getMainLooper())
        val runnable = Runnable {
            view.setDataset(items)
        }

        uiHandler.post(runnable)
    }

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        return RetryConstraint(false)
    }

    override fun onAdded() {

    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {

    }
}