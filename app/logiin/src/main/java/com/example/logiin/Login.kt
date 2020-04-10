package  com.example.logiin

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager


class Login : Fragment(), View.OnClickListener {
    lateinit var btnSignIn:Button
    lateinit var manager:FragmentManager

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
        btnSignIn.setOnClickListener(this)
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

        }
    }
}
