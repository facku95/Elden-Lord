package org.example.project.UI.viewmodels


import org.koin.dsl.module
//import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModel

val appModule = module {
    viewModel { ArmasScreenViewModel() }
}