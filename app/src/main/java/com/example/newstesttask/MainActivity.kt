package com.example.newstesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.newstesttask.R
import com.example.newstesttask.presentation.interfaces.ListNewsViewModel
import com.example.newstesttask.viewmodel.ListNewsViewModelFactory
import com.example.newstesttask.viewmodel.ListNewsViewModelImpl
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}