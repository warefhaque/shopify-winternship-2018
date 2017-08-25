package com.shopifywinternship.shopifymerchant;

import android.content.Context;
import android.os.Bundle;
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
 * Created by warefhaque on 8/23/17.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View{

  @Inject MainContract.Presenter mMainPresenter;
  @Inject IImageLoader mImageLoader;

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

  private void setUpDagger() {
    DaggerMainComponent.builder().netComponent(
        ((ShopifyMerchantApplication) getApplication())
            .getNetComponent())
        .mainModule(new MainModule(this))
        .build()
        .inject(this);
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  @Override
  protected void onResume() {
    super.onResume();
    mMainPresenter.fetchOrders();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mMainPresenter.unsubscribe();
  }

  @Override
  public void showTotals(MainPresenter.CombinedResults combinedResults) {
    textViewTotalSaleFavCustomer.setText(
        Double.toString(combinedResults.totalSalesFromFavouriteCustomer));
    textViewTotalBronzeBags.setText(Integer.toString(combinedResults.totalBronzeBags));
  }

  @Override
  public void showErrors(String error) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
  }
}
