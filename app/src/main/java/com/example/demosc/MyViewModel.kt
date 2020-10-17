package com.example.demosc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class MyViewModel : ViewModel() {
    
    var product: MutableLiveData<MutableList<Product>> = MutableLiveData()

    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getModelData(): LiveData<MutableList<Product>> {
        val mutableData = MutableLiveData<MutableList<Product>>()
        FirebaseFirestore.getInstance().collection("Beer").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<Product>()
                for (document in result) {
                    val imageUrl = document.getString("image")
                    val title = document.getString("title")
                    val description = document.getString("description")

                    val modelBeer = Product(
                        imageUrl!!,
                        title!!,
                        description!!
                    )
                    listData.add(modelBeer)
                }
                mutableData.value = listData
            }
        return mutableData
    }

}
