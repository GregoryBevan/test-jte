package testjte

import fr.rca.testjte.Content
import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.output.StringOutput
import gg.jte.resolve.ResourceCodeResolver
import org.junit.jupiter.api.Test
import java.nio.file.Path

internal class JteTest {

    @Test
    fun `should render template`() {
        val templateEngine =
            TemplateEngine.create(ResourceCodeResolver("templates"), Path.of("target/jte-classes"), ContentType.Plain)
        StringOutput().also {
            templateEngine.render("xml.kte", mapOf("content" to Content()), it)
        }.also { output -> println(output.toString()) }

    }

}