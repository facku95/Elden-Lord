package org.example.project.UI.viewmodels


import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
//import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModel

val appModule = module {
    singleOf(::ArmasScreenViewModel)
    singleOf(::CenizasScreenViewModel)
    singleOf(::ItemsScreenViewModel)
    singleOf(::JefesScreenViewModel)
    singleOf(::MagiasScreenViewModel)
    singleOf(::NPCScreenViewModel)
}