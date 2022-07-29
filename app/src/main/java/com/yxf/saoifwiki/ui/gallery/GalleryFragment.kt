package com.yxf.saoifwiki.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader.PreloadModelProvider
import com.bumptech.glide.ListPreloader.PreloadSizeProvider
import com.bumptech.glide.util.FixedPreloadSizeProvider
import com.yxf.saoifwiki.MyApp
import com.yxf.saoifwiki.databinding.FragmentGalleryBinding
import com.yxf.saoifwiki.ui.SAOIFRecyclerViewAdapter


class GalleryFragment : Fragment() {
    val TAG = "GalleryFragment"


    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val saoifViewModel by viewModels<SAOIFViewModel> { SAOIFViewModelFactory((requireActivity().application as MyApp).saoifRepo) }

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val args = findNavController().graph.arguments
        args.forEach{
            Log.e(TAG, "map: ${it.key}+${it.value.defaultValue}", )
        }
        binding.rvSaoif.layoutManager = LinearLayoutManager(requireContext())
        val adapter = SAOIFRecyclerViewAdapter()
        binding.rvSaoif.adapter = adapter


        saoifViewModel.liveData.observe(viewLifecycleOwner){
            Log.e("TAG", "onCreateView: $it")
            adapter.data = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}