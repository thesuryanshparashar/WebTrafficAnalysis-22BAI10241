import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import os._

object WebTrafficAnalysis {
    def main(args: Array[String]): Unit = {
        val spark = SparkSession.builder()
            .appName("WebTrafficAnalysis")
            .master("local[*]")
            .getOrCreate()

        val logFilePath = os.pwd / "src" / "main" / "resources" / "webserver.log"
        val logData = os.read(logFilePath)

        val parsedLogs = LogParser.parseLogs(logData)

        val metrics = MetricsCalculator.calculateMetrics(parsedLogs)

        Visualization.visualizeMetrics(metrics)

        spark.stop()
    }
}