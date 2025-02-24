import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Rectangle(val height: Double, val width: Double)

fun main() {

    //val rectangle = Rectangle(42.3, 22.2)
    val rectangle = Json.decodeFromString<Rectangle>("""{"width":42.2, "height": 33.2}""")
    val rectangleList = listOf(rectangle)
    val json = Json.encodeToString(rectangle)
    val json2 = Json.encodeToString(rectangleList)
    println ("json: $json")
    println ("json2: $json2")

}