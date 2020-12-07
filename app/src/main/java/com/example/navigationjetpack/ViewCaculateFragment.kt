package com.example.navigationjetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_view_caculate.*
import kotlinx.android.synthetic.main.fragment_view_caculate.view.*
import kotlinx.android.synthetic.main.fragment_view_suma.*
import java.math.BigDecimal

class ViewCaculateFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_caculate, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController =  Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btCalcular).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        try {
        var uno = et1.text.toString()
        var dos = et2.text.toString()
        var num1 = uno.toDouble()
        var num2 = dos.toDouble()
        var resultado:Double

        when(v!!.id){
            R.id.btCalcular -> {


                    if (rbSumar.isChecked) {
                        val bundle = Bundle()
                        resultado = num1 + num2
                        bundle.putDouble("suma", resultado)
                        navController!!.navigate(R.id.gotoSuma, bundle)

                    }
                    if (rbRestar.isChecked) {
                        val bundle = Bundle()
                        resultado = num1 - num2
                        bundle.putDouble("resta", resultado)
                        navController!!.navigate(R.id.gotoResta, bundle)

                    }
                    if (rbDividir.isChecked) {
                        val bundle = Bundle()
                        resultado = num1 / num2
                        bundle.putDouble("div", resultado)
                        navController!!.navigate(R.id.gotoDiv, bundle)
                    }
                }
            }
        }catch (n:NumberFormatException){
            Toast.makeText(context,"No dejes campos en blanco", Toast.LENGTH_LONG).show()
        }
    }

}