package com.example.demosc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demosc.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment() {

     private lateinit var myViewModel: MyViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
       val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title,container,false)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)


        val adapter = ProductAdapter()
        binding.recyclerView.adapter=adapter

         myViewModel.product.observe(viewLifecycleOwner, Observer {
                it?.let{
                    adapter.data=it
                    //вот тут что то другое на вход ждет....

                }

         })

        return binding.root
    }

}