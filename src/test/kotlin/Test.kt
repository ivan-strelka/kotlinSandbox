import com.codeborne.selenide.Condition.disappear
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class Test {

    @Test
    fun name() {
        open("/login")
        `$`(By.name("user.name")).setValue("johny")
        `$`("#submit").click()
        `$`(".loading_progress").should(disappear) // Само подождёт, пока элемент исчезнет
        `$`("#username").shouldHave(text("Hello, Johny!")) // Само подождёт, пока у элемента появится нужный текст

    }
}