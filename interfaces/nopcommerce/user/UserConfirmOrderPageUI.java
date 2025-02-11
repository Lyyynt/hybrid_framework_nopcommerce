package nopcommerce.user;

public class UserConfirmOrderPageUI {
	public static final String DYNAMIC_QUANTITY_BY_PRODUCT_NAME = UserAbstractPageUI.DYNAMIC_PRODUCT_NAME_IN_TABLE + "/parent::td/following-sibling::td[@class='quantity']/span";
	public static final String DYNAMIC_SUBTOTAL_BY_PRODUCT_NAME = UserAbstractPageUI.DYNAMIC_PRODUCT_NAME_IN_TABLE + "/parent::td/following-sibling::td[@class='subtotal']/span";
	public static final String DYNAMIC_SKU_BY_PRODUCT_NAME = UserAbstractPageUI.DYNAMIC_PRODUCT_NAME_IN_TABLE + "/parent::td/preceding-sibling::td[@class='sku']/span";
	public static final String DYNAMIC_CART_TOTAL_ROW_BY_CLASS_NAME = "xpath=//table[@class='cart-total']/tbody/tr[@class='%s']//span[@class='value-summary']";
	public static final String CART_OPTION = "xpath=//div[@class='cart-options']/div";
	public static final String BILLING_ADDRESS_INFOR_BY_CLASS = "xpath=//div[@class='billing-info-wrap']//li[@class='%s']";
	public static final String SHIPPING_ADDRESS_INFOR_BY_CLASS = "xpath=//div[@class='shipping-info-wrap']//li[@class='%s']";
	public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']";
	public static final String ORDER_SUCCESS_TITLE_MESSAGE = ORDER_SUCCESS_MESSAGE + "/div[@class='title']";
	public static final String ORDER_NUMBER_TEXT = ORDER_SUCCESS_MESSAGE + "/div[@class='details']/div[@class='order-number']/strong";
}
