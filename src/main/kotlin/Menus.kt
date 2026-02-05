import kotlin.system.exitProcess


fun archiveScreen() {
    val items = mutableListOf("Создать архив")
    items.addAll(archives.map { it.name })
    items.add("Выход")

    when (val choice = selectMenuItem("Архивы:", items)) {
        0 -> createArchiveScreen()
        in 1..archives.size -> openArchiveScreen(archives[choice - 1])
        else -> exitProcess(0)
    }
}


fun createArchiveScreen() {
    val items = listOf(
        "Ввести название архива",
        "Назад"
    )

    when (selectMenuItem("Экран создания архива:", items)) {
        0 -> createArchive()
        1 -> return
    }
}

fun createArchive() {
    while (true) {
        print("Введите название архива: ")
        val name = readlnOrNull()

        if (name.isNullOrBlank()) {
            println("Название архива не может быть пустым")
            continue
        }

        archives.add(Archive(name))
        println("Архив создан")
        return
    }
}


fun openArchiveScreen(archive: Archive) {
    val items = mutableListOf("Создать заметку")

    items.addAll(
        archive.notes.map { note ->
            note.text.take(10)
        }
    )

    items.add("Назад")

    when (val choice = selectMenuItem("Архив: ${archive.name}", items)) {
        0 -> createNotesScreen(archive)
        in 1..archive.notes.size -> noteScreen(archive.notes[choice - 1])
        else -> return
    }
}


fun noteScreen(note: Note) {
    println()
    println("Текст заметки:")
    println(note.text)

    selectMenuItem(
        "Меню:",
        listOf("Назад")
    )
}


fun createNotesScreen(archive: Archive) {
    while (true) {
        println("Создание заметки в архиве: ${archive.name}")
        print("Введите текст заметки: ")

        val text = readlnOrNull()

        if (text.isNullOrBlank()) {
            println("Текст заметки не может быть пустым")
            continue
        }


        archive.notes.add(Note(text))
        println("Заметка добавлена")
        return
    }
}
