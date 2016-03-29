package SoftServe.Task_1;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import static SoftServe.Task_1.AnalysisType.*;

public class Analysis {

    private DateTime date = new DateTime(2014,3,28,15,00);
    private String report = "Default report";
    private AnalysisType type = DEFAULT;
    private Analysis(){

    }

    public DateTime getDate() {
        return date;
    }

    public String getReport() {
        return report;
    }

    public AnalysisType getType() {
        return type;
    }

    public static AnalysisBuilder newAnalysisBuilder () {
        return new Analysis().new AnalysisBuilder();
    }

    public class AnalysisBuilder {

        private AnalysisBuilder(){
        }

        public AnalysisBuilder setReport(String report) {
            Analysis.this.report = report;
            return this;
        }

        public AnalysisBuilder setType(AnalysisType type) {
            Analysis.this.type = type;
            return this;
        }

        public AnalysisBuilder setDate(DateTime date) {
            Analysis.this.date = date;
            return this;
        }

        public Analysis build() {
            return Analysis.this;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm");
        return  "Type of analysis - " + type +  ", Date - " + date.toString(format) + ", Report - " + report + "." +"\n";
    }




}
