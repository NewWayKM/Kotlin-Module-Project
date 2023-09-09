import java.util.Scanner

class Archive(
    val name: String
) : AbstractMenu<Note>()
{
    init
    {
        println("Создан новый архив -> $name \n")
    }

    private var notes: MutableList<Note> = mutableListOf()
    fun showArchive()
    {
        println("Архив $name")
        println("0. Создать заметку")
        notes.forEachIndexed { index, Note -> println("${index + 1}. ${Note.name}") }
        println("${notes.size + 1}. Выход")
        logic(getCommand(notes), notes)
    } //fun showArchive()

    override fun createElement()
    {
        println("Необходимо ввести название заметки")
        val nameNote = Scanner(System.`in`).nextLine()

        println("Введите содержание заметки")
        val contentNote = Scanner(System.`in`).nextLine()

        if ( nameNote.isEmpty() || contentNote.isEmpty() )
        {
            println ("Название или текст заметки отсуствует")
            showArchive()
        }

        else
        {
            notes.add(Note(nameNote, contentNote))
            showArchive()
        }


    } // override fun createElement()

    override fun openElement(t: Note)
    {
        t.showContent()
        showArchive()
    } //override fun openElement(t: Note)


} //class Archive

