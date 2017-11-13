package com.zetcode.main;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperResourceBundle {

    public void start() throws JRException {

        String xmlFile = "src/main/resources/report2.xml";
        JasperReport jreport = JasperCompileManager.compileReport(xmlFile);

        ResourceBundle bundle = ResourceBundle.getBundle("in18/labels",
                new Locale("ru", "RU"));   

        HashMap params = new HashMap();
        params.put("REPORT_RESOURCE_BUNDLE", bundle);

        JasperPrint jprint = JasperFillManager.fillReport(jreport, params,
                new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jprint,
                "src/main/resources/report2.pdf");
    }
}
