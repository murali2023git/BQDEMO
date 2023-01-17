package com.example.bq.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bq.demo.model.CallData;
import com.example.bq.demo.service.BQService;

@RestController
public class BQController {
	
	@PostMapping("/save/call-data")  
	public String saveData(@RequestBody CallData callData) {
		System.out.print("saveData() >> calldata: "+callData);
		//analog-fiber-185910
		String datasetName = "test_2023";
	    String tableName = "CallData";
	    // Create a row to insert
	    Map<String, Object> rowContent = new HashMap<>();
	    rowContent.put("racfid", "ra2023");
	    rowContent.put("starttime", "3.14");
	    rowContent.put("endtime", "");
	    rowContent.put("calltype", "Balance");
	    BQService.tableInsertRows(datasetName, tableName, rowContent);
		return "Successfully saved data to GCP BigQuery";
	}
}
