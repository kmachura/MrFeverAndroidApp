package com.kmm.mrfever.di.module;

import android.content.Context;
import com.kmm.mrfever.base.BaseView;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContextModule_ProvideContext$app_releaseFactory implements Factory<Context> {
  private final Provider<BaseView> baseViewProvider;

  public ContextModule_ProvideContext$app_releaseFactory(Provider<BaseView> baseViewProvider) {
    this.baseViewProvider = baseViewProvider;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        ContextModule.provideContext$app_release(baseViewProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ContextModule_ProvideContext$app_releaseFactory create(
      Provider<BaseView> baseViewProvider) {
    return new ContextModule_ProvideContext$app_releaseFactory(baseViewProvider);
  }

  public static Context proxyProvideContext$app_release(BaseView baseView) {
    return Preconditions.checkNotNull(
        ContextModule.provideContext$app_release(baseView),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
