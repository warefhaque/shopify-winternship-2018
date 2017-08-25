package com.shopifywinternship.shopifymerchant;

import com.shopifywinternship.shopifymerchant.dagger.CustomScope;
import com.shopifywinternship.shopifymerchant.dagger.component.NetComponent;

import dagger.Component;

/**
 * This class is used to define Injection targets.In MainActivity for example, we can use @Inject
 * annotation to obtain references to Objects we have defined in the NetModule and MainModule.
 * Activities declared within the inject() methods are the only ones allowed to access these
 * Objects/Dependencies provided by the Main and Net Modules.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {
  void inject (MainActivity mainActivity);
}
