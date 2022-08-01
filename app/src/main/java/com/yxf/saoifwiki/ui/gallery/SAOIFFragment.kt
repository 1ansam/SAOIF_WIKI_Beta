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
import com.yxf.saoifwiki.R
import com.yxf.saoifwiki.databinding.FragmentGalleryBinding
import com.yxf.saoifwiki.ui.SAOIFRecyclerViewAdapter


class SAOIFFragment : Fragment() {
    val TAG = "SAOIFFragment"


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
        val key = args["key"]?.defaultValue.toString()

        when(key){
            //ability
            resources.getString(R.string.menu_ability_rush)-> saoifViewModel.url = "ability/rush"
            resources.getString(R.string.menu_ability_4) -> saoifViewModel.url = "ability/four_stars"
            resources.getString(R.string.menu_ability_3) -> saoifViewModel.url = "ability/three_stars"
            resources.getString(R.string.menu_ability_2) -> saoifViewModel.url = "ability/two_stars"
            resources.getString(R.string.menu_ability_1) -> saoifViewModel.url = "ability/one_star"

            //sword
            resources.getString(R.string.menu_sword_mod)-> saoifViewModel.url =      "sword/mod"
            resources.getString(R.string.menu_sword_rush) -> saoifViewModel.url =    "sword/rush"
            resources.getString(R.string.menu_sword_connect) -> saoifViewModel.url = "sword/connect"
            resources.getString(R.string.menu_sword_burst) -> saoifViewModel.url =   "sword/burst"
            resources.getString(R.string.menu_sword_4) -> saoifViewModel.url =     "sword/four_stars"
            resources.getString(R.string.menu_sword_3) -> saoifViewModel.url =     "sword/three_stars"
            resources.getString(R.string.menu_sword_2) -> saoifViewModel.url =     "sword/two_stars"
            resources.getString(R.string.menu_sword_1) -> saoifViewModel.url =     "sword/one_star"

            //rapier
            resources.getString(R.string.menu_rapier_mod)-> saoifViewModel.url =      "rapier/mod"
            resources.getString(R.string.menu_rapier_rush) -> saoifViewModel.url =    "rapier/rush"
            resources.getString(R.string.menu_rapier_connect) -> saoifViewModel.url = "rapier/connect"
            resources.getString(R.string.menu_rapier_burst) -> saoifViewModel.url =   "rapier/burst"
            resources.getString(R.string.menu_rapier_4) -> saoifViewModel.url =       "rapier/four_stars"
            resources.getString(R.string.menu_rapier_3) -> saoifViewModel.url =       "rapier/three_stars"
            resources.getString(R.string.menu_rapier_2) -> saoifViewModel.url =       "rapier/two_stars"
            resources.getString(R.string.menu_rapier_1) -> saoifViewModel.url =       "rapier/one_star"

            //club
            resources.getString(R.string.menu_club_mod)-> saoifViewModel.url =      "club/mod"
            resources.getString(R.string.menu_club_rush) -> saoifViewModel.url =    "club/rush"
            resources.getString(R.string.menu_club_connect) -> saoifViewModel.url = "club/connect"
            resources.getString(R.string.menu_club_burst) -> saoifViewModel.url =   "club/burst"
            resources.getString(R.string.menu_club_4) -> saoifViewModel.url =       "club/four_stars"
            resources.getString(R.string.menu_club_3) -> saoifViewModel.url =       "club/three_stars"
            resources.getString(R.string.menu_club_2) -> saoifViewModel.url =       "club/two_stars"
            resources.getString(R.string.menu_club_1) -> saoifViewModel.url =       "club/one_star"

            //dagger
            resources.getString(R.string.menu_dagger_mod)-> saoifViewModel.url =      "dagger/mod"
            resources.getString(R.string.menu_dagger_rush) -> saoifViewModel.url =    "dagger/rush"
            resources.getString(R.string.menu_dagger_connect) -> saoifViewModel.url = "dagger/connect"
            resources.getString(R.string.menu_dagger_burst) -> saoifViewModel.url =   "dagger/burst"
            resources.getString(R.string.menu_dagger_4) -> saoifViewModel.url =       "dagger/four_stars"
            resources.getString(R.string.menu_dagger_3) -> saoifViewModel.url =       "dagger/three_stars"
            resources.getString(R.string.menu_dagger_2) -> saoifViewModel.url =       "dagger/two_stars"
            resources.getString(R.string.menu_dagger_1) -> saoifViewModel.url =       "dagger/one_star"

            //shield
            resources.getString(R.string.menu_shield_mod)-> saoifViewModel.url =      "shield/mod"
            resources.getString(R.string.menu_shield_rush) -> saoifViewModel.url =    "shield/rush"
            resources.getString(R.string.menu_shield_connect) -> saoifViewModel.url = "shield/connect"
            resources.getString(R.string.menu_shield_burst) -> saoifViewModel.url =   "shield/burst"
            resources.getString(R.string.menu_shield_4) -> saoifViewModel.url =       "shield/four_stars"
            resources.getString(R.string.menu_shield_3) -> saoifViewModel.url =       "shield/three_stars"
            resources.getString(R.string.menu_shield_2) -> saoifViewModel.url =       "shield/two_stars"
            resources.getString(R.string.menu_shield_1) -> saoifViewModel.url =       "shield/one_star"

            //axe
            resources.getString(R.string.menu_axe_mod)-> saoifViewModel.url =      "axe/mod"
            resources.getString(R.string.menu_axe_rush) -> saoifViewModel.url =    "axe/rush"
            resources.getString(R.string.menu_axe_connect) -> saoifViewModel.url = "axe/connect"
            resources.getString(R.string.menu_axe_burst) -> saoifViewModel.url =   "axe/burst"
            resources.getString(R.string.menu_axe_4) -> saoifViewModel.url =       "axe/four_stars"
            resources.getString(R.string.menu_axe_3) -> saoifViewModel.url =       "axe/three_stars"
            resources.getString(R.string.menu_axe_2) -> saoifViewModel.url =       "axe/two_stars"
            resources.getString(R.string.menu_axe_1) -> saoifViewModel.url =       "axe/one_star"

            //bow
            resources.getString(R.string.menu_bow_mod)-> saoifViewModel.url =      "bow/mod"
            resources.getString(R.string.menu_bow_rush) -> saoifViewModel.url =    "bow/rush"
            resources.getString(R.string.menu_bow_connect) -> saoifViewModel.url = "bow/connect"
            resources.getString(R.string.menu_bow_burst) -> saoifViewModel.url =   "bow/burst"
            resources.getString(R.string.menu_bow_4) -> saoifViewModel.url =       "bow/four_stars"
            resources.getString(R.string.menu_bow_3) -> saoifViewModel.url =       "bow/three_stars"
            resources.getString(R.string.menu_bow_2) -> saoifViewModel.url =       "bow/two_stars"
            resources.getString(R.string.menu_bow_1) -> saoifViewModel.url =       "bow/one_star"

            //spear
            resources.getString(R.string.menu_spear_mod)-> saoifViewModel.url =      "spear/mod"
            resources.getString(R.string.menu_spear_rush) -> saoifViewModel.url =    "spear/rush"
            resources.getString(R.string.menu_spear_connect) -> saoifViewModel.url = "spear/connect"
            resources.getString(R.string.menu_spear_burst) -> saoifViewModel.url =   "spear/burst"
            resources.getString(R.string.menu_spear_4) -> saoifViewModel.url =       "spear/four_stars"
            resources.getString(R.string.menu_spear_3) -> saoifViewModel.url =       "spear/three_stars"
            resources.getString(R.string.menu_spear_2) -> saoifViewModel.url =       "spear/two_stars"
            resources.getString(R.string.menu_spear_1) -> saoifViewModel.url =       "spear/one_star"
        }
        Log.e(TAG, "key: $key", )
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