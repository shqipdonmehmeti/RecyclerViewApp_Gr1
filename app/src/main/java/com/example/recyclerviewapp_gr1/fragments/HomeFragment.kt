package com.example.recyclerviewapp_gr1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp_gr1.adapters.UserAdapter
import com.example.recyclerviewapp_gr1.databinding.FragmentHomeBinding
import com.example.recyclerviewapp_gr1.helpers.Helpers
import com.example.recyclerviewapp_gr1.helpers.Helpers.provideRetrofitInstance
import com.example.recyclerviewapp_gr1.models.User
import com.example.recyclerviewapp_gr1.viewmodels.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getUsers()
        observeData()
    }

    private fun observeData() {
        viewModel.userList.observe(viewLifecycleOwner) { userList ->
            val userAdapter = UserAdapter(userList)
            binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
            binding.rvUser.adapter = userAdapter
        }

        viewModel.loading.observe(viewLifecycleOwner) {loadingValue ->
            if (loadingValue) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE

        }

    }
}