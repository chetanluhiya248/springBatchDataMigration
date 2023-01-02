package com.selfLearn.springBatchDataMigration.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DatasourceConfigurations {
	
	@Autowired
	private DBKeys dbKeys;

	@Bean
	@Primary
	public DataSource h2DataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbKeys.getDriverClassName1());
		dataSource.setUrl(dbKeys.getUrl1());
		dataSource.setUsername(dbKeys.getUsername1());
		dataSource.setPassword(dbKeys.getPassword1());
		return dataSource;
	}

	//@Bean
	public DataSource derbyDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbKeys.getDriverClassName2());
		dataSource.setUrl(dbKeys.getUrl2());
		dataSource.setUsername(dbKeys.getUsername2());
		dataSource.setPassword(dbKeys.getPassword2());
		return dataSource;
	}

	@Bean
	public DataSource datasourceH2Db(@Qualifier("h2DataSource") DataSource ds)
	{
		return (ds);
	}

	@Bean
	public DataSource datasourceDerbyDb(@Qualifier("derbyDataSource") DataSource ds)
	{
		//return new JdbcTemplate(ds);
		return (ds);
	}

}

