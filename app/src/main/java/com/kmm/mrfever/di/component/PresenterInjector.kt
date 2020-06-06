package com.kmm.mrfever.di.component

import com.kmm.mrfever.base.BaseView
import com.kmm.mrfever.di.module.ContextModule
import com.kmm.mrfever.views.children.AddChildPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class)])
interface PresenterInjector {

    /**
     * Injects required dependencies into the specified Presenter.
     * @param addChildPresenter AddChildPresenter in which to inject the dependencies
     */
    fun inject(addChildPresenter: AddChildPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}