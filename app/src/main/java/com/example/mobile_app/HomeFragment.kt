package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Additional setup for your UI elements can go here

        val goUserupBtn = view.findViewById<ImageView>(R.id.imageView185)

        // Set up the delete button listener to navigate to Update Profile activity
        goUserupBtn.setOnClickListener {
            val intent = Intent(requireContext(), UpdateUserProfile::class.java)
            startActivity(intent)

            // Show message to view Go Admin Login
            Toast.makeText(requireContext(), "Welcome Here To Update Your profile", Toast.LENGTH_SHORT).show()
        }
        val goEDu1Btn = view.findViewById<Button>(R.id.ButtonHE)

        // Set up to go Educational Content
        goEDu1Btn.setOnClickListener {
            val intent = Intent(requireContext(), UserPanel::class.java)
            startActivity(intent)

            // Show message to view Go Educational Content
            Toast.makeText(requireContext(), "Welcome To Educational Content", Toast.LENGTH_SHORT).show()
        }
        val goEDu2Btn = view.findViewById<Button>(R.id.ButtonTT)

        // Set up to go Educational Content
        goEDu2Btn.setOnClickListener {
            val intent = Intent(requireContext(), UserPanel::class.java)
            startActivity(intent)

            // Show message to view Go Educational Content
            Toast.makeText(requireContext(), "Welcome To Educational Content", Toast.LENGTH_SHORT).show()
        }
        val goEDu3Btn = view.findViewById<Button>(R.id.ButtonHC)

        // Set up to go Educational Content
        goEDu3Btn.setOnClickListener {
            val intent = Intent(requireContext(), UserPanel::class.java)
            startActivity(intent)

            // Show message to view Go Educational Content
            Toast.makeText(requireContext(), "Welcome To Educational Content", Toast.LENGTH_SHORT).show()
        }
        val goEDu4Btn = view.findViewById<Button>(R.id.ButtonCG)

        // Set up to go Educational Content
        goEDu4Btn.setOnClickListener {
            val intent = Intent(requireContext(), UserPanel::class.java)
            startActivity(intent)

            // Show message to view Go Educational Content
            Toast.makeText(requireContext(), "Welcome To Educational Content", Toast.LENGTH_SHORT).show()
        }
    }
}