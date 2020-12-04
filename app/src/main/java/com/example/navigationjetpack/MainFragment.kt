package com.example.navigationjetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener{
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController =Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btBrowser).setOnClickListener(this)
        view.findViewById<Button>(R.id.btCamera).setOnClickListener(this)
        view.findViewById<Button>(R.id.btCalculo).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btBrowser -> navController!!.navigate(R.id.gotoBrowser)
            R.id.btCamera -> navController!!.navigate(R.id.gotoCamera)
            R.id.btCalculo -> navController!!.navigate(R.id.gotoCalculo)

        }
    }

}