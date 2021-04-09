package com.ugurcankaya.photoshare.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.ugurcankaya.photoshare.R
import kotlinx.android.synthetic.main.activity_main.*

class UserActivity : AppCompatActivity() {

    private  lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val  guncelKullanıcı = auth.currentUser
        if(guncelKullanıcı != null){
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun girisYap(view: View){
        auth.signInWithEmailAndPassword(emailText.text.toString(),passwordText.text.toString()).addOnCompleteListener { task ->
            
            if (task.isSuccessful){
                val guncelKullanici = auth.currentUser?.email.toString()
                Toast.makeText(this, "Hoşgeldin ${guncelKullanici} ", Toast.LENGTH_LONG).show()

                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }
            
        }.addOnFailureListener { exception ->
            Toast.makeText(this, exception.localizedMessage,Toast.LENGTH_LONG).show()
        }
        



    }

    fun kayitOl(view: View){

        val email = emailText.text.toString()
        val password = passwordText.text.toString()
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            //asenkron
            if(task.isSuccessful){
                //feedActivity ye gidelim
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()

            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()

        }



    }



}