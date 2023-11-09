package com.example.healthybudy

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tools.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tools : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view_tools: View = inflater.inflate(R.layout.fragment_tools, container, false)
        val view_kal: View = inflater.inflate(R.layout.activity_kalkulator, container, false)
        val view_bmi: View = inflater.inflate(R.layout.activity_bmi, container, false)
        val view_konvUang: View = inflater.inflate(R.layout.activity_konversi_uang, container, false)
        val view_konvSuhu: View = inflater.inflate(R.layout.activity_konversi_suhu, container, false)

        val button_kalkulator = view_tools.findViewById<Button>(R.id.button_kalkulator)
        val button_bmi = view_tools.findViewById<Button>(R.id.button_bmi)
        val button_konvuang = view_tools.findViewById<Button>(R.id.button_KonversiUang)
        val button_konvsuhu = view_tools.findViewById<Button>(R.id.button_KonversiSuhu)
        val button_aja = view_tools.findViewById<Button>(R.id.button_buoy)

        button_kalkulator.setOnClickListener {
            val intent = Intent(activity, kalkulator::class.java)
            startActivity(intent)
        }
        button_bmi.setOnClickListener {
            val intent = Intent(activity, bmi::class.java)
            startActivity(intent)
        }
        button_konvuang.setOnClickListener {
            val intent = Intent(activity, konversi_uang::class.java)
            startActivity(intent)
        }
        button_konvsuhu.setOnClickListener {
            val intent = Intent(activity, konversi_suhu::class.java)
            startActivity(intent)
        }
        button_aja.setOnClickListener {
            val intent = Intent(activity, start_page::class.java)
            startActivity(intent)
        }

        return view_tools

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tools.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tools().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}