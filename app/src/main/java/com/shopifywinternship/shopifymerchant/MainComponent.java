package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.dagger.CustomScope;
import com.shopifywinternship.shopifymerchant.dagger.component.NetComponent;

import dagger.Component;

/**
 * Created by warefhaque on 8/23/17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {
  void inject (MainActivity mainActivity);
}
