package com.yxf.saoifwiki.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "刀剑神域 关键斗士 Wiki" +
                "\n作者：秋林(Yansam)" +
                "\n图片来源：https://saoif.game-info.wiki/" +
                "\n项目地址：https://github.com/1ansam/SAOIF_WIKI_Beta"

    }
    val text: LiveData<String> = _text
}