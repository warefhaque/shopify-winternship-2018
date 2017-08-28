package com.shopifywinternship.shopifymerchant.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class for the each individual Order returned by the API.
 * Links to other models:
 * 1. List of LineItems
 * 2. A Customer object
 */
public class Order {

  @SerializedName("id")
  @Expose
  private Long id;
  @SerializedName("email")
  @Expose
  private String email;
  @SerializedName("closed_at")
  @Expose
  private Object closedAt;
  @SerializedName("created_at")
  @Expose
  private String createdAt;
  @SerializedName("updated_at")
  @Expose
  private String updatedAt;
  @SerializedName("number")
  @Expose
  private Integer number;
  @SerializedName("note")
  @Expose
  private Object note;
  @SerializedName("token")
  @Expose
  private String token;
  @SerializedName("gateway")
  @Expose
  private String gateway;
  @SerializedName("test")
  @Expose
  private Boolean test;
  @SerializedName("total_price")
  @Expose
  private String totalPrice;
  @SerializedName("subtotal_price")
  @Expose
  private String subtotalPrice;
  @SerializedName("total_weight")
  @Expose
  private Integer totalWeight;
  @SerializedName("total_tax")
  @Expose
  private String totalTax;
  @SerializedName("taxes_included")
  @Expose
  private Boolean taxesIncluded;
  @SerializedName("currency")
  @Expose
  private String currency;
  @SerializedName("financial_status")
  @Expose
  private String financialStatus;
  @SerializedName("confirmed")
  @Expose
  private Boolean confirmed;
  @SerializedName("total_discounts")
  @Expose
  private String totalDiscounts;
  @SerializedName("total_line_items_price")
  @Expose
  private String totalLineItemsPrice;
  @SerializedName("cart_token")
  @Expose
  private Object cartToken;
  @SerializedName("buyer_accepts_marketing")
  @Expose
  private Boolean buyerAcceptsMarketing;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("referring_site")
  @Expose
  private Object referringSite;
  @SerializedName("landing_site")
  @Expose
  private Object landingSite;
  @SerializedName("cancelled_at")
  @Expose
  private Object cancelledAt;
  @SerializedName("cancel_reason")
  @Expose
  private Object cancelReason;
  @SerializedName("total_price_usd")
  @Expose
  private String totalPriceUsd;
  @SerializedName("checkout_token")
  @Expose
  private Object checkoutToken;
  @SerializedName("reference")
  @Expose
  private Object reference;
  @SerializedName("user_id")
  @Expose
  private Integer userId;
  @SerializedName("location_id")
  @Expose
  private Object locationId;
  @SerializedName("source_identifier")
  @Expose
  private Object sourceIdentifier;
  @SerializedName("source_url")
  @Expose
  private Object sourceUrl;
  @SerializedName("processed_at")
  @Expose
  private String processedAt;
  @SerializedName("device_id")
  @Expose
  private Object deviceId;
  @SerializedName("phone")
  @Expose
  private Object phone;
  @SerializedName("customer_locale")
  @Expose
  private Object customerLocale;
  @SerializedName("app_id")
  @Expose
  private Integer appId;
  @SerializedName("browser_ip")
  @Expose
  private Object browserIp;
  @SerializedName("landing_site_ref")
  @Expose
  private Object landingSiteRef;
  @SerializedName("order_number")
  @Expose
  private Integer orderNumber;
  @SerializedName("discount_codes")
  @Expose
  private List<Object> discountCodes = null;
  @SerializedName("note_attributes")
  @Expose
  private List<Object> noteAttributes = null;
  @SerializedName("payment_gateway_names")
  @Expose
  private List<String> paymentGatewayNames = null;
  @SerializedName("processing_method")
  @Expose
  private String processingMethod;
  @SerializedName("checkout_id")
  @Expose
  private Object checkoutId;
  @SerializedName("source_name")
  @Expose
  private String sourceName;
  @SerializedName("fulfillment_status")
  @Expose
  private Object fulfillmentStatus;
  @SerializedName("tax_lines")
  @Expose
  private List<Object> taxLines = null;
  @SerializedName("tags")
  @Expose
  private String tags;
  @SerializedName("contact_email")
  @Expose
  private String contactEmail;
  @SerializedName("order_status_url")
  @Expose
  private Object orderStatusUrl;
  @SerializedName("line_items")
  @Expose
  private List<LineItem> lineItems;
  @SerializedName("shipping_lines")
  @Expose
  private List<Object> shippingLines;
  @SerializedName("billing_address")
  @Expose
  private Object billingAddress;
  @SerializedName("shipping_address")
  @Expose
  private Object shippingAddress;
  @SerializedName("fulfillments")
  @Expose
  private List<Object> fulfillments;
  @SerializedName("refunds")
  @Expose
  private List<Object> refunds;
  @SerializedName("customer")
  @Expose
  private Customer customer;

  public Customer getCustomer() {
    return customer;
  }

  public Order setCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }

  public List<LineItem> getLineItems() {
    return lineItems;
  }

  public Order setLineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Object getClosedAt() {
    return closedAt;
  }

  public void setClosedAt(Object closedAt) {
    this.closedAt = closedAt;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Object getNote() {
    return note;
  }

  public void setNote(Object note) {
    this.note = note;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getGateway() {
    return gateway;
  }

  public void setGateway(String gateway) {
    this.gateway = gateway;
  }

  public Boolean getTest() {
    return test;
  }

  public void setTest(Boolean test) {
    this.test = test;
  }

  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getSubtotalPrice() {
    return subtotalPrice;
  }

  public void setSubtotalPrice(String subtotalPrice) {
    this.subtotalPrice = subtotalPrice;
  }

  public Integer getTotalWeight() {
    return totalWeight;
  }

  public void setTotalWeight(Integer totalWeight) {
    this.totalWeight = totalWeight;
  }

  public String getTotalTax() {
    return totalTax;
  }

  public void setTotalTax(String totalTax) {
    this.totalTax = totalTax;
  }

  public Boolean getTaxesIncluded() {
    return taxesIncluded;
  }

  public void setTaxesIncluded(Boolean taxesIncluded) {
    this.taxesIncluded = taxesIncluded;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getFinancialStatus() {
    return financialStatus;
  }

  public void setFinancialStatus(String financialStatus) {
    this.financialStatus = financialStatus;
  }

  public Boolean getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(Boolean confirmed) {
    this.confirmed = confirmed;
  }

  public String getTotalDiscounts() {
    return totalDiscounts;
  }

  public void setTotalDiscounts(String totalDiscounts) {
    this.totalDiscounts = totalDiscounts;
  }

  public Double getTotalLineItemsPrice() {
    return (totalLineItemsPrice.isEmpty()) ? 0 : Double.valueOf(totalLineItemsPrice);
  }

  public void setTotalLineItemsPrice(String totalLineItemsPrice) {
    this.totalLineItemsPrice = totalLineItemsPrice;
  }

  public Object getCartToken() {
    return cartToken;
  }

  public void setCartToken(Object cartToken) {
    this.cartToken = cartToken;
  }

  public Boolean getBuyerAcceptsMarketing() {
    return buyerAcceptsMarketing;
  }

  public void setBuyerAcceptsMarketing(Boolean buyerAcceptsMarketing) {
    this.buyerAcceptsMarketing = buyerAcceptsMarketing;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getReferringSite() {
    return referringSite;
  }

  public void setReferringSite(Object referringSite) {
    this.referringSite = referringSite;
  }

  public Object getLandingSite() {
    return landingSite;
  }

  public void setLandingSite(Object landingSite) {
    this.landingSite = landingSite;
  }

  public Object getCancelledAt() {
    return cancelledAt;
  }

  public void setCancelledAt(Object cancelledAt) {
    this.cancelledAt = cancelledAt;
  }

  public Object getCancelReason() {
    return cancelReason;
  }

  public void setCancelReason(Object cancelReason) {
    this.cancelReason = cancelReason;
  }

  public String getTotalPriceUsd() {
    return totalPriceUsd;
  }

  public void setTotalPriceUsd(String totalPriceUsd) {
    this.totalPriceUsd = totalPriceUsd;
  }

  public Object getCheckoutToken() {
    return checkoutToken;
  }

  public void setCheckoutToken(Object checkoutToken) {
    this.checkoutToken = checkoutToken;
  }

  public Object getReference() {
    return reference;
  }

  public void setReference(Object reference) {
    this.reference = reference;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Object getLocationId() {
    return locationId;
  }

  public void setLocationId(Object locationId) {
    this.locationId = locationId;
  }

  public Object getSourceIdentifier() {
    return sourceIdentifier;
  }

  public void setSourceIdentifier(Object sourceIdentifier) {
    this.sourceIdentifier = sourceIdentifier;
  }

  public Object getSourceUrl() {
    return sourceUrl;
  }

  public void setSourceUrl(Object sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  public String getProcessedAt() {
    return processedAt;
  }

  public void setProcessedAt(String processedAt) {
    this.processedAt = processedAt;
  }

  public Object getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(Object deviceId) {
    this.deviceId = deviceId;
  }

  public Object getPhone() {
    return phone;
  }

  public void setPhone(Object phone) {
    this.phone = phone;
  }

  public Object getCustomerLocale() {
    return customerLocale;
  }

  public void setCustomerLocale(Object customerLocale) {
    this.customerLocale = customerLocale;
  }

  public Integer getAppId() {
    return appId;
  }

  public void setAppId(Integer appId) {
    this.appId = appId;
  }

  public Object getBrowserIp() {
    return browserIp;
  }

  public void setBrowserIp(Object browserIp) {
    this.browserIp = browserIp;
  }

  public Object getLandingSiteRef() {
    return landingSiteRef;
  }

  public void setLandingSiteRef(Object landingSiteRef) {
    this.landingSiteRef = landingSiteRef;
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public List<Object> getDiscountCodes() {
    return discountCodes;
  }

  public void setDiscountCodes(List<Object> discountCodes) {
    this.discountCodes = discountCodes;
  }

  public List<Object> getNoteAttributes() {
    return noteAttributes;
  }

  public void setNoteAttributes(List<Object> noteAttributes) {
    this.noteAttributes = noteAttributes;
  }

  public List<String> getPaymentGatewayNames() {
    return paymentGatewayNames;
  }

  public void setPaymentGatewayNames(List<String> paymentGatewayNames) {
    this.paymentGatewayNames = paymentGatewayNames;
  }

  public String getProcessingMethod() {
    return processingMethod;
  }

  public void setProcessingMethod(String processingMethod) {
    this.processingMethod = processingMethod;
  }

  public Object getCheckoutId() {
    return checkoutId;
  }

  public void setCheckoutId(Object checkoutId) {
    this.checkoutId = checkoutId;
  }

  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
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

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public Object getOrderStatusUrl() {
    return orderStatusUrl;
  }

  public void setOrderStatusUrl(Object orderStatusUrl) {
    this.orderStatusUrl = orderStatusUrl;
  }

}