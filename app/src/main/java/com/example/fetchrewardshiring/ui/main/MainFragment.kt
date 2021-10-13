package com.example.fetchrewardshiring.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.Volley.newRequestQueue
import com.example.fetchrewardshiring.R
import org.json.JSONArray
import org.json.JSONObject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        val resultSet = async(requestJSON("https://fetch-hiring.s3.amazonaws.com/hiring.json"))
//        Log.d("Debug", resultSet.toString())
        // TODO: Use the ViewModel
    }

    private fun requestJSON(url: String): JSONArray {
        val queue = Volley.newRequestQueue(this.context)
        var result = JSONArray()

        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
//                textView.text = "Response: %s".format(response.toString())
                result = response
                Log.d("API", response.toString())
            },
            { error ->
                Log.d("API", "Error $error")
                Log.d("API", "Failed to retrieve JSON object from $url")
            }
        )
        // Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest)
        return result
    }

}