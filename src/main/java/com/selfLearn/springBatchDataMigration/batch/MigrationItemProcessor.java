package com.selfLearn.springBatchDataMigration.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.selfLearn.springBatchDataMigration.model.MF_Entity;
import com.selfLearn.springBatchDataMigration.model.User;

@Component
public class MigrationItemProcessor implements ItemProcessor<MF_Entity,MF_Entity>{

	private static final Map<String,String> DEPT_NAMES = new HashMap<>();
	
	public MigrationItemProcessor() {
		DEPT_NAMES.put("1101", "Axis Mutual fund");
		DEPT_NAMES.put("002", "Operations");
		DEPT_NAMES.put("003", "Accounts");
	}
	
	@Override
	public MF_Entity process(MF_Entity item) throws Exception {
		String deptCode = ""; //item.getDept()
		String dept = DEPT_NAMES.get(deptCode);
		//item.setDept(dept);
		return null;
	}
	
	

}
