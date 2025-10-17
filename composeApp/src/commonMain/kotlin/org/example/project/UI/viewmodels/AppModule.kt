package org.example.project.UI.viewmodels


import org.example.project.data.getImagenesHome
import org.example.project.domain.classes.Arma
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module{

    singleOf(::ArmasScreenViewModel)


}