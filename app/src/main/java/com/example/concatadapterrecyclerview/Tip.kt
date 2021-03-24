package com.example.concatadapterrecyclerview

data class Tip(val description: String)

val tips = listOf(
    Tip("O ConcatAdapter é uma implementação do Adapter do RecyclerView que apresenta conteúdos de múltiplos adapters em sequência, facilitando a nossa vida na hora de apresentar listas com diferentes tipos de visualizações (view types)."),
)