import org.apache.spark.sql.{Dataset, SparkSession}
import org.apache.spark.sql.functions._

case class Metrics(pageViews: Long, uniqueVisitors:, Long, topReferrers:, Array[String])

object MetricsCalculator {
    def calculateMetrics(logs: Dataset[WebLog])(implicit spark: SparkSession): Metrics = {
        import spark.implicits._

        val pageViews = logs.count()
        val uniqueVisitors = logs.select("ip").distinct().count()

        val topReferrers = logs
            .filter($"referrer" =!= "-")
            .groupBy("referrer")
            .count()
            .orderBy(desc("count"))
            .limit(5)
            .select("referrer")
            .as[String]
            .collect()

        Metrics(pageViews, uniqueVisitors, topReferrers)
    }
}