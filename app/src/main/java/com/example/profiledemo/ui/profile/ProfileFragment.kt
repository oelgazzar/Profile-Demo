package com.example.profiledemo.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.profiledemo.R
import com.example.profiledemo.databinding.FragmentProfileBinding
import com.example.profiledemo.ui.content.ContentFragment
import com.example.profiledemo.ui.timeline.TimelineFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.skydoves.balloon.*

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val tabLayout = binding.tablayout
        binding.pager.adapter = ProfileFragmentStateAdapter(this)
        TabLayoutMediator(tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.title_timeline)
                1 -> tab.text = getString(R.string.contents)
            }
        }.attach()

        val editProfileBalloon = createBalloon("Edit your profile here!", ArrowOrientation.BOTTOM)
        binding.editProfile.setOnClickListener {
            editProfileBalloon.showAlignTop(it)
        }
        val contentsBalloon = createBalloon("You can add more contents!", ArrowOrientation.START)
        binding.contents.setOnClickListener {
            contentsBalloon.showAlignRight(it)
        }
        binding.contentsLabel.setOnClickListener {
            contentsBalloon.showAlignRight(it)
        }
        val profileBalloon = createCustomBalloon(ArrowOrientation.TOP)
        profileBalloon.getContentView().let {
            val nameTextView: TextView = it.findViewById(R.id.name)
            nameTextView.text = getString(R.string.demo_profile_name)
            val bioTextView: TextView = it.findViewById(R.id.quote)
            bioTextView.text = getString(R.string.bio)
            val imageView: ImageView = it.findViewById(R.id.avatar)
            imageView.setImageResource(R.drawable.me)
        }
        binding.avatar.setOnClickListener {
            profileBalloon.showAlignBottom(it)
        }

        return binding.root
    }

    private fun createBalloon(text: String, orientation: ArrowOrientation): Balloon {
        return Balloon.Builder(requireContext())
            .setText(text)
            .setTextColorResource(R.color.titleColor)
            .setTextSize(15f)
            .setIconDrawableResource(R.drawable.ic_edit)
            .setIconColor(ContextCompat.getColor(requireContext(), R.color.titleColor))
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowOrientation(orientation)
            .setArrowSize(10)
            .setArrowPosition(0.5f)
            .setPadding(12)
            .setCornerRadius(8f)
            .setBackgroundColorResource(R.color.secondaryColor)
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setLifecycleOwner(viewLifecycleOwner)
            .build()
    }

    private fun createCustomBalloon(orientation: ArrowOrientation): Balloon {
        return Balloon.Builder(requireContext())
            .setLayout(R.layout.timeline_list_item)
            .setTextColorResource(R.color.titleColor)
            .setTextSize(15f)
            .setIconDrawableResource(R.drawable.ic_edit)
            .setIconColor(ContextCompat.getColor(requireContext(), R.color.titleColor))
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowOrientation(orientation)
            .setArrowSize(10)
            .setArrowPosition(0.5f)
            .setPadding(12)
            .setCornerRadius(8f)
            .setBackgroundColorResource(android.R.color.background_dark)
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setLifecycleOwner(viewLifecycleOwner)
            .build()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ProfileFragmentStateAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TimelineFragment()
            else -> ContentFragment()
        }
    }
}