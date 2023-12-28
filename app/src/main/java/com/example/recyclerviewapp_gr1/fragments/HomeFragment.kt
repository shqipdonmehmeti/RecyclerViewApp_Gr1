package com.example.recyclerviewapp_gr1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp_gr1.adapters.UserAdapter
import com.example.recyclerviewapp_gr1.databinding.FragmentHomeBinding
import com.example.recyclerviewapp_gr1.helpers.Helpers
import com.example.recyclerviewapp_gr1.helpers.Helpers.provideRetrofitInstance
import com.example.recyclerviewapp_gr1.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

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

        provideRetrofitInstance().getUsers().enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                if (response.isSuccessful && response.body() != null) {
                    val userList = response.body()!!
                    val userAdapter = UserAdapter(userList)
                    binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
//                    binding.rvUser.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

                    binding.rvUser.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                Toast.makeText(requireContext(),"Call not being made",Toast.LENGTH_LONG).show()
            }
        })
    }
}