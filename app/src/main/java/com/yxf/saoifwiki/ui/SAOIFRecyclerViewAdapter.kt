package com.yxf.saoifwiki.ui

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yxf.saoifwiki.BASEURL
import com.yxf.saoifwiki.R
import com.yxf.saoifwiki.bean.ImageInfoBean
import com.yxf.saoifwiki.databinding.SaoifRecyclerViewItemBinding
import com.yxf.vehicleinspection.base.BaseRvAdapter
import com.yxf.vehicleinspection.base.BaseRvViewHolder

/**
 *   author:yxf
 *   time:2022/7/29
 */
class SAOIFRecyclerViewAdapter : BaseRvAdapter<ImageInfoBean, SaoifRecyclerViewItemBinding>() {

    val imageWidthPixel = 1024
    val imageHeightPixel = 768
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseRvViewHolder<SaoifRecyclerViewItemBinding> {
        return BaseRvViewHolder(SaoifRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(
        holder: BaseRvViewHolder<SaoifRecyclerViewItemBinding>,
        position: Int,
        binding: SaoifRecyclerViewItemBinding,
        bean: ImageInfoBean,
    ) {
        val url = "$BASEURL${bean.url.replaceFirst(".","")}"
        Log.e("TAG", "onBindViewHolder: $url" )
        Glide.with(holder.itemView.context)
            .load(url)
            .into(binding.imageItem)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}