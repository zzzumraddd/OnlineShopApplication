package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import uz.itschool.applicationpr_000.databinding.ActivityDrinkProductsBinding
import uz.itschool.applicationpr_000.databinding.ActivityMainBinding

class DrinkProducts : AppCompatActivity() {
    private lateinit var binding:ActivityDrinkProductsBinding
    private lateinit var products_ArrayList:ArrayList<Products>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDrinkProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val imageId_list= intArrayOf(
            R.drawable.d14,
            R.drawable.d15,
            R.drawable.d16,
            R.drawable.d17,
            R.drawable.d18,
            R.drawable.d19,
            R.drawable.d2,
            R.drawable.d20,
            R.drawable.d21,
            R.drawable.d22,//10
            R.drawable.d25,
            R.drawable.d26,
            R.drawable.d27,
            R.drawable.d28,
            R.drawable.d3,//15
            R.drawable.d30,
            R.drawable.d33,
            R.drawable.d34,
            R.drawable.d9,
            R.drawable.d8,
            R.drawable.d6,
            R.drawable.d7,//17
        )

        val name_list= arrayOf(
            "Tea",
            "Tea",
            "Coffee",
            "Juice",
            "Juice",
            "Juice",
            "Coffee",
            "Tea",
            "Juice",
            "Coffee",//10
            "Juice",
            "Coffee",
            "Tea",
            "Juice",
            "Juice",
            "Juice",
            "Tea",
            )

        val price_list= arrayOf(
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",//10
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
            "$1",
        )
        val calorie_list= arrayOf(
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
            "100 Kcal",
        )
        val time_list= arrayOf(
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
            "5-10 Min",
        )
        val info_list= arrayOf(
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            "Water can help with reducing calorie.",
            )

        products_ArrayList=ArrayList()

        for(i in name_list.indices){
            val product_obj=Products(name_list[i],info_list[i],price_list[i],imageId_list[i],calorie_list[i], time_list[i])
            products_ArrayList.add(product_obj)
        }

        binding.listviewID.isClickable=true
        binding.listviewID.adapter=ClassAdapter_1(this,products_ArrayList)

        binding.listviewID.setOnItemClickListener { parent, view, position, id ->

            val name_p=name_list[position]
            val info_p=info_list[position]
            val price_p=price_list[position]
            val img_p=imageId_list[position]
            val calorie_p=calorie_list[position]
            val time_p=time_list[position]
            val intent=Intent(this, ProductActivity::class.java)
            intent.putExtra("name_p",name_p)
            intent.putExtra("info_p",info_p)
            intent.putExtra("price_p",price_p)
            intent.putExtra("img_p",img_p)
            intent.putExtra("calorie_p",calorie_p)
            intent.putExtra("time_p",time_p)
            startActivity(intent)
        }


        binding.search.addTextChangedListener {
            var filter= mutableListOf<Products>()
            if( it !=null){
                for(p in products_ArrayList){
                    if(p.name.toLowerCase().contains(it.toString().toLowerCase())){
                        filter.add(p)
                    }
                }
                var productAdapter=ClassAdapter_1(this, filter as ArrayList<Products>)
                binding.listviewID.adapter=productAdapter
            }
        }
    }
}