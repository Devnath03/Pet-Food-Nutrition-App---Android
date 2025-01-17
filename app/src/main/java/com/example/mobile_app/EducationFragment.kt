package com.example.mobile_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class EducationFragment : Fragment(R.layout.fragment_education) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Reference the ImageView in the fragment layout
        val goSignBtn = view.findViewById<ImageButton>(R.id.buttonImage1)

        goSignBtn.setOnClickListener {
            // Use requireActivity() to get the Context and start the activity
            val intent = Intent(requireActivity(), UserPanel::class.java)
            startActivity(intent)

            // Show a Toast message to prompt the user
            Toast.makeText(
                requireContext(),
                "Welcome To Educational Content , Here's Above content for u",
                Toast.LENGTH_SHORT
            ).show()
        }

        }
    }


