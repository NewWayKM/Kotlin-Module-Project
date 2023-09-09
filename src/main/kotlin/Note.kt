class Note
    (
    val name: String,
    private val content: String
) {
    init
    {
        println("Заметка создана -> $name \n")
    }

    fun showContent()
    {
        println("Заметка: $name")
        println(content)
    }
}
