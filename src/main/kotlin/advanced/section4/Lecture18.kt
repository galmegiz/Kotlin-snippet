package advanced.section4

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * DSL : Domain-Specific Language -> 특정 목적의 언어
 */
class Lecture18 {

}

fun main() {
    val yml = dockerCompose {
        version { 3 }
        service(name = "db"){
            image { "mysql" }
            env("USER" - "myuser")
            env("PASSWORD" - "1234")
            port(host = 9999, container = 3306)

          }
    }

    println(yml.render("   "))
}

fun dockerCompose(init: DockerCompose.() -> Unit): DockerCompose {
    val dockerCompose = DockerCompose()

    dockerCompose.init()
    return dockerCompose
}


@YamDsl
class DockerCompose {
    private var version by onceNotNull<Int>()
    private val services = mutableListOf<Service>()

    fun version(init: () -> Int) {
        version = init()
    }

    fun render(indent: String): String {
        val builder = StringBuilder()
        builder.appendNew("version: `$version`")
        builder.appendNew("services:")
        builder.appendNew(
            services.joinToString("\n")
            { it.render(indent) }
                .addIndent(indent, 1)
        )
        return builder.toString()
    }

    fun service(name: String, init: Service.() -> Unit) {
        val service = Service(name)
        service.init()
        services.add(service)
    }
}

@YamDsl
class Service(val name: String){
    private var image: String by onceNotNull()
    private val environments = mutableListOf<Environment>()
    private val portRules = mutableListOf<PortRule>()

    fun image(init: () -> String) {
        this.image = init()
    }

    fun env(environment: Environment) {
        this.environments.add(environment)
    }

    fun port(host: Int, container: Int) {
        this.portRules.add(PortRule(host = host, container = container))
    }

    fun render(indent: String): String {
        val builder = StringBuilder()
        builder.appendNew("$name:")
        builder.appendNew("image: $image", indent, 1)
        builder.appendNew("environments")
        builder.appendNew(
            environments.joinToString("\n") { "- ${it.key}: ${it.value}" }.addIndent(indent, 1)
        )
        builder.appendNew("port:")
        portRules.joinToString("\n") { "- \"${it.host}:${it.container}\"" }
            .addIndent(indent, 1)
            .also { builder.appendNew(it) }

        return builder.toString()
    }
}
data class PortRule(
    val host: Int,
    val container: Int
)

data class Environment(
    val key: String,
    val value: String
)

operator fun String.minus(other: String): Environment {
    return Environment(
        key = this,
        value = other
    )
}

fun <T> onceNotNull() = object : ReadWriteProperty<Any?, T>{
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        requireNotNull(this.value)
        return this.value!!
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        require(this.value == null)
        this.value = value
    }
}

fun StringBuilder.appendNew(str: String, indent: String = "", times: Int = 0) {
    (1..times).forEach { _ -> this.append(indent) }
    this.append(str)
    this.append("\n")
}

fun String.addIndent(indent: String, times: Int = 0): String{
    val allIndent = (1..times).joinToString("") { indent }
    return this.split("\n")
        .joinToString("\n") { "$allIndent$it" }
}

@DslMarker
annotation class YamDsl