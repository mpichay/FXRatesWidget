package com.rates.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.rates.model.BuyCurrencyParam;
import com.rates.model.Result;
import com.rates.model.SellCurrencyParam;
import com.rates.util.Utility;

@Service
public class FXRatesWidgetServiceImpl implements FXRatesWidgetService {
	String currencyAPILink = "http://api.exchangeratesapi.io/v1/latest?access_key=bedaeb5994427ed9687872907e3c3aad";

	/**
	 * Only base is EUR, not supported by API
	 */
	@Override
	public JSONObject getCurrencyRates() {
		JSONObject currencyRates = new JSONObject();
		try {
			currencyRates = new JSONObject(Utility.readRESTAPI(currencyAPILink, null, "GET")).getJSONObject("rates");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currencyRates;
	}

	@Override
	public Result buyCurrency(BuyCurrencyParam param) {
		Result result = new Result();
		try {
			JSONObject currencyRates = getCurrencyRates();

			String buyCurrency = param.getBuyCurrency();
			Double eurAmount = param.getEurAmount();
			Double convertToAmount = currencyRates.getDouble(buyCurrency);

			Double resultAmount = eurAmount / 1 * convertToAmount;

			result.setAmountResult(resultAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result sellCurrency(SellCurrencyParam param) {
		Result result = new Result();
		try {
			JSONObject currencyRates = getCurrencyRates();
			String sellCurrencyTo = param.getSellToCurrency();
			Double eurToSell = param.getAmountToSell();
			Double convertToAmount = currencyRates.getDouble(sellCurrencyTo);

			Double resultAmount = eurToSell / 1 * convertToAmount;
			resultAmount = eurToSell / resultAmount;
			result.setAmountResult(resultAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
