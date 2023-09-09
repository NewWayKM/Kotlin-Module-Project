import java.util.Scanner

class Menu : AbstractMenu<Archive>()
{
    private val archives: MutableList<Archive> = mutableListOf()

    fun showMenuArchive()
    {
        println("0. Создать архив")
        archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
        println("${archives.size + 1}. Выход \n")
        println("Необходимо ввести номер команды")
        logic(getCommand(archives), archives)
    } // fun showMenuArchive()

    override fun createElement()
    {
        println("Введите название для архива.")
        val name = Scanner(System.`in`).nextLine()

        if (name.isEmpty() )
        {
            println ("Ошибка ввода, нет названия архива")
            showMenuArchive()
        }
        else
        {
            archives.add(Archive(name))
            showMenuArchive()
        }
    } // override fun createElement()

    override fun openElement(t: Archive)
    {
        t.showArchive()
        showMenuArchive()
    } //override fun openElement(t: Archive)

} // class Menu : AbstractMenu<Archive>()
