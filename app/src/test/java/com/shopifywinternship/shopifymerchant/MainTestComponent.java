package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.dagger.CustomScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by warefhaque on 8/27/17.
 */

@Singleton
@Component(modules = {MainTestModule.class })
public interface MainTestComponent {
  void inject(MainTest mainTest);
}
