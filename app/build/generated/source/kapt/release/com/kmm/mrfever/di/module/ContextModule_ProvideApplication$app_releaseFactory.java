package com.kmm.mrfever.di.module;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
public final class ContextModule_ProvideApplication$app_releaseFactory implements Factory<Application> {
  private final Provider<Context> contextProvider;

  public ContextModule_ProvideApplication$app_releaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Application get() {
    return provideApplication$app_release(contextProvider.get());
  }

  public static ContextModule_ProvideApplication$app_releaseFactory create(
      Provider<Context> contextProvider) {
    return new ContextModule_ProvideApplication$app_releaseFactory(contextProvider);
  }

  public static Application provideApplication$app_release(Context context) {
    return Preconditions.checkNotNull(ContextModule.provideApplication$app_release(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
