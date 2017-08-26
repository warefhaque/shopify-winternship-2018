package com.shopifywinternship.shopifymerchant;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import javax.inject.Inject;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Principle and only activity. Connects to the MainPresenter to process the data from the API
 * endpoint and display the total sales  to Napoleon and the total number of Bronze bags sold.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View{

  /**
   * Each @Inject calls the inject() method. This causes Dagger to locate the singletons in the
   * dependency graph to try to find a matching return type. If it finds one, it assigns the
   * references to the respective fields.
   */
  @Inject MainContract.Presenter mMainPresenter;
  @Inject IImageLoader mImageLoader;

  /**
   * Butterknife syntax for getting reference to views in main layout.
   */
  @BindView(R.id.image_merchant_logo) AvatarView imaageViewMerchantLogo;
  @BindView(R.id.text_view_merchant_name) TextView textViewMerchantName;
  @BindView(R.id.text_view_total_sale_fav_customer) TextView textViewTotalSaleFavCustomer;
  @BindView(R.id.text_view_total_bronze_bags) TextView textViewTotalBronzeBags;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setUpDagger();
    setupMerchanyInfo();
  }

  private void setupMerchanyInfo() {
    mImageLoader.loadImage(
        imaageViewMerchantLogo,
        (String) null,
        getString(R.string.merchant_name));
    textViewMerchantName.setText(getString(R.string.merchant_name));
  }

  /**
   * 1. Tells the MainComponent class about the NetModule and MainModule. This ensures that
   * annotating with @Inject will cause Dagger to search for matching dependencies in these classes
   * 2. Tells MainComponent to allow this activity to request dependencies from Net and Main Modules
   * by calling inject(this).
   */
  private void setUpDagger() {
    DaggerMainComponent.builder().netComponent(
        ((ShopifyMerchantApplication) getApplication())
            .getNetComponent())
        .mainModule(new MainModule(this))
        .build()
        .inject(this);
  }

  /**
   * Required by Calligraphy for the custom fonts used
   * @param newBase
   */
  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  /**
   * fetches the data from the API endpoint and processes it to compute
   * total sales and total bronze bags
   */
  @Override
  protected void onResume() {
    super.onResume();
    mMainPresenter.fetchOrders();
  }

  /**
   * Unsubscribes the subscriber int the Presenter to avoid memory leaks
   */
  @Override
  protected void onPause() {
    super.onPause();
    mMainPresenter.unsubscribe();
  }

  /**
   * @param itemQuantity total number of required items in list of orders
   */
  @Override
  public void showTotalQuantityForItem(int itemQuantity) {
    textViewTotalBronzeBags.setText(Integer.toString(itemQuantity));
  }

  /**
   * @param saleForCustomer total sales of required customer
   */
  @Override
  public void showTotalSalesForCustomer(double saleForCustomer) {
    textViewTotalSaleFavCustomer.setText(Double.toString(saleForCustomer));
  }

  /**
   * @param error - error when processing data or Fetching data from API enpoint
   */
  @Override
  public void showErrors(String error) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
  }
}
