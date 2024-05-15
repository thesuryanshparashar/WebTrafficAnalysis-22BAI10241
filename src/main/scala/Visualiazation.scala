import org.known.xchart.{PieChartBuilder, PieChart, BitmapEncoder}
import org.known.xchart.style.Styler

object Visualization {
    def visualizeMetrics(metrics: Metrics): Unit = {
        val chart = new PieChartBuilder().width(800).height(600).title("Top Referrers")

        chart.getStyler.setLegendVisible(true)
        chart.getStyler.setAnnotationType(Styler.AnnotationType.LabelAndPercentage)
        chart.getStyler.setAnnotationDistance(1.15)

        metrics.topReferrers.foreach { referrer =>
            chart.addSeries(referrer, metrics.pageViews)
        }

        BitmapEncoder.saveBitmap(chart, "top-referrers", BitmapEncoder.BitmapFormat.PNG)
        println("Saved the top referrers pir chart to top-referrers.png")
    }
}