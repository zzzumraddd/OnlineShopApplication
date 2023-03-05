package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose_card_view.*

class Choose_card_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_card_view)

        id_drink_card.setOnClickListener {
            var i=Intent(this, DrinkProducts::class.java)
            startActivity(i)
        }
        id_meal_card.setOnClickListener {
            var i=Intent(this, MealProducts::class.java)
            startActivity(i)
        }
        id_sweet_card.setOnClickListener {
            var i=Intent(this, SweetProducts::class.java)
            startActivity(i)
        }
    }
}