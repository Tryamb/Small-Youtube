package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.squareup.picasso.Picasso

class LoginScreen : AppCompatActivity() {

    //var signInBtn: TextView? = null

    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient : GoogleSignInClient
    //private val mSignOutBtn: TextView=findViewById(R.id.signInWithGoogle)
    private var user:FirebaseUser? = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        //signInBtn = findViewById(R.id.signInWithGoogle)
        if(user!=null)
        {
            displayUserDetails(user!!)

        }
        auth = FirebaseAuth.getInstance()
        //createRequest();

       val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this , gso)


        findViewById<TextView>(R.id.signInWithGoogle).setOnClickListener {
            signInGoogle()
        }
        findViewById<Button>(R.id.signOutBtn).setOnClickListener{
            signedOut()
        }
    }

   /* private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this , gso)
    }*/

    private fun signInGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK){

            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if (account != null){
                updateUI(account)
            }
        }else{
            Toast.makeText(this, task.exception.toString() , Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken , null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this, "Login Successful" , Toast.LENGTH_SHORT).show()
                val intent : Intent = Intent(this , MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun displayUserDetails(user: FirebaseUser) {

        findViewById<CardView>(R.id.signedOutUI).visibility=View.GONE
        findViewById<CardView>(R.id.signedInUI).visibility=View.VISIBLE

        Picasso.get().load(user.photoUrl).into(findViewById<ImageView>(R.id.avatar))
        findViewById<TextView>(R.id.email).text=user.email
        findViewById<TextView>(R.id.name).text=user.displayName

        }

    private fun signedOut()
    {
        findViewById<CardView>(R.id.signedOutUI).visibility=View.VISIBLE
        findViewById<CardView>(R.id.signedInUI).visibility=View.GONE
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(this, "You are Signed Out" , Toast.LENGTH_SHORT).show()
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val intent = Intent(this@LoginScreen, MainActivity::class.java)
        startActivity(intent)
    }






}