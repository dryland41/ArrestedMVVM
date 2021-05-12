package com.namespacermcw.arrestsearch

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.namespacermcw.arrestsearch.adapters.RecordsAdapter
import com.namespacermcw.arrestsearch.api.ApiClient
import com.namespacermcw.arrestsearch.api.ApiInterface
import com.namespacermcw.arrestsearch.model.JailHouse
import com.namespacermcw.arrestsearch.vm.RecordsListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import com.namespacermcw.arrestsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : RecordsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@MainActivity).get(RecordsListViewModel::class.java)

        val request = ApiClient.buildService(ApiInterface::class.java)
        val recordsAdapter = RecordsAdapter()

        progress_bar.visibility = View.GONE
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recordsAdapter
        }

        with(binding)
        {
            btnRecents.apply {
                setOnClickListener {
                    Log.d("_DEBUG", "Recents button has been clicked.")

                    viewModel.getRecents().observe(this@MainActivity, Observer { arrestRecords ->
                        Log.d(
                            "_DEBUG",
                            "There are " + arrestRecords.size + " records in the response."
                        )
                        recordsAdapter.updateList(arrestRecords)
                    })
                }
            }
        }

        btnRecords.apply {
            setOnClickListener {
                hideSoftKeyboard(this@MainActivity)
                //Log.d("_WORK", "EPIC FAIL!!")
                val location = etLocation.editableText
                val name = etName.editableText

                //val call = request.getRecords("az-mcso", "smith")
                val call = request.getRecords(location.toString(), name.toString())

                call.enqueue(object : Callback<JailHouse> {
                    //override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                    override fun onResponse(
                        call: Call<JailHouse>,
                        response: Response<JailHouse>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("_WORK", "${response.body()!!.records?.size}")

                            recordsAdapter.records = response.body()!!.records ?: emptyList()
                            recordsAdapter.notifyDataSetChanged()
                        }
                        Log.d("_WORK", "Did stuff")
                    }

                    override fun onFailure(call: Call<JailHouse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                        Log.d("_WORK", "EPIC FAIL!!")
                    }
                })
            }
        }
    }

//    private val viewModel: MainViewModel by lazy {
//        return@lazy when {
//            activity != null -> {
//                ViewModelProviders.of(activity as FragmentActivity).get(MainViewModel::class.java) // you can either pass activity object
//            }
//            else -> {
//                ViewModelProviders.of(this).get(MainViewModel::class.java) // or pass fragment object, both are not possible at same time.
//            }
//        }
//    }

    fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager: InputMethodManager = activity.getSystemService(
            INPUT_METHOD_SERVICE
        ) as InputMethodManager
        if (inputMethodManager.isAcceptingText) {
            inputMethodManager.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken, 0
            )
        }
    }
}