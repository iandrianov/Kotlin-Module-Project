data class Note(val text: String)
data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())