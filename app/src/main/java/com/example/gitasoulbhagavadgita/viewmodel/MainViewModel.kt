package com.example.gitasoulbhagavadgita.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gitasoulbhagavadgita.models.ChaptersItem
import com.example.gitasoulbhagavadgita.repository.KrishnaRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    private val appRepository = KrishnaRepository()

    fun getAllChapter() : Flow<List<ChaptersItem>> = appRepository.getAllChapter()

}