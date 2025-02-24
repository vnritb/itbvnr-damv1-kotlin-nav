import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class Project(val name: String, val owner: User)
@Serializable
class User(val name: String)


fun main() {
    val owner = User("kotlin")
    val data = Project("kotlinx.serialization", owner)
    println(Json.encodeToString(data))
}