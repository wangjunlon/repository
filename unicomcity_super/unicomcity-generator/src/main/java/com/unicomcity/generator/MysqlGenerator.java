package com.unicomcity.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MysqlGenerator{
    private final static String userdir = "user.dir";//文件根路径
    private final static String projectname = "unicomcity-generator";//项目名称
    private final static String srcpath = "src/main/java";//代码目录
    private  final static String mysqlurl = "jdbc:mysql://183.214.161.82:13306/BFish?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";//mysql连接URL
    private  final static String mysqldriver= "com.mysql.cj.jdbc.Driver";//mysql驱动
    private  final static String mysqlusername= "root";//mysql用户名
    private  final static String mysqlpassword= "p@ssW0rd";//mysql密码
    private  final static String templates="/templates/mapper.xml.btl";
    private final static String outputFilepath="com.unicomcity.";
    private static AutoGenerator mpg = new AutoGenerator();
    private static String getFilePath(){
        String projectPath = System.getProperty(userdir);
        return projectPath;
    }

    public static boolean GlobalConfigInit(String author){
        String projectPath = getFilePath()+File.separator+projectname+File.separator+srcpath;
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath);//生成文件的输出目录
        gc.setAuthor(author);//开发人员
        gc.setOpen(false);// 是否打开输出目录
        gc.setFileOverride(true);        // 是否覆盖已有文件
        gc.setSwagger2(false);//开启 swagger2 模式
        gc.setIdType(IdType.AUTO);//指定生成的主键的ID类型
        mpg.setGlobalConfig(gc);
        return true;
    }

    public static boolean DataSourceInit(String author){
        boolean globalConfigInit = GlobalConfigInit(author);
        if(globalConfigInit) {
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl(mysqlurl);
            dsc.setDriverName(mysqldriver);
            dsc.setUsername(mysqlusername);
            dsc.setPassword(mysqlpassword);
            mpg.setDataSource(dsc);
            return true;
        }
        return  false;
    }

    public static boolean PackageConfigInit(String author,String projname){
        boolean dataSourceInit = DataSourceInit(author);
        String path = outputFilepath+projname;
        if(dataSourceInit) {
            PackageConfig pc = new PackageConfig();
            pc.setParent(path);
            mpg.setPackageInfo(pc);
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                }
            };
            List<FileOutConfig> focList = new ArrayList<>();
            focList.add(new FileOutConfig(templates) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String projectPath = getFilePath() + File.separator + projectname + File.separator +"src\\main\\java"+ File.separator+ path.replaceAll("\\.", Matcher.quoteReplacement(File.separator)) +  File.separator +"mapper" + File.separator + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                    return projectPath;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
            return true;
        }
        return false;
    }

    public static boolean TemplateConfigInit(String author,String projname){
        boolean packageConfigInit = PackageConfigInit(author,projname);
        if(packageConfigInit) {
            TemplateConfig templateConfig = new TemplateConfig();
            templateConfig.setEntity("/templates_custom/entity.java");
            templateConfig.setMapper("/templates_custom/mapper.java");
            templateConfig.setService("/templates_custom/service.java");
            templateConfig.setServiceImpl("/templates_custom/serviceImpl.java");
            templateConfig.setController("/templates_custom/controller.java");
            templateConfig.setXml(null);
            mpg.setTemplate(templateConfig);
            return true;
        }
        return false;
    }

    public static void Generator(String tablename,String author,String projname){
        boolean templateConfigInit = TemplateConfigInit(author,projname);
        if(templateConfigInit) {
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            strategy.setEntityTableFieldAnnotationEnable(true);
            strategy.setInclude(tablename.split(","));
            strategy.setControllerMappingHyphenStyle(false);
            strategy.setRestControllerStyle(true);
            mpg.setStrategy(strategy);
            // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
            mpg.setTemplateEngine(new BeetlTemplateEngine());
            mpg.execute();
        }
    }

    public static void main(String[] args) {
        Generator("course," + "course_base," + "course_reserve," + "course_task," + "course_teacher," + "course_timetable","王军龙","education");
    }

}
