package com.FrogDomo.View.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.FrogDomo.R
import com.FrogDomo.Model.LoginUser
import com.FrogDomo.Repository.UserRepository
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContentView(R.layout.activity_login)

        val buttonSeConnecter = findViewById<Button>(R.id.bt_SeConnecter)
        val buttonCreationCompte = findViewById<Button>(R.id.bt_CreationCompte)

        val inputEmail = findViewById<TextInputEditText>(R.id.textInputChgMdp)
        val inputPassword = findViewById<TextInputEditText>(R.id.textInputChgConMdp)

        val inputLayoutUsernameEmail = findViewById<TextInputLayout>(R.id.TinputLayoutUserNameEmail)
        val inputLayoutPassword = findViewById<TextInputLayout>(R.id.textInputLayoutChgConMdp)

        //for dev
        val userResponseCreate=loginViewModel.loginUser(LoginUser("aze@gmail.com","Azerty123?"))

        userResponseCreate.observe(this) { user->
            if(user.email!="" && user.username!=""){
                UserRepository.setUserLogin(user)
                finish()
            }
            else{
                Toast.makeText(this,"email ou password faux",Toast.LENGTH_LONG).show()
            }
        }

        buttonSeConnecter.setOnClickListener {

            if (inputEmail.text.toString().isEmpty()) {
                inputLayoutUsernameEmail.error = "le username/Email ne peut pas etre vide"
            } else {
                inputLayoutUsernameEmail.error = null // Effacez l'erreur si le champ est valide
            }

            if (inputPassword.text.toString().isEmpty()) {
                inputLayoutPassword.error = "le mdp  ne peut pas etre vide"
            } else {
                inputLayoutPassword.error = null // Effacez l'erreur si le champ est valide
            }

            if(inputEmail.text.toString().isNotEmpty() && inputPassword.text.toString().isNotEmpty()){
                val loginUser= LoginUser(inputEmail.text.toString(),inputPassword.text.toString())

                val userResponseCreate=loginViewModel.loginUser(loginUser)

                userResponseCreate.observe(this) { user->
                    if(user.email!="" && user.username!=""){
                        UserRepository.setUserLogin(user)
                        finish()
                    }
                    else{
                        Toast.makeText(this,"email ou password faux",Toast.LENGTH_LONG).show()
                    }
                }
            }


        }
//        buttonCreationCompte.setOnClickListener {
//            val changePage = Intent(this, CreateUserActivity::class.java)
//            startActivity(changePage)
//        }
        /*
        val Api = ApiClient.getApiService
        CoroutineScope(Dispatchers.IO).launch {
            val response = Api.getCities()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        Log.i("Test", response.body().toString())
                    } else {
                        Log.i("Test", "Fail")
                    }
                } catch (e: HttpException) {
                    Log.i("Test", "HttpException")
                } catch (e: Throwable) {
                    Log.i("Test", "Ooops: Something else went wrong")
                }
            }
        }*/
    }
}