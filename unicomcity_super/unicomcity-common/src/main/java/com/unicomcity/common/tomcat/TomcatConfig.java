package com.unicomcity.common.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;
import java.io.File;


/**
 * 使用tomcat配置
 *
 * @version
 * @author
 *
 */
@Configuration
public class TomcatConfig {

    @Value("${unicomcity.server.port}")
    private String port;
    @Value("${unicomcity.server.contextPath}")
    private String contextPath;
    @Value("${unicomcity.server.basedirectory}")
    private String basedirectory;
    @Value("${unicomcity.server.acceptorThreadCount}")
    private String acceptorThreadCount;
    @Value("${unicomcity.server.minSpareThreads}")
    private String minSpareThreads;
    @Value("${unicomcity.server.maxSpareThreads}")
    private String maxSpareThreads;
    @Value("${unicomcity.server.maxThreads}")
    private String maxThreads;
    @Value("${unicomcity.server.maxConnections}")
    private String maxConnections;
    @Value("${unicomcity.server.protocol}")
    private String protocol;
    @Value("${unicomcity.server.redirectPort}")
    private String redirectPort;
    @Value("${unicomcity.server.compression}")
    private String compression;
    @Value("${unicomcity.server.connectionTimeout}")
    private String connectionTimeout;

    @Value("${unicomcity.server.MaxFileSize}")
    private String MaxFileSize;
    @Value("${unicomcity.server.MaxRequestSize}")
    private String MaxRequestSize;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(new GwsTomcatConnectionCustomizer());
        tomcat.addEngineValves(getLogAccessLogValue());
        tomcat.setContextPath(contextPath);
        tomcat.addInitializers((servletContext ->{
            System.out.println("==============================\n" +
                    "==============================\n" +
                    "========  tomcat启动成功！ =======\n" +
                    "==============================\n" +
                    "==============================\n" );
        }));

        return tomcat;
    }
    private AccessLogValve getLogAccessLogValue() {
        AccessLogValve log = new AccessLogValve();
        //日志目录
        log.setDirectory(basedirectory);
        //开始日志
        log.setEnabled(true);
        //日志级别
        log.setPattern("common");
        //日志前缀
        log.setPrefix("unicomcity-access-log");
        //日志后缀
        log.setSuffix(".log");
        return log;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        //factory.setMaxFileSize(MaxFileSize); // KB,MB
        /// 总上传数据大小
       // factory.setMaxRequestSize(MaxRequestSize);
        return factory.createMultipartConfig();
    }

    /**
     *
     * 默认http连接
     *
     * @version
     * @author 刘冰
     *
     */
    public class GwsTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

        public GwsTomcatConnectionCustomizer() {
        }

        @Override
        public void customize(Connector connector) {
            connector.setPort(Integer.valueOf(port));
            connector.setAttribute("connectionTimeout", connectionTimeout);
            connector.setAttribute("acceptorThreadCount", acceptorThreadCount);
            connector.setAttribute("minSpareThreads", minSpareThreads);
            connector.setAttribute("maxSpareThreads", maxSpareThreads);
            connector.setAttribute("maxThreads", maxThreads);
            connector.setAttribute("maxConnections", maxConnections);
            connector.setAttribute("protocol", protocol);
            connector.setAttribute("redirectPort", "redirectPort");
            connector.setAttribute("compression", "compression");
        }
    }
}
