package uz.itschool.applicationpr_000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_enter_pin_code.*

class CreatePinCode : AppCompatActivity() {
    var pos:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pin_code)
        var sharedpreferences=getSharedPreferences("reg", MODE_PRIVATE)
        var edit=sharedpreferences.edit()
        var gson= Gson()
        var userList= mutableListOf<Users>()
        var type=object : TypeToken<List<Users>>(){}.type

        check_pin_Code.setOnClickListener {
            var users=sharedpreferences.getString("users","")
            var pos=false
        }
    }
}