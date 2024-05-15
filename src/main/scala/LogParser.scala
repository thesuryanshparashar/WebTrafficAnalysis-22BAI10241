import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql.Encoders

case class WebLog(ip: String, timestamp: String, request: String, referrer: Srting)

object LogParser {
    def parseLogs(logData: String)(implicit spark: SparkSession): Dataset[WebLog] = {
        import spark.implicits._

        val logLines = logData.split("\n")
        val logEncoder = Encoders.product[WebLog]

        val logs = logLines.map { line => 
            val parts = line.split(" ")
            val ip = parts(0)
            val timestamp = s"$parts(3) parts(4)"
            val request = s"$parts(5) $parts(6) $parts(7)"
            val referrer = if (parts.length > 10) parts(10) else "-"
            WebLog(ip, timestamp, request, referrer)
        }

        spark.createDataset(logs)(logEncoder)
    }
}