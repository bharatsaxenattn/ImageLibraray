package  com.example.imagelibrary.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.imagelibrary.POJO.ProfileData
import com.example.imagelibrary.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Signup : Fragment(), View.OnClickListener {


lateinit var firebaseDatabase:FirebaseDatabase
    lateinit var mAuth:FirebaseAuth
    lateinit var reference:DatabaseReference
    lateinit var edtName:EditText
    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    lateinit var submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val  view=inflater.inflate(R.layout.fragment_signup, container, false)
        edtName=view.findViewById(R.id.edt_name)
        edtEmail=view.findViewById(R.id.edt_email)
        edtPassword=view.findViewById(R.id.edt_password)
        submit=view.findViewById(R.id.btn_sign_up)
        submit.setOnClickListener(this)
        // Inflate the layout for this fragment
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance():Signup
        {
            val instance=Signup()
            return instance
            }
    }

    override fun onClick(v: View?) {
        if(v?.id== R.id.btn_sign_up)
        {
            if(checkValidation())
            {

                firebaseDatabase= FirebaseDatabase.getInstance()
                reference=firebaseDatabase.reference.child("message")
                var name1=edtName.text.toString()
                var email=edtEmail.text.toString()
                var pass=edtPassword.text.toString()
                var data= ProfileData(name1,email,pass)
                var a= reference.setValue("hello world").exception
                Log.v("reference","reference"+a)
                Toast.makeText(activity,"Signup Sucessfully",Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun checkValidation():Boolean {
        if (edtName.text.length<3)
        {
            edtName.setError("please provide valide name")
            return false
        }

        else if (!checkEmail(edtEmail.text.toString()))
        {
            edtEmail.setError("please provide correct email")
            return false
        }
        else if (edtPassword.text.length<5)
        {
            edtPassword.setError("Please provide password of lengt greater than 5")
            return false
        }
        return true

    }

    private fun checkEmail(a: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(a).matches()

    }


}
