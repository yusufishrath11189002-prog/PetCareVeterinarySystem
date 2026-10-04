import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.view.JasperViewer;

public class ReporterGenerator {

    public void generateReport() {

        try {
            String reportPath = "src/PetCareReport.jrxml";

            JasperReport report =
                    JasperCompileManager.compileReport(reportPath);

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/petcare_veterinary",
                    "root",
                    ""
            );

            JasperPrint print =
                    JasperFillManager.fillReport(
                            report,
                            new HashMap<>(),
                            con
                    );

            JasperViewer.viewReport(print, false);

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Report Error:\n" + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReporterGenerator().generateReport();
    }
}