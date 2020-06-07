package com.kmm.mrfever.di.component;

import com.kmm.mrfever.base.BaseView;
import com.kmm.mrfever.di.module.ContextModule;
import com.kmm.mrfever.views.children.AddChildPresenter;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
public final class DaggerPresenterInjector implements PresenterInjector {
  private DaggerPresenterInjector(BaseView baseView) {

  }

  public static PresenterInjector.Builder builder() {
    return new Builder();
  }

  @Override
  public void inject(AddChildPresenter addChildPresenter) {
  }

  private static final class Builder implements PresenterInjector.Builder {
    private BaseView baseView;

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Override
    @Deprecated
    public Builder contextModule(ContextModule contextModule) {
      Preconditions.checkNotNull(contextModule);
      return this;
    }

    @Override
    public Builder baseView(BaseView baseView) {
      this.baseView = Preconditions.checkNotNull(baseView);
      return this;
    }

    @Override
    public PresenterInjector build() {
      Preconditions.checkBuilderRequirement(baseView, BaseView.class);
      return new DaggerPresenterInjector(baseView);
    }
  }
}
