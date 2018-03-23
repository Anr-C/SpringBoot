package com.lckiss.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
//扫描指定包下的mapper
@Configuration
@MapperScan(basePackages = "com.lckiss.mapper.slave",sqlSessionTemplateRef = "slaveAlphaSqlSessionTemplate")
public class DatasourceSecondConfig {
    //第一步：声明一个数据源datasource1     @Primary优先使用该注解标记的bean
    @Bean(name = "slaveAlpha")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveAlphaDataSource(){
        return DataSourceBuilder.create().build();
    }

    //第二步：设置SqlSessionFactory @Qualifier是用于指定bean，需要时会查找该bean然后返回需要的对象
    @Bean(name = "slaveAlphaSqlSessionFactory")
    public SqlSessionFactory slaveAlphaSqlSessionFactory(@Qualifier("slaveAlpha")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        //设置数据源
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean.getObject();
    }

    //第三步：创建事务管理
    @Bean(name = "slaveAlphaDataSourceTransactionManager")
    public DataSourceTransactionManager slaveAlphaDataSourceTransactionManager(@Qualifier("slaveAlpha")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //第四步：创建slaveAlphaSqlSessionTemplate
    @Bean(name = "slaveAlphaSqlSessionTemplate")
    public SqlSessionTemplate slaveAlphaSqlSessionTemplate(@Qualifier("slaveAlphaSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
