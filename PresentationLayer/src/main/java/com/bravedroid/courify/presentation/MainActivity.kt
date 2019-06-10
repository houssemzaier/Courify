package com.bravedroid.courify.presentation

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.courify.presentation.add.ItemListDialogFragment
import com.bravedroid.courify.presentation.splash.SplashScreenFragment

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
