package com.example.appselect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.appselect.api.ApiService
import com.example.appselect.paging.MoviesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel()
class MovieViewModel
@Inject constructor(private val apiService: ApiService): ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        MoviesPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

}