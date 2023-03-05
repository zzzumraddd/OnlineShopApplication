package uz.itschool.applicationpr_000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.itschool.applicationpr_000.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name_p=intent.getStringExtra("name_p")
        val price_p=intent.getStringExtra("price_p")
        val info_p=intent.getStringExtra("info_p")
        val img_p=intent.getIntExtra("img_p",R.drawable.f10)
        binding.namePr.text=name_p
        binding.pricePr.text=price_p
        binding.circleImageView.setImageResource(img_p)

    }
}