package com.example.profiledemo.ui.timeline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.profiledemo.R
import com.example.profiledemo.databinding.FragmentTimelineBinding
import com.example.profiledemo.databinding.TimelineListItemBinding

class TimelineFragment : Fragment() {
    private var _binding: FragmentTimelineBinding? = null
    private val binding: FragmentTimelineBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimelineBinding.inflate(inflater, container, false)
        constructTimelineList()
        return binding.root
    }

    private fun constructTimelineList() {
        val people = requireContext().resources.getStringArray(R.array.people)
        val quotes = requireContext().resources.getStringArray(R.array.quotes)
        val avatars = requireContext().resources.obtainTypedArray(R.array.avatars)
        val count = people.size

        repeat(count) { index ->
            val binding = TimelineListItemBinding.inflate(layoutInflater, binding.linearlayout, true)
            with(binding) {
                name.text = people[index]
                quote.text = quotes[index]
                avatar.setImageDrawable(avatars.getDrawable(index))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}