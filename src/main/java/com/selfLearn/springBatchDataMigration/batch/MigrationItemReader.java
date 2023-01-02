package com.selfLearn.springBatchDataMigration.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;
import com.selfLearn.springBatchDataMigration.model.MF_Entity;

@Component
public class MigrationItemReader extends JdbcCursorItemReader<MF_Entity> {
//implements ItemReader<User>{

	private static final String QUERY_READ_MF_ENTITY_DATA = "SELECT * FROM MF_ENTITY";

	@Override
	public MF_Entity read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
