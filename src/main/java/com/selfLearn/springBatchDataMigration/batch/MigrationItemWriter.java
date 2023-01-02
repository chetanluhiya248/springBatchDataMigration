package com.selfLearn.springBatchDataMigration.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.selfLearn.springBatchDataMigration.model.MF_Entity;
import com.selfLearn.springBatchDataMigration.model.User;

@Component
public class MigrationItemWriter implements ItemWriter<MF_Entity> {

	@Override
	public void write(Chunk<? extends MF_Entity> chunk) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
