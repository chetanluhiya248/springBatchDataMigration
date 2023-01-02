package com.selfLearn.springBatchDataMigration.config;

//import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.selfLearn.springBatchDataMigration.batch.MigrationItemProcessor;
import com.selfLearn.springBatchDataMigration.batch.MigrationItemReader;
import com.selfLearn.springBatchDataMigration.batch.MigrationItemWriter;
import com.selfLearn.springBatchDataMigration.model.MF_Entity;
import com.selfLearn.springBatchDataMigration.model.User;

@SuppressWarnings("removal")
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Autowired
	MigrationItemReader migrationItemReader;
	
	@Autowired
	MigrationItemProcessor migrationItemProcessor;
	
	@Autowired
	MigrationItemWriter migrationItemWriter;
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<MF_Entity> itemReader,
			ItemProcessor<MF_Entity,MF_Entity> itemProcessor,
			ItemWriter<MF_Entity> itemWriter
			) {
		
		Step step = stepBuilderFactory.get("h2-data-read")
				.<MF_Entity,MF_Entity>chunk(50)
				.reader(migrationItemReader)
				.processor(migrationItemProcessor)
				.writer(migrationItemWriter)
				.build();
				
		Step step2  = null;
		
		 Step stepn = null;
		
		Job job = jobBuilderFactory.get("db-migrate")
		.incrementer(new RunIdIncrementer())
		.start(step)
		.next(step2)
		.next(stepn)
		.build();
		return job;
	}
	
	 @Bean
	    public FlatFileItemReader<User> itemReader() {

	        FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
	        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/users.csv"));
	        flatFileItemReader.setName("CSV-Reader");
	        flatFileItemReader.setLinesToSkip(1);
	        flatFileItemReader.setLineMapper(lineMapper());
	        return flatFileItemReader;
	    }

	    @Bean
	    public LineMapper<User> lineMapper() {

	        DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames("id", "name", "dept", "salary");

	        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	        fieldSetMapper.setTargetType(User.class);

	        defaultLineMapper.setLineTokenizer(lineTokenizer);
	        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	        return defaultLineMapper;
	    }
	
}

