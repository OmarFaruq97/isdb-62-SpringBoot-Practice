package com.org.isdb62.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperReportService {

    @Autowired
    private DataSource dataSource;

    public byte[] generateInvoiceReport() throws JRException, SQLException, IOException {
        ClassPathResource resource = new ClassPathResource("/reports/Invoice.jrxml");
        InputStream reportStream = resource.getInputStream();

        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        try (Connection conn = dataSource.getConnection()){
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        }
    }
}
