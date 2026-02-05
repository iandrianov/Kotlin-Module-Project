fun selectMenuItem(
    title: String,
    items: List<String>
): Int {
    while (true) {
        println()
        println(title)
        items.forEachIndexed { index, item ->
            println("$index. $item")
        }
        print("Введите команду: ")

        val input = readlnOrNull()?.toIntOrNull()
        if (input != null && input in items.indices) {
            return input
        }

        println("Некорректный ввод, попробуйте ещё раз")
    }
}