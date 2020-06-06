package com.kmm.mrfever.base

import android.content.Context

/**
 * Base view that must be implemented by any other view.
 */
interface BaseView {

    /**
     * Returns the application's Context.
     * @return Context
     */
    fun getContext(): Context

}
