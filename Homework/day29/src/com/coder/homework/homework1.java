package com.coder.homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

public class homework1 {
    public static void main(String[] args) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        String className = bundle.getString("class.name");
        String packageName = className.substring(0, className.lastIndexOf("."));
        //System.out.println(packageName);
        className = className.substring(className.lastIndexOf(".") + 1);
        //System.out.println(className);

        StringBuilder stringBuilder = new StringBuilder("package ").append(packageName).append(";\n");
        stringBuilder.append("public class ").append(className).append("{\n");

        String propertiesName = bundle.getString("property.names");
        String propertiesType = bundle.getString("property.types");
        String[] propertiesNames = propertiesName.split(",");
        String[] propertiesTypes = propertiesType.split(",");

        StringBuilder argsBuilder = new StringBuilder();

        for (int i = 0; i < propertiesNames.length; i++) {
            stringBuilder.append("\tprivate ").append(propertiesTypes[i]).append(" ")
                    .append(propertiesNames[i]).append(";\n");
            argsBuilder.append(propertiesTypes[i]).append(" ").append(propertiesNames[i]);
                    if (i != propertiesNames.length - 1)
                        argsBuilder.append(",");
        }
        stringBuilder.append("\tpublic ").append(className).append("() {\n\t}\n");
        stringBuilder.append("\tpublic ").append(className).append("(")
                        .append(argsBuilder).append(") {");
        for (int i = 0; i < propertiesNames.length; i++) {
            stringBuilder.append("\n\t\tthis.").append(propertiesNames[i]).append(" = ").append(propertiesNames[i])
                    .append(";");
        }
        stringBuilder.append("\n\t}\n");
        //getter、setter
        for (int i = 0; i < propertiesNames.length; i++) {
            String property = propertiesNames[i];
            property = Character.toUpperCase(property.charAt(0)) + property.substring(1);
            stringBuilder.append("\tpublic ").append(propertiesTypes[i]).append(" get")
                    .append(property).append("() {\n\t\treturn ")
                    .append(propertiesNames[i]).append(";\n\t}\n");
            stringBuilder.append("\tpublic void set").append(property)
                    .append("(").append(propertiesTypes[i]).append(" ").append(propertiesNames[i])
                    .append(") {\n\t\tthis.").append(propertiesNames[i]).append(" = ")
                    .append(propertiesNames[i]).append(";\n\t}\n");
        }
        //toString
        stringBuilder.append("\tpublic String toString() {\n\t\treturn ")
                        .append("\"").append(className).append("{\" +");
        for (int i = 0; i < propertiesNames.length; i++) {
            stringBuilder.append("\n\t\t\t\t\"").append(propertiesNames[i]).append("='\"")
                    .append(" + ").append(propertiesNames[i]);
            if (i == propertiesNames.length - 1)
                stringBuilder.append(" + \"'}\";");
            else
                stringBuilder.append(" + \"',\" + ");
        }
        stringBuilder.append("\n\t}\n}");
        String base = System.getProperty("user.dir");
        base += "/day29/src/";
        packageName = packageName.replace(".", "/");
        base += packageName;
        File dir = new File(base);
        dir.mkdirs();
        FileWriter fileWriter = new FileWriter(new File(dir, className + ".java"));
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }
}
