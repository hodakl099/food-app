package com.marwandev.foodetmaapp.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.marwandev.foodetmaapp.R
import com.marwandev.foodetmaapp.activity.MainActivity

class ProfileFragment(val c: Context) : Fragment() {

    lateinit var textViewName: TextView
    lateinit var textViewEmail: TextView
    lateinit var textViewMobileNumber: TextView
    lateinit var textViewAddress: TextView
    lateinit var btnLogOut: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)


        textViewName = view.findViewById(R.id.textViewName)
        textViewEmail = view.findViewById(R.id.textViewEmail)
        textViewMobileNumber = view.findViewById(R.id.textViewMobileNumber)
        textViewAddress = view.findViewById(R.id.textViewAddress)
        btnLogOut = view.findViewById(R.id.pro_button_logout)

        val sharedPreferences =
            c.getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)

        textViewEmail.text = "mrwan123321@gmail.com"
        textViewMobileNumber.text = "+60-1162032948"
        textViewAddress.text = "Damansara"

        btnLogOut.setOnClickListener {
            val alterDialog = androidx.appcompat.app.AlertDialog.Builder(activity as Context)

            alterDialog.setTitle("Alert!")
            alterDialog.setMessage("Are you sure you want to log out?")
            alterDialog.setPositiveButton("Yes") { text, listener ->
                sharedPreferences.edit().putBoolean("user_logged_in", false).apply()

                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }

            alterDialog.setNegativeButton("No") { text, listener ->

            }
            alterDialog.create()
            alterDialog.show()
        }

        return view
    }
}