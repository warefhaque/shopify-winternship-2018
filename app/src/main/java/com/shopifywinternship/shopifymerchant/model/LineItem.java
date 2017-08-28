package com.shopifywinternship.shopifymerchant.model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class for each individual item in each Order returned by the API
 */
public class LineItem {

  @SerializedName("id")
  @Expose
  private Long id;
  @SerializedName("variant_id")
  @Expose
  private Long variantId;
  @SerializedName("title")
  @Expose
  private String title;
  @SerializedName("quantity")
  @Expose
  private Integer quantity;
  @SerializedName("price")
  @Expose
  private String price;
  @SerializedName("grams")
  @Expose
  private Integer grams;
  @SerializedName("sku")
  @Expose
  private String sku;
  @SerializedName("variant_title")
  @Expose
  private String variantTitle;
  @SerializedName("vendor")
  @Expose
  private String vendor;
  @SerializedName("fulfillment_service")
  @Expose
  private String fulfillmentService;
  @SerializedName("product_id")
  @Expose
  private Long productId;
  @SerializedName("requires_shipping")
  @Expose
  private Boolean requiresShipping;
  @SerializedName("taxable")
  @Expose
  private Boolean taxable;
  @SerializedName("gift_card")
  @Expose
  private Boolean giftCard;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("variant_inventory_management")
  @Expose
  private Object variantInventoryManagement;
  @SerializedName("properties")
  @Expose
  private List<Object> properties = null;
  @SerializedName("product_exists")
  @Expose
  private Boolean productExists;
  @SerializedName("fulfillable_quantity")
  @Expose
  private Integer fulfillableQuantity;
  @SerializedName("total_discount")
  @Expose
  private String totalDiscount;
  @SerializedName("fulfillment_status")
  @Expose
  private Object fulfillmentStatus;
  @SerializedName("tax_lines")
  @Expose
  private List<Object> taxLines = null;

  public LineItem(String title, Integer quantity) {
    this.title = title;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getVariantId() {
    return variantId;
  }

  public void setVariantId(Long variantId) {
    this.variantId = variantId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return Double.valueOf(price);
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public Integer getGrams() {
    return grams;
  }

  public void setGrams(Integer grams) {
    this.grams = grams;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getVariantTitle() {
    return variantTitle;
  }

  public void setVariantTitle(String variantTitle) {
    this.variantTitle = variantTitle;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getFulfillmentService() {
    return fulfillmentService;
  }

  public void setFulfillmentService(String fulfillmentService) {
    this.fulfillmentService = fulfillmentService;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Boolean getRequiresShipping() {
    return requiresShipping;
  }

  public void setRequiresShipping(Boolean requiresShipping) {
    this.requiresShipping = requiresShipping;
  }

  public Boolean getTaxable() {
    return taxable;
  }

  public void setTaxable(Boolean taxable) {
    this.taxable = taxable;
  }

  public Boolean getGiftCard() {
    return giftCard;
  }

  public void setGiftCard(Boolean giftCard) {
    this.giftCard = giftCard;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getVariantInventoryManagement() {
    return variantInventoryManagement;
  }

  public void setVariantInventoryManagement(Object variantInventoryManagement) {
    this.variantInventoryManagement = variantInventoryManagement;
  }

  public List<Object> getProperties() {
    return properties;
  }

  public void setProperties(List<Object> properties) {
    this.properties = properties;
  }

  public Boolean getProductExists() {
    return productExists;
  }

  public void setProductExists(Boolean productExists) {
    this.productExists = productExists;
  }

  public Integer getFulfillableQuantity() {
    return fulfillableQuantity;
  }

  public void setFulfillableQuantity(Integer fulfillableQuantity) {
    this.fulfillableQuantity = fulfillableQuantity;
  }

  public String getTotalDiscount() {
    return totalDiscount;
  }

  public void setTotalDiscount(String totalDiscount) {
    this.totalDiscount = totalDiscount;
  }

  public Object getFulfillmentStatus() {
    return fulfillmentStatus;
  }

  public void setFulfillmentStatus(Object fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
  }

  public List<Object> getTaxLines() {
    return taxLines;
  }

  public void setTaxLines(List<Object> taxLines) {
    this.taxLines = taxLines;
  }

}
