package com.example.retrofitjobqueue


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.config.Configuration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  MainView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargarDatos()
    }

    fun cargarDatos(){
        val builder = Configuration.Builder(this)
            .minConsumerCount(1)
            .maxConsumerCount(3)
            .loadFactor(3)
            .consumerKeepAlive(120)

        val jobManager = JobManager(builder.build())
        val serviceJob = GetResourceListJob(Params(50).requireNetwork(), this)
        jobManager.addJobInBackground(serviceJob)
        jobManager.start()
    }

    override fun setDataset(items: List<ModeloItem>) {

        loadingView.visibility = View.GONE
        mainRecycler.visibility = View.VISIBLE
        mainRecycler.layoutManager = GridLayoutManager(this, 2)
        mainRecycler.adapter = ItemAdapter(items) {
            Toast.makeText(this, String.format("Click en %s", it.item), Toast.LENGTH_SHORT)
        }
    }
}
