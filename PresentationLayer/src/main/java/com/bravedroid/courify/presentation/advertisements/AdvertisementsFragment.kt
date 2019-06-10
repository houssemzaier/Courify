package com.bravedroid.courify.presentation.advertisements

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bravedroid.courify.presentation.R


class AdvertisementsFragment : Fragment() {

    companion object {
        fun newInstance() = AdvertisementsFragment()
    }

    private lateinit var viewModel: AdvertisementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_advertisement, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdvertisementsViewModel::class.java)
    }

}
