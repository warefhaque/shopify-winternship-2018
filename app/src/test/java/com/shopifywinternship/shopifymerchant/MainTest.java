package com.shopifywinternship.shopifymerchant;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(RobolectricTestRunner.class)
public class MainTest {

  @Inject MainContract.Presenter mPresenter;
  @Inject MainContract.View mView;

  @Rule
  public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

  @Before
  public void setup () {
    DaggerMainTestComponent.builder()
        .mainTestModule(new MainTestModule(mock(MainContract.View.class)))
        .build()
        .inject(this);
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Tests the interaction between MainPresenter and MainActivity.
   */
  @Test
  public void MainTest() {
    mPresenter.fetchOrders("Napoleon","Batz","Awesome Bronze Bag");
    verify(mView).showTotalSalesForCustomer(1200);
    verify(mView).showTotalQuantityForItem(6);
  }
}
