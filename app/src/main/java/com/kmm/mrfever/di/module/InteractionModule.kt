package com.kmm.mrfever.di.module

import com.kmm.mrfever.firebase.authentication.FirebaseAuthenticationInterface
import com.kmm.mrfever.firebase.authentication.FirebaseAuthenticationManager
import com.kmm.mrfever.firebase.database.FirebaseDatabaseInterface
import com.kmm.mrfever.firebase.database.FirebaseDatabaseManager
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [FirebaseModule::class])
abstract class InteractionModule {

    @Binds
    abstract fun authentication(authentication: FirebaseAuthenticationManager): FirebaseAuthenticationInterface

    @Binds
    abstract fun database(database: FirebaseDatabaseManager): FirebaseDatabaseInterface
}