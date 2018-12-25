package com.cq.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.bean.ResponseBean;
import com.cq.bean.InputData;
import com.hacka18.cosmosdb.bo.BatchDataBo;
import com.hacka18.cosmosdb.model.DateRange;
import com.hacka18.cosmosdb.model.VariationModel;

@RestController
@RequestMapping("/TestService")
public class TestService {

	// curl -i -X GET "http://ftdt044:8080/creditQuest/TestService/test"
	@RequestMapping("/test")
	public ResponseBean t1() {
		ResponseBean bean = new ResponseBean();
		bean.add("currentDate", new Date());
		return bean;
	}

	// curl -i -X GET "http://ftdt044:8080/creditQuest/TestService/"
	@RequestMapping("/")
	public ResponseBean t2() {
		ResponseBean bean = new ResponseBean();
		bean.add("Today's Date", new Date());
		return bean;
	}

	@RequestMapping(value = "/getAggregatedData", method = RequestMethod.POST)
	public ResponseBean getAggregatedData(@RequestBody InputData data) {
		ResponseBean bean = new ResponseBean();
 
		System.out.println("Calculating the trend for a " + data.getWeekNumber());
		BatchDataBo bo = new BatchDataBo();
		DateRange dateRange = bo.getDateRange(data.getWeekNumber());
		System.out.println("Week starting from " + dateRange.getFromDate() + " to " + dateRange.getToDate());
		List<VariationModel> mapAggregated = bo.getAggregatedOutput(dateRange);
		Double variation = bo.getVariation();
		bean.add("aggregatedData", mapAggregated);
		bean.add("variation", variation);

		return bean;
	}
}
