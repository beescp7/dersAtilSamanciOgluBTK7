package com.example.kullaniciadisaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var  sharedPreferences : SharedPreferences
    var alinanKullanici :String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //SharedPreferences
         sharedPreferences=this.getSharedPreferences("com.example.kullaniciadisaklama",
           Context.MODE_PRIVATE)
        alinanKullanici=sharedPreferences.getString("kullaniciAdi","")
        if(alinanKullanici!=null){
            textView.text="kaydedilen kullanici :${alinanKullanici}"
        }

    }
    fun kaydet(view: View){
     val kullaniciAdi=editText.text.toString()
      if(kullaniciAdi==""){
          Toast.makeText(this,"Lütfen bir deger giriniz",Toast.LENGTH_LONG).show()
      }
        else
      {
          sharedPreferences.edit().putString("kullaniciAdi",kullaniciAdi).apply()
          textView.text="Kaydedilen kullanıcı :${kullaniciAdi}"
      }
    }
    fun sil(view: View){
     alinanKullanici=sharedPreferences.getString("kullaniciAdi","")
        if(alinanKullanici!=null)
        {
            textView.text="Kaydedilen kullanıcı :"
            sharedPreferences.edit().remove("kullaniciAdi").apply()

        }
    }
}