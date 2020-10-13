package com.example.pokeapi.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment : Fragment() {

    private val viewModel by lazy { bindViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(bindLayout(), container, false)
        return view
    }

    abstract fun bindViewModel() : ViewModel

    abstract fun injectComponent()

    @LayoutRes
    abstract fun bindLayout(): Int
}