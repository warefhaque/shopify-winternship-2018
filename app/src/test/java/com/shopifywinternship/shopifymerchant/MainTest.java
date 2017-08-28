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

/**
 * Created by warefhaque on 8/27/17.
 */

@RunWith(RobolectricTestRunner.class)
public class MainTest {

  @Inject MainContract.Presenter mPresenter;
  @Inject MainContract.View mView;
  @Captor ArgumentCaptor<Double> salesAmountCaptor;
  @Captor ArgumentCaptor<Integer> quantityCaptor;

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

  @Test
  public void MainTest() {
    mPresenter.fetchOrders();
    verify(mView).showTotalSalesForCustomer(500);
    verify(mView).showTotalQuantityForItem(4);
  }
}
