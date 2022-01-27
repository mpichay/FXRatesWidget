package com.rates.model;

public class SellCurrencyParam {

	private Double amountToSell;
	private String sellToCurrency;

	public Double getAmountToSell() {
		return amountToSell;
	}

	public void setAmountToSell(Double amountToSell) {
		this.amountToSell = amountToSell;
	}

	public String getSellToCurrency() {
		return sellToCurrency;
	}

	public void setSellToCurrency(String sellToCurrency) {
		this.sellToCurrency = sellToCurrency;
	}
}
