package org.example.project.UI.viewmodels


import org.example.project.network.EldenRingAPI
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
//import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf

val appModule = module {
    singleOf(::ArmasScreenViewModel)
    singleOf(::CenizasScreenViewModel)
    singleOf(::ItemsScreenViewModel)
    singleOf(::JefesScreenViewModel)
    singleOf(::MagiasScreenViewModel)
    singleOf(::NPCScreenViewModel)
    viewModelOf(::WeaponDetailViewModel)
    singleOf(::EldenRingAPI)
}