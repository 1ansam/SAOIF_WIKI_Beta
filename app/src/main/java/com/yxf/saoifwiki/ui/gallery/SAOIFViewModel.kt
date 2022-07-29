package com.yxf.saoifwiki.ui.gallery

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.yxf.saoifwiki.MyApp
import com.yxf.saoifwiki.bean.ImageInfoBean
import com.yxf.saoifwiki.repo.SAOIFRepo
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SAOIFViewModel(val repo : SAOIFRepo) : ViewModel() {
    var url = ""

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
    val liveData = flow<List<ImageInfoBean>> {
        Log.e("SAOIFViewModel", url, )
        emit(repo.getBeanList(url))
    }.asLiveData()

}

class SAOIFViewModelFactory(val repo: SAOIFRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SAOIFViewModel(repo) as T
    }
}

