package com.barbeariaapi.tenant;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Override
    public void run(String... args) throws Exception {
        Map<String, DataSource> dataSources = Map.of(
                "PRIME", dataSourceConfig.primeDataSource(),
                "EDGE", dataSourceConfig.edgeDataSource(),
                "FLOW", dataSourceConfig.flowDataSource()
        );

        for (Map.Entry<String, DataSource> entry : dataSources.entrySet()) {
            String tenant = entry.getKey();
            DataSource ds = entry.getValue();

            System.out.println("🔧 Inicializando banco do tenant: " + tenant);

            LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
            emfBean.setDataSource(ds);
            emfBean.setPackagesToScan("com.barbeariaapi.model", "com.barbeariaapi.dominadash");
            emfBean.setJpaVendorAdapter(dataSourceConfig.jpaVendorAdapter());
            emfBean.setPersistenceUnitName("init-" + tenant);

            Map<String, Object> jpaProps = new HashMap<>();
            jpaProps.put("hibernate.hbm2ddl.auto", "update");
            jpaProps.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            emfBean.setJpaPropertyMap(jpaProps);

            emfBean.afterPropertiesSet();

            EntityManager em = emfBean.getObject().createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
        }
    }
}
