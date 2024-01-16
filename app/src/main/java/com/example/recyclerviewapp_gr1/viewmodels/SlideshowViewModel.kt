package com.example.recyclerviewapp_gr1.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {
    val name : MutableLiveData<String> = MutableLiveData("Filan Fisteku")
}