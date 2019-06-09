package com.bravedroid.courify

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.bravedroid.courify.add.ItemListDialogFragment
import com.bravedroid.courify.splash.SplashScreenFragment

class MainActivity : AppCompatActivity(),
        SplashScreenFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener,
        ItemListDialogFragment.Listener {

    override fun onItemClicked(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
