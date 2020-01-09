package com.example.thejumbo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.databinding.DataBindingUtil
import com.example.thejumbo.databinding.FragmentOrderCoffeeBinding


class OrderCoffeeFragment : Fragment() {

    private lateinit var orderCoffeeBinding: FragmentOrderCoffeeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        orderCoffeeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_coffee, container, false)
        return orderCoffeeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    val userName = orderCoffeeBinding.nameEditText.text.toString()
    val userEmail = orderCoffeeBinding.emailEditText.text.toString()


    private fun hasWhippedCream(): Boolean {
        return orderCoffeeBinding.whippedCreamCheckBox.isChecked
    }

    private fun hasChocolate(): Boolean {
        return orderCoffeeBinding.chocolateCheckBox.isChecked
    }

    private fun numberOfCoffee(): Int {
        var coffeeQuantity: Int = orderCoffeeBinding.quantityNumberTextView.text.toString().toInt()

    }

    private fun increaseCoffeeQuantity() {
        var coffeeQuantity = orderCoffeeBinding.quantityNumberTextView.text.toString().toInt()
        coffeeQuantity += 1
        if (coffeeQuantity > 99) {
            Toast.makeText(context,"Cannot place order more than 99",Toast.LENGTH_SHORT).show()
            orderCoffeeBinding.quantityNumberTextView.text = "99"
        }

    }
}
