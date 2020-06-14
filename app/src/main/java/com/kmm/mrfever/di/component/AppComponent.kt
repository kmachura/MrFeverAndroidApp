package com.kmm.mrfever.di.component

import com.kmm.mrfever.di.module.AppModule
import com.kmm.mrfever.di.module.PresentationModule
import com.kmm.mrfever.views.createaccount.CreateAccountActivity
import com.kmm.mrfever.views.index.IndexActivity
import com.kmm.mrfever.views.login.LoginActivity
import com.kmm.mrfever.views.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class, AppModule::class])
@Singleton
interface AppComponent {

   fun inject(target: MainActivity)

   fun inject(target: IndexActivity)

   fun inject(target: CreateAccountActivity)

   fun inject(target: LoginActivity)

}
