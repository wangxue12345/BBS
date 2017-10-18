package activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class activitiTest {
	/** 
     * 生成25张Activiti表 
     */  
    @Test  
    public void testCreateTable() {  
        // 引擎配置  
        ProcessEngineConfiguration pec=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();  
        pec.setJdbcDriver("com.mysql.jdbc.Driver");  
        pec.setJdbcUrl("jdbc:mysql://47.95.224.125:3306/duan?useUnicode=true&characterEncoding=utf8");  
        pec.setJdbcUsername("heymall");  
        pec.setJdbcPassword("HeyMallduan123@126.com!");  
           
        /** 
         * DB_SCHEMA_UPDATE_FALSE 不能自动创建表，需要表存在 
         * create-drop 先删除表再创建表 
         * DB_SCHEMA_UPDATE_TRUE 如何表不存在，自动创建和更新表   
         */  
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);  
           
        // 获取流程引擎对象  
        ProcessEngine processEngine=pec.buildProcessEngine();  
    } 
}
