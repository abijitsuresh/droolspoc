package com.abijit.droolspoc.config;

import lombok.extern.log4j.Log4j2;
import org.drools.decisiontable.DecisionTableProviderImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Log4j2
@Configuration
public class DroolsConfig {
    private static final List<String> RULES_XLSX_LIST = List.of("rules/rules-that-return-list.xlsx",
            "rules/rules-that-return-single-item.xlsx",
            "rules/rules-that-return-single-item-with-subObject.xlsx");
    private static final KieServices KIE_SERVICES = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        KieFileSystem kieFileSystem = KIE_SERVICES.newKieFileSystem();
        for (var path : RULES_XLSX_LIST) {
            Resource dt = ResourceFactory.newClassPathResource(path, getClass());
            DecisionTableConfiguration configuration = KnowledgeBuilderFactory.newDecisionTableConfiguration();
            configuration.setInputType(DecisionTableInputType.XLSX);
            DecisionTableProviderImpl decisionTableProvider = new DecisionTableProviderImpl();
            String drl = decisionTableProvider.loadFromResource(dt, configuration);
            log.info("drl conversion from excel: {}", drl);
            kieFileSystem.write(dt);
        }
        KieBuilder kieBuilder = KIE_SERVICES.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        return KIE_SERVICES.newKieContainer(kieModule.getReleaseId());
    }
}
