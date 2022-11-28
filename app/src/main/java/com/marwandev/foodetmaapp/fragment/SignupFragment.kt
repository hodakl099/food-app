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

class SignupFragment(val c: Context) : Fragment() {

    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobno: EditText
    lateinit var etAddress: EditText
    lateinit var etPass: EditText
    lateinit var etConpass: EditText
    lateinit var btnSignup: Button
    lateinit var prog: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_signup, container, false)

        etName = view.findViewById(R.id.signup_name)
        etEmail = view.findViewById(R.id.signup_email)
        etMobno = view.findViewById(R.id.signup_phno)
        etAddress = view.findViewById(R.id.signup_address)
        etPass = view.findViewById(R.id.signup_pass)
        etConpass = view.findViewById(R.id.signup_con_pass)
        btnSignup = view.findViewById(R.id.signup_sgn_btn)
        prog = view.findViewById(R.id.sign_prog)

        btnSignup.setOnClickListener(View.OnClickListener {
            regBtnClicked()
        })

        return view
    }

    fun registrySuccess() {
        openDashBoard()
    }

    private fun openDashBoard() {

        val intent = Intent(activity as Context, DashboardActivity::class.java)
        startActivity(intent)
        activity?.finish()

    }

    private fun regBtnClicked() {

        val sharedPreferences =
            c.getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)


        sharedPreferences.edit().putBoolean("user_logged_in", false).apply()
                prog.visibility = View.VISIBLE

                            if (etName.text.isNotEmpty() && etMobno.text.isNotEmpty() && etPass.text.isNotEmpty() && etAddress.text.isNotEmpty() && etAddress.text.isNotEmpty() && etEmail.text.isNotEmpty()) {


                                Toast.makeText(
                                    c,
                                    "Signed up as ${etName.text}",
                                    Toast.LENGTH_SHORT
                                ).show()

                                registrySuccess()


                            } else {
                                prog.visibility = View.INVISIBLE

                                val responseMessageServer = "Fields should not be empty"
                                Toast.makeText(
                                    c,
                                    responseMessageServer,
                                    Toast.LENGTH_SHORT
                                ).show()

                            }

    }


}