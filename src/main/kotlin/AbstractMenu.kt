import java.util.Scanner

abstract class AbstractMenu<T>
{


    abstract fun createElement()

    abstract fun openElement(t: T)

    fun getCommand(elements: MutableList<T>): Int
    {
        var number: String = Scanner(System.`in`).nextLine()
        while (true) number = if (checkNumber(number))
        {
            println("Ошибка ввода, необходимо ввести цифру")
            Scanner(System.`in`).nextLine()
        }

        else if ((number.toInt() > (elements.size + 1)) or (number.toInt() < 0))
        {
            println("Ошибка ввода, пункт отсутствует")
            Scanner(System.`in`).nextLine()
        }

        else return number.toInt()
    } // fun getCommand(elements: MutableList<T>): Int

    fun logic(number: Int, elements: MutableList<T>)
    {
        when (number)
        {
            0 ->
            {
                createElement()
            }
            (elements.size + 1) -> {
                return
            }
            else ->
            {
                openElement(elements[number - 1])
            }
        }

    } // fun logic(number: Int, elements: MutableList<T>)

    fun checkNumber(string: String): Boolean
    {
        return try
        {
            string.toInt()
            false

        } catch (e: NumberFormatException)
        {
            true
        }
    }//private fun checkNumber(string: String): Boolean
} // abstract class AbstractMenu<T>
