package com.kmm.mrfever.di.component;

import com.kmm.mrfever.base.BaseView;
import com.kmm.mrfever.di.module.ContextModule;
import com.kmm.mrfever.views.children.AddChildPresenter;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerPresenterInjector implements PresenterInjector {
  private DaggerPresenterInjector(Builder builder) {}

  public static PresenterInjector.Builder builder() {
    return new Builder();
  }

  @Override
  public void inject(AddChildPresenter addChildPresenter) {}

  private static final class Builder implements PresenterInjector.Builder {
    private BaseView baseView;

    @Override
    public PresenterInjector build() {
      if (baseView == null) {
        throw new IllegalStateException(BaseView.class.getCanonicalName() + " must be set");
      }
      return new DaggerPresenterInjector(this);
    }

    /**
     * This module is declared, but an instance is not used in the component. This method is a
     * no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Override
    public Builder contextModule(ContextModule contextModule) {
      return this;
    }

    @Override
    public Builder baseView(BaseView baseView) {
      this.baseView = Preconditions.checkNotNull(baseView);
      return this;
    }
  }
}
