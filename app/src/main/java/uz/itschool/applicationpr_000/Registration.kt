package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {
    var pos:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        var sharedpreferences=getSharedPreferences("reg", MODE_PRIVATE)
        var edit=sharedpreferences.edit()
        var gson= Gson()
        var userList= mutableListOf<Users>()
        var type=object : TypeToken<List<Users>>(){}.type


        to_SignIn.setOnClickListener {
            var i=Intent(this, EnterPinCode::class.java)
            startActivity(i)
        }
        button_account.setOnClickListener{
            var users=sharedpreferences.getString("users","")
            var pos=false
            if(users==""){
                userList= mutableListOf()
                userList.add(Users(text_input_email.text.toString(),text_input_password.text.toString()/*,{0,0,0,0}*/))
                Toast.makeText(this, "Successfully registered",Toast.LENGTH_SHORT).show()
                val str=gson.toJson(userList)
                edit.putString("users", str).commit()
            }
            else{
                userList=gson.fromJson(users,type)
                for(i in userList){
                    if(i.email!=text_input_email.text.toString() && i.password!=text_input_password.text.toString()){
                        pos=true
                    }
                    else{
                        pos=false
                        break
                    }
                }

                if(pos==true){
                    userList.add(Users(text_input_email.text.toString(), text_input_password.text.toString()))
                    Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                    var str=gson.toJson(userList)
                    edit.putString("users", str).commit()
                    var intent= Intent(this, CreatePinCode::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Change inputs!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}