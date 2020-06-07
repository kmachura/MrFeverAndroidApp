package com.kmm.mrfever.base

import com.kmm.mrfever.di.component.DaggerPresenterInjector
import com.kmm.mrfever.di.component.PresenterInjector
import com.kmm.mrfever.di.module.ContextModule
import com.kmm.mrfever.views.children.AddChildPresenter

/**
 * Base presenter that must be implemented by any other presenter. Provides initial injections and required methods.
 * @param V the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @property injector The injector used to inject required dependencies
 * @constructor Injects the required dependencies
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is AddChildPresenter -> injector.inject(this)
        }
    }
}