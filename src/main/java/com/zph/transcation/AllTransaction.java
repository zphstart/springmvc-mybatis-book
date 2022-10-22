package com.zph.transcation;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @auther zph
 * @date 2022/9/25 - 17:46
 * spring事务组成：DataSource,TransactionManager,代理机制
 */
public class AllTransaction {
    @Resource
    private DataSourceTransactionManager dataSourceTransactionManager;
}
