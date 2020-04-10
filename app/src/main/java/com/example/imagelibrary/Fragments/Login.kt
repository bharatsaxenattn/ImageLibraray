package  com.example.imagelibrary.Fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.imagelibrary.GalleryActivity
import com.example.imagelibrary.R


class Login : Fragment(), View.OnClickListener {
    lateinit var btnSignIn:Button
    lateinit var manager:FragmentManager
    lateinit var signUptxt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        manager= activity!!.supportFragmentManager
        val view:View=inflater.inflate(R.layout.fragment_login, container, false)
        btnSignIn=view.findViewById(R.id.btn_sign_in)
        signUptxt=view.findViewById(R.id.signupTxt)
        btnSignIn.setOnClickListener(this)
        signUptxt.setOnClickListener(this)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance():Login
        {
            var instance=Login()
            return instance
        }

    }

    override fun onClick(v: View?) {
        if(v?.id ==R.id.btn_sign_in)
        {
            val intent:Intent=Intent(activity,GalleryActivity::class.java)
            startActivity(intent)
        }
        if(v?.id ==R.id.signupTxt)
        {
            manager.beginTransaction().replace(R.id.main_screen,Signup.newInstance()).addToBackStack(null).commit()
        }
    }
}
