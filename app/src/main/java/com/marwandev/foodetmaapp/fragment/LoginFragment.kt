package com.marwandev.foodetmaapp.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.marwandev.foodetmaapp.R
import com.marwandev.foodetmaapp.activity.DashboardActivity
import com.marwandev.foodetmaapp.util.ConnectionManager

class LoginFragment(val c: Context) : Fragment() {

    lateinit var etMobno: EditText
    lateinit var etPass: EditText
    lateinit var tvForPass: TextView
    lateinit var btnLogin: Button
    lateinit var prog: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        etMobno = view.findViewById(R.id.login_phno)
        etPass = view.findViewById(R.id.login_pass)
        tvForPass = view.findViewById(R.id.login_forgot)
        btnLogin = view.findViewById(R.id.login_lgnbtn)
        prog = view.findViewById(R.id.log_prog)


        tvForPass.setOnClickListener {
            openForgotFragment()
        }


        btnLogin.setOnClickListener {

            if (etMobno.text.isBlank()) {
                etMobno.error = "Missing!"
            } else {
                if (etPass.text.isBlank()) {
                    etPass.error = "Missing!"
                } else {
                    prog.visibility = View.VISIBLE

                    logBtnClicked()
                }
            }

        }
        return view
    }


    private fun openForgotFragment() {
        val transaction = fragmentManager?.beginTransaction()

        transaction?.replace(
            R.id.start_frame,
            ForgotFragment(c)
        )
        transaction?.commit()

    }


    private fun logBtnClicked() {
        if (ConnectionManager().checkConnectivity(activity as Context)) {

                        if (etMobno.text.isNotEmpty() && etPass.text.isNotEmpty()) {
                            userSuccessfullyLoggedIn()
                        } else {

                            prog.visibility = View.INVISIBLE

                            val responseMessageServer = "email and password should not be empty "
                            Toast.makeText(
                                c,
                                responseMessageServer.toString(),
                                Toast.LENGTH_SHORT
                            ).show()

                        }
        }

    }

    fun userSuccessfullyLoggedIn() {
        val intent = Intent(activity as Context, DashboardActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

}
