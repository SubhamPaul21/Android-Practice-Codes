package com.example.thejumbo


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_order_coffee.*


class OrderCoffeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_coffee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun hasWhippedCream(): Boolean {
            return whippedCreamCheckBox.isChecked
        }

        fun hasChocolate(): Boolean {
            return chocolateCheckBox.isChecked
        }

        fun numberOfCoffee(): Int {
            return quantityNumberTextView.text.toString().toInt()
        }

        fun increaseCoffeeQuantity() {
            var coffeeQuantityInt = numberOfCoffee()
            coffeeQuantityInt += 1
            if (coffeeQuantityInt > 99) {
                Toast.makeText(context, "Cannot place order more than 99", Toast.LENGTH_SHORT)
                    .show()
                quantityNumberTextView.text =
                    getString(R.string.max_coffee_quantity)
            } else {
                quantityNumberTextView.text = coffeeQuantityInt.toString()
            }
        }

        fun decreaseCoffeeQuantity() {
            var coffeeQuantityInt = numberOfCoffee()
            coffeeQuantityInt -= 1
            if (coffeeQuantityInt < 1) {
                Toast.makeText(context, "Cannot place order less than 1", Toast.LENGTH_SHORT).show()
                quantityNumberTextView.text =
                    getString(R.string.minimum_coffee_quantity)
            } else {
                quantityNumberTextView.text = coffeeQuantityInt.toString()
            }
        }

        fun orderSummary(): String {
            var basePrice = 10

            if (hasWhippedCream()) {
                basePrice += 5
            }

            if (hasChocolate()) {
                basePrice += 3
            }
            val totalPrice: Int = basePrice * numberOfCoffee()

            return "Name: ${nameEditText.text}\nEmail: ${emailEditText.text}\n" +
                    "Number of Coffee's Ordered: ${numberOfCoffee()}\nWhipped Cream: ${hasWhippedCream()}\n" +
                    "Chocolate: ${hasChocolate()}\nTotal Price: $totalPrice"
        }

        fun composeEmail(body: String) {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data =
                    Uri.parse("mailto:") // only email apps should handle this
                putExtra(Intent.EXTRA_SUBJECT, "Your Coffee Order from The Jumbo App")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailEditText.text.toString()))
                putExtra(Intent.EXTRA_TEXT, body)
            }

            if (emailIntent.resolveActivity(activity!!.packageManager) != null) {
                startActivity(emailIntent)
            }
        }

        plusButton.setOnClickListener {
            increaseCoffeeQuantity()
        }


        minusButton.setOnClickListener {
            decreaseCoffeeQuantity()
        }


        orderButton.setOnClickListener {
            if (emailEditText.text.isEmpty() or nameEditText.text.isEmpty()) {
                Toast.makeText(
                    context,
                    "Please provide the required details above",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                composeEmail(orderSummary())
            }
        }
    }
}
