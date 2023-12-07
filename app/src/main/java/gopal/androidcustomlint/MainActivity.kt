package gopal.androidcustomlint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //To catch this error we can run Wrong Thread ( Interprocedural ) inspection
    @UiThread
    private fun UiThread(){
        foo1()
    }

    private fun foo1(){
        networkCall()
    }

    @WorkerThread
    private fun networkCall(){
        //Network
    }
}