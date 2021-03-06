package net.javajs.rbd.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages= {"com.example.demo.service"})
@EnableTransactionManagement
public class ExMariaConfig {
    private static final int TX_METHOD_TIMEOUT = 3;
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.example..*ServiceImpl.*(..))";
    @Autowired
    private DataSourceTransactionManager transactionManager;
 
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource getDataSource() {

        return DataSourceBuilder.create().build();
    }
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

    @Bean
    public TransactionInterceptor txAdvice() {
    	TransactionInterceptor txAdvice = new TransactionInterceptor();
    	Properties txAttributes = new Properties();
    	List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
    	rollbackRules.add(new RollbackRuleAttribute(Exception.class));
    	DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED);
    	readOnlyAttribute.setReadOnly(true);
    	readOnlyAttribute.setTimeout(TX_METHOD_TIMEOUT);
        RuleBasedTransactionAttribute writeAttribute = new RuleBasedTransactionAttribute(TransactionDefinition.PROPAGATION_REQUIRED, rollbackRules);
        writeAttribute.setTimeout(TX_METHOD_TIMEOUT);
		String readOnlyTransactionAttributesDefinition = readOnlyAttribute.toString();
		String writeTransactionAttributesDefinition = writeAttribute.toString();
		txAttributes.setProperty("select*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("get*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("search*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("find*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("count*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("*", writeTransactionAttributesDefinition);
		txAdvice.setTransactionAttributes(txAttributes);
		txAdvice.setTransactionManager(transactionManager);
        return txAdvice;
    }
    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("(execution(* com.example.demo..*ServiceImpl.*(..))");
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}