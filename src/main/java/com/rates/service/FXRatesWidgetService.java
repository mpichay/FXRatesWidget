package com.rates.service;

import org.json.JSONObject;

import com.rates.model.BuyCurrencyParam;
import com.rates.model.Result;
import com.rates.model.SellCurrencyParam;

public interface FXRatesWidgetService {

	JSONObject getCurrencyRates();

	Result buyCurrency(BuyCurrencyParam param);

	Result sellCurrency(SellCurrencyParam param);

}
