package com.panguaxe.sky.utils;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MyBatisGeneratorUtil  implements CommentGenerator {

    /**properties配置文件*/
    private Properties properties;
    /**properties配置文件*/
    private Properties systemPro;
    /**父类时间*/
    private boolean suppressDate;
    /**父类所有注释*/
    private boolean suppressAllComments;
    /**当前时间*/
    private String currentDateStr;

    public MyBatisGeneratorUtil() {
        this.properties = new Properties();
        this.systemPro = System.getProperties();
        this.suppressDate = false;
        this.suppressAllComments = false;
        this.currentDateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          Java类的类注释
     * @Date: 2019年07月01日 09:05
     * @param innerClass
     * @param introspectedTable
     * @return void
     **/
    @Override
    public void addClassComment(final InnerClass innerClass, final IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        sb.append(this.getDateString());
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        innerClass.addJavaDocLine(" */");
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              为类添加注释
     * @Date: 2019年07月01日 09:06
     * @param innerClass
     * @param introspectedTable
     * @param markAsDoNotDelete
     * @return void
     **/
    @Override
    public void addClassComment(final InnerClass innerClass, final IntrospectedTable introspectedTable, final boolean markAsDoNotDelete) {
        if (this.suppressAllComments) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append(" * @author ");
        sb.append(this.systemPro.getProperty("user.name"));
        sb.append(" ");
        sb.append(this.currentDateStr);
        innerClass.addJavaDocLine(" */");
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              Mybatis的Mapper.xml文件里面的注释
     * @Date: 2019年07月01日 09:07
     * @param xmlElement
     * @return void
     **/
    @Override
    public void addComment(final XmlElement xmlElement) {
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              从该配置中的任何属性添加此实例的属性CommentGenerator配置。这个方法将在任何其他方法之前被调用。
     * @Date: 2019年07月01日 09:09
     * @param properties
     * @return void
     **/
    @Override
    public void addConfigurationProperties(final Properties properties) {
        this.properties.putAll(properties);
//        this.suppressDate = this.isTrue(properties.getProperty("suppressDate"));
//        this.suppressAllComments = this.isTrue(properties.getProperty("suppressAllComments"));
        this.suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        this.suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }
    private boolean isTrue(final String property) {
        return false;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              此方法返回格式化的日期字符串以包含在Javadoc标记中和XML注释。 如果您不想要日期，则可以返回null在这些文档元素中。
     * @Date: 2019年07月01日 09:12
     * @param
     * @return java.lang.String
     **/
    protected String getDateString() {
        String result = null;
        if (!this.suppressDate) {
            result = this.currentDateStr;
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              此方法为其添加了自定义javadoc标签。
     * @Date: 2019年07月01日 09:12
     * @param javaElement
     * @param markAsDoNotDelete
     * @return void
     **/
    protected void addJavadocTag(final JavaElement javaElement, final boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge");
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              为枚举添加注释
     * @Date: 2019年07月01日 09:13
     * @param innerEnum
     * @param introspectedTable
     * @return void
     **/
    @Override
    public void addEnumComment(final InnerEnum innerEnum, final IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        innerEnum.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
        innerEnum.addJavaDocLine(" */");
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              Java属性注释
     * @Date: 2019年07月01日 09:14
     * @param field
     * @param introspectedTable
     * @return void
     **/
    @Override
    public void addFieldComment(final Field field, final IntrospectedTable introspectedTable) {
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              为字段添加注释
     * @Date: 2019年07月01日 09:15
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     * @return void
     **/
    @Override
    public void addFieldComment(final Field field, final IntrospectedTable introspectedTable, final IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        sb.append("\n");
        sb.append("	* 列名:" + introspectedColumn.getActualColumnName() + " 类型:" + introspectedColumn.getJdbcTypeName()
                + "(" + introspectedColumn.getLength() + ")" + " 允许空:" + introspectedColumn.isNullable() + " 缺省值:"
                + introspectedColumn.getDefaultValue());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              普通方法的注释，这里主要是XXXMapper.java里面的接口方法的注释
     * @Date: 2019年07月01日 09:16
     * @param method
     * @param introspectedTable
     * @return void
     **/
    @Override
    public void addGeneralMethodComment(final Method method, final IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/**");
        sb.append("\n");
        sb.append("	* ");
        sb.append("\n");
        sb.append("	* @Author 作者：Panguaxe" + "\n");
        if (!suppressDate) {
            sb.append("	* @date " + currentDateStr + "\n");
        }
        List<Parameter> parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            sb.append("	* @param " + parameter.getName() + "\n");
        }
        sb.append("	* @return " + method.getReturnType());
        sb.append("\n" + "	*/");
        method.addJavaDocLine(sb.toString());
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              给getter方法加注释
     * @Date: 2019年07月01日 09:17
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     * @return void
     **/
    @Override
    public void addGetterComment(final Method method, final IntrospectedTable introspectedTable, final IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }
        method.addJavaDocLine("/**");
        final StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append(" * @return ");
        sb.append(introspectedColumn.getActualColumnName());
        sb.append(" ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        method.addJavaDocLine(" */");
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO                  给setter方法加注释
     * @Date: 2019年07月01日 09:17
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     * @return void
     **/
    @Override
    public void addSetterComment(final Method method, final IntrospectedTable introspectedTable, final IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }
        method.addJavaDocLine("/**");
        final StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        final Parameter parm = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param ");
        sb.append(parm.getName());
        sb.append(" ");
        sb.append(introspectedColumn.getRemarks());
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        method.addJavaDocLine(" */");
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO                  给Java文件加注释，这个注释是在文件的顶部，也就是package上面。
     * @Date: 2019年07月01日 09:18
     * @param compilationUnit
     * @return void
     **/
    @Override
    public void addJavaFileComment(final CompilationUnit compilationUnit) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        compilationUnit.addFileCommentLine("/*");
        compilationUnit.addFileCommentLine("*");
        compilationUnit.addFileCommentLine("* "+compilationUnit.getType().getShortName()+".java");
        compilationUnit.addFileCommentLine("* Copyright(C) 2017-2020 Panguaxe公司");
        compilationUnit.addFileCommentLine("* @date "+sdf.format(new Date())+"");
        compilationUnit.addFileCommentLine("*/");
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO                  为调用此方法作为根元素的第一个子节点添加注释。
     * @Date: 2019年07月01日 09:19
     * @param rootElement
     * @return void
     **/
    @Override
    public void addRootComment(final XmlElement rootElement) {
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO                  为模型类添加注释
     * @Date: 2019年07月01日 09:19
     * @param arg0
     * @param arg1
     * @return void
     **/
    @Override
    public void addModelClassComment(final TopLevelClass arg0, final IntrospectedTable arg1) {
    }
}
