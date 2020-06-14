package com.kmm.mrfever.di.module

import com.kmm.mrfever.views.createaccount.CreateAccountPresenter
import com.kmm.mrfever.views.createaccount.CreateAccountPresenterImpl
import com.kmm.mrfever.views.index.IndexPresenter
import com.kmm.mrfever.views.index.IndexPresenterImpl
import com.kmm.mrfever.views.login.LoginPresenter
import com.kmm.mrfever.views.login.LoginPresenterImpl
import com.kmm.mrfever.views.main.MainPresenter
import com.kmm.mrfever.views.main.MainPresenterImpl
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module(includes = [InteractionModule::class])
class PresentationModule {

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter = MainPresenterImpl()

    @Provides
    @Singleton
    fun provideIndexPresenter(): IndexPresenter = IndexPresenterImpl()

    @Provides
    @Singleton
    fun provideCreateAccountPresenter(): CreateAccountPresenter = CreateAccountPresenterImpl()

    @Provides
    @Singleton
    fun provideLoginPresenter(): LoginPresenter = LoginPresenterImpl()

}
