package com.yxf.saoifwiki.ui

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.SizeReadyCallback
import com.yxf.saoifwiki.BASEURL
import com.yxf.saoifwiki.R
import com.yxf.saoifwiki.bean.ImageInfoBean
import com.yxf.saoifwiki.databinding.SaoifRecyclerViewItemBinding
import com.yxf.vehicleinspection.base.BaseRvAdapter
import com.yxf.vehicleinspection.base.BaseRvViewHolder
import java.util.*

/**
 *   author:yxf
 *   time:2022/7/29
 */
class SAOIFRecyclerViewAdapter(val glide : RequestManager) : BaseRvAdapter<ImageInfoBean, SaoifRecyclerViewItemBinding>(),
    ListPreloader.PreloadModelProvider<ImageInfoBean>,
    ListPreloader.PreloadSizeProvider<ImageInfoBean>
{

    val imageWidthPixel = 1024
    val imageHeightPixel = 768
    var stolenSize : IntArray? = null
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

        val url = "$BASEURL${bean.url.replaceFirst(".","").replace("\\","/")}"
        Log.e("TAG", "onBindViewHolder: $url" )
        val target = glide.load(url).thumbnail(0.3f).into(holder.binding.imageItem)
        target.getSize { width, height ->
            if (stolenSize == null) {
                if (0 < width && 0 < height) {
                    stolenSize = intArrayOf(width, height)
                }
            }
        }


//        Glide.with(holder.itemView.context)
//            .load(url)
//            .thumbnail(0.5f)
//            .into(binding.imageItem)
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getPreloadItems(position: Int): MutableList<ImageInfoBean> {
        return data
    }

    override fun getPreloadRequestBuilder(item: ImageInfoBean): RequestBuilder<*>? {
        val url = "$BASEURL${item.url.replaceFirst(".","").replace("\\","/")}"
        return glide.load(url)
    }

    override fun getPreloadSize(
        item: ImageInfoBean,
        adapterPosition: Int,
        perItemPosition: Int,
    ): IntArray? {
        return stolenSize
    }
}