package org.axp.springbootcouchbase.config;

import javax.swing.text.DefaultStyledDocument;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCouchbaseRepositories(basePackages = "org.axp.springbootcouchbase.mvc")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("#{''.split(',')}")
    private List<String> couchbasehosts;

    @Value("sampleData")
    private String couchbaseBucketName;

    @Value("Amex1234")
    private String couchbaseBucketPassword;

    @Value("15000")
    private Long couchbaseConnectionTimeoout;

    @Aurowired
    private CouchbaseEnvironment couchbaseEnvironment;

    @Override
    protected List<String> getBootstrapHosts() { return couchbasehosts; }

    @Override
    protected String getBucketName() { return couchbaseBucketName; }

    @Override
    protected String getBucketPassword() { return couchbaseBucketPassword; }

    @Override
    protected CouchbaseEnvironment getEnvironment() {
        CouchbaseEnvironment couchbaseEnvironment = DefaultCouchbaseEnvironment
                .builder()
                .defaultMetricsLoggingConsumer(true, CouchbaseLogLevel.TRACE, LoggingConsumer.OutputFormat.JSON_PRETTY)
                .runtimeMetricsCollectionConfig(DefaultMetricsCollectorConfig.create(30, TimeUnit.SECONDS))
                .sslEnabled(true)
                .sslKeystoreFile("")
                .sslKeystorePassword("changeit")
                .networkLatencyMetricsCollectorConfig(DefaultLatencyMetricsCollectorConfig.create(30, TimeUnit.SECONDS))
                .dnsSrvEnabled(false)
                .connectTimeout(couchbaseconnectionTimeout)
                .build();
        return couchbaseEnvironment;

    }

    @PostConstruct
    public void init(){
        couchbaseEnvironment.eventBus().get().subscribe(event ->
            System.out.println(event));
    }
}

